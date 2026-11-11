package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;

import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main() {
        int opc;
        do{
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1:{

                }break;
                case 2:{

                }break;
                case 3:{

                }break;
                case 4:{

                }break;
                case 5:{

                }break;
                case 6:{

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
        System.out.print("Ingrese el nombre: ");
        String nombre = Validacion.leerString("Ingresa el nombre");
        System.out.print("Ingrese la categoria: ");
        String categoria = Validacion.leerString("Ingresa la categoria");
        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());
    }

}
