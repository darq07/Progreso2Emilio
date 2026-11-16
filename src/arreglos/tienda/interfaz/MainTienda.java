package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.*;
import utilitario.Validacion;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main() {
        int opc;
        tienda.cargarDatos();
        do{
            menu();
            opc = Validacion.leerOpcion("");
            switch (opc){
                case 1:{
                    ingresarJuegos();
                }break;
                case 2:{
                    System.out.println(tienda.sacarJuegos());
                }break;
                case 3:{
                    buscar();
                }break;
                case 4:{
                    comprar();
                }break;
                case 5:{
                    vender();
                }break;
                case 6:{
                    String nombre = tienda.juegoMasVendido();
                    if(!nombre.isEmpty()){
                        System.out.println("Juego mas vendido: " + nombre);
                    }else{
                        System.out.println("No hay juegos para mostrar");
                    }
                }break;
                case 7:{
                    System.out.println("Gracias por usar nuestros servicios");
                }break;
                default:
                    System.out.println("No es una opción válida");
            }
        }while(opc != 7);
    }
    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void ingresarJuegos(){
        System.out.println("*******Ingreso de datos********");
        String nombre = Validacion.leerString("Ingrese el nombre");
        String categoria = Validacion.leerString("Ingrese la categoria");
        int tamanio = Validacion.leerEntero("Ingrese el tamanio");
        double precio = Validacion.leerDouble("Ingrese el precio");
        int licenciasDisponibles = Validacion.leerEntero("Ingrese el stock inicial");
        if (tienda.agregarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null, "El juego se ha agregado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "El juego no pudo ser agregado");
        }
    }
    /*  public static void mostrarJuegos(){

        codigo si mi clase appstore no tiene el metodo para mostrar todos los juegos
        Juego juegos[] = tienda.getJuegos();
        if (tienda.getIndice() != -1) {
            for (int i = 0; i <= tienda.getIndice(); i++) {
                System.out.println(juegos[i]);
            }
        }else{
            System.out.println("No hay juegos para mostrar");
        }
    }

         */
    public static void buscar(){
        String nombre = Validacion.leerString("Ingrese el nombre del juego");
        Juego j1 = tienda.buscarJuego(nombre);
        if(j1 != null){
            System.out.println(j1);
        }else{
            System.out.println("No se encontro el juego " + nombre);
        }
    }
    public static void comprar(){
        String nombre = Validacion.leerString("Ingrese el nombre del juego");
        int cantidad = Validacion.leerEntero("Ingrese la cantidad");

        if(tienda.comprar(nombre, cantidad)){
            System.out.println("Compra realizada correctamente");
            System.out.println("Juego: " + nombre);
            System.out.println("Cantidad comprada: " + cantidad);
        }else{
            System.out.println("No se pudo comprar el juego");
        }
    }
    public static void vender(){
        String nombre = Validacion.leerString("Ingrese el nombre del juego");
        int cantidad = Validacion.leerEntero("Ingrese la cantidad");

        double pago = tienda.vender(nombre, cantidad);

        if(pago > 0){
            System.out.println("Venta realizada correctamente");
            System.out.println("Juego: " + nombre);
            System.out.println("Cantidad vendida: " + cantidad);
            System.out.println("Valor a cancelar: $" + pago);
        }else{
            System.out.println("No ha sido posible vender el juego " + nombre);
        }
    }
}
