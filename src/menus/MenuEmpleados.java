package menus;

import java.util.Scanner;

public class MenuEmpleados {
    static Scanner scanner = new Scanner(System.in);
    public static void menuGerente(){
        String action;
        do {
            System.out.println("1 - Registrar inversionista");
            System.out.println("2 - Modificar inversionista");
            System.out.println("3 - Eliminar inversionista");
            System.out.println("4 - Buscar inversionista");
            System.out.println("5 - Ver fondos del banco");
            System.out.println("6 - Autorizar tarjeta");
            System.out.println("7 - Ver solicitudes de tarjetas");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    // metodo para verificar contraseña extra

                    break;
                case "2":
                    // metodo para verificar contraseña extra

                    break;
                case "3":
                    // metodo para verificar contraseña extra

                    break;
                case "4":
                    // metodo para verificar contraseña extra

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "0":
                    Menu.continuar();
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }
    public static void menuCapturista(){
        String action;
        do {
            System.out.println("1 - Registrar ejecutivos de cuenta");
            System.out.println("2 - Modificar ejecutivos de cuenta");
            System.out.println("3 - Eliminar ejecutivos de cuenta");
            System.out.println("4 - Buscar ejecutivos de cuenta");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "0":
                    Menu.continuar();
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }
    public static void menuEjecutivo(){
        String action;
        do {
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Modificar cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Buscar cliente");
            System.out.println("5 - Autorizar tarjeta");
            System.out.println("6 - Ver solicitudes de tarjetas");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "0":
                    Menu.continuar();
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }
}
