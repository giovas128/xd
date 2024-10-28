package Agregado;

import java.util.Scanner;

public class Principal {

    static int t = 0;
    static int opt = 0;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Operaciones op = new Operaciones();

        System.out.println("Ingrese el tamaño de la pila");
        while (!teclado.hasNextInt()) {
            System.out.println("Error: solo se permiten números. Intente de nuevo.");
            teclado.next();
        }
        t = teclado.nextInt();
        teclado.nextLine(); // Limpiar el buffer

        do {
            menu();
            while (!teclado.hasNextInt()) {
                System.out.println("Error: solo se permiten números. Intente de nuevo.");
                teclado.next();
            }
            opt = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer

            switch (opt) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar: ");
                    String dato = teclado.nextLine();
                    op.agregar(dato);
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a agregar: ");
                    String datoP = teclado.nextLine();
                    op.agregarP(datoP);
                    break;
                case 3:
                    System.out.print("Ingrese el elemento a agregar: ");
                    String datoU = teclado.nextLine();
                    op.agregarU(datoU);
                    break;
                case 4:
                    System.out.print("Ingrese el elemento a agregar: ");
                    String nuevoDato = teclado.nextLine();
                    System.out.print("Ingrese la posición donde agregarlo: ");
                    int posicion = teclado.nextInt();
                    teclado.nextLine(); // Limpiar el buffer
                    op.agregarE(nuevoDato, posicion);
                    break;
                case 5:
                    op.mostrar();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opt != 6);
        teclado.close(); // Cerrar el escáner
    }

    public static void menu() {
        System.out.println("Menu:\n"
                + "1-Agregar\n"
                + "2-Agregar primero\n"
                + "3-Agregar último\n"
                + "4-Agregar Especial\n"
                + "5-Mostrar\n"
                + "6-Salir");
    }
}
