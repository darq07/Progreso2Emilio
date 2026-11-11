package validacion;

import java.util.Scanner;

public class Validacion {
    private static final Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El campo no puede estar vacio.");
        }
    }

    public static int leerEntero(String mensaje, int minimo) {
        return leerEntero(mensaje, minimo, Integer.MAX_VALUE);
    }

    public static int leerEntero(String mensaje, int minimo, int maximo) {
        while (true) {
            System.out.print(mensaje + ": ");
            String texto = sc.nextLine().trim();
            try {
                int numero = Integer.parseInt(texto);
                if (numero >= minimo && numero <= maximo) {
                    return numero;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Ingrese un numero entero entre " + minimo + " y " + maximo + ".");
        }
    }

    public static double leerDecimalPositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            String texto = sc.nextLine().trim().replace(',', '.');
            try {
                double numero = Double.parseDouble(texto);
                if (Double.isFinite(numero) && numero > 0) {
                    return numero;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Ingrese un numero mayor que cero.");
        }
    }
}
