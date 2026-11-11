package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;
import validacion.Validacion;

public class MainTienda {
    private static final AppStore tienda = new AppStore();

    static void main() {
        int opc;
        do {
            menu();
            opc = Validacion.leerEntero("Ingrese una opcion", 1, 7);
            switch (opc) {
                case 1: {
                    ingresarJuegos();
                } break;
                case 2: {
                    System.out.println(tienda.sacarJuegos());
                } break;
                case 3: {
                    buscarJuego();
                } break;
                case 4: {
                    comprarJuego();
                } break;
                case 5: {
                    venderJuego();
                } break;
                case 6: {
                    System.out.println("Juego mas vendido: " + tienda.juegoMasVendido());
                } break;
                case 7: {
                    System.out.println("Gracias por usar nuestros servicios");
                } break;
            }
        } while (opc != 7);
    }

    public static void menu() {
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego mas vendido");
        System.out.println("7. Salir");
    }

    public static void ingresarJuegos() {
        if (tienda.estaLlena()) {
            System.out.println("No se pueden ingresar mas juegos.");
            return;
        }
        String nombre = Validacion.leerString("Ingrese el nombre");
        if (tienda.buscarJuego(nombre) != null) {
            System.out.println("Ya existe un juego con ese nombre.");
            return;
        }
        String categoria = Validacion.leerString("Ingrese la categoria");
        int tamanio = Validacion.leerEntero("Ingrese el tamanio", 1);
        double precio = Validacion.leerDecimalPositivo("Ingrese el precio");
        int licenciasDisponibles = Validacion.leerEntero("Ingrese el stock inicial", 0);
        if (tienda.agregarJuego(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))) {
            System.out.println("Juego registrado correctamente.");
        }
    }

    public static void buscarJuego() {
        String nombre = Validacion.leerString("Nombre del juego a buscar");
        Juego juego = tienda.buscarJuego(nombre);
        if (juego == null) {
            System.out.println("Juego no encontrado.");
            return;
        }
        System.out.println(juego);
    }

    public static void comprarJuego() {
        String nombre = Validacion.leerString("Nombre del juego a comprar");
        int cantidad = Validacion.leerEntero("Cantidad de licencias a comprar", 1);
        if (tienda.comprar(nombre, cantidad)) {
            System.out.println("Compra registrada. Stock actualizado.");
            return;
        }
        System.out.println("No se pudo realizar la compra. Verifique el juego o la cantidad.");
    }

    public static void venderJuego() {
        String nombre = Validacion.leerString("Nombre del juego a vender");
        int cantidad = Validacion.leerEntero("Cantidad de licencias a vender", 1);
        double total = tienda.vender(nombre, cantidad);
        if (total > 0) {
            System.out.println("Venta realizada. Total: $" + total);
            return;
        }
        System.out.println("No se pudo vender. Verifique el juego y el stock disponible.");
    }
}
