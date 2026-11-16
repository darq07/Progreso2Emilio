package utilitario;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje){
        String nombre;
        do {
            System.out.print(mensaje + " : ");
            nombre = sc.nextLine();
        }while(nombre==null || nombre.trim().isEmpty());
        return nombre;
    }

    public static int leerEntero(String mensaje){
        int numero = 0;
        boolean valido = false;
        do{
            System.out.print(mensaje + " : ");
            String dato = sc.nextLine();
            try{
                numero = Integer.parseInt(dato);
                if(numero > 0){
                    valido = true;
                }else{
                    System.out.println("Ingrese un numero mayor a cero");
                }
            }catch(NumberFormatException e){
                System.out.println("Ingrese un numero entero valido");
            }
        }while(!valido);
        return numero;
    }

    public static double leerDouble(String mensaje){
        double numero = 0;
        boolean valido = false;
        do{
            System.out.print(mensaje + " : ");
            String dato = sc.nextLine();
            try{
                numero = Double.parseDouble(dato);
                if(Double.isFinite(numero) && numero > 0){
                    valido = true;
                }else{
                    System.out.println("Ingrese un numero mayor a cero");
                }
            }catch(NumberFormatException e){
                System.out.println("Ingrese un numero valido");
            }
        }while(!valido);
        return numero;
    }

    public static int leerOpcion(String mensaje){
        int opcion = -1;
        System.out.print(mensaje);
        try{
            opcion = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Ingrese una opcion numerica");
        }
        return opcion;
    }
}
