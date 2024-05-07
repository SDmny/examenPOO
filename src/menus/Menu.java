package menus;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("- - - Bienvenido al sistema - - -");
        sucursal();
    }

    // Sucursal
    public static void sucursal(){
        String branch = "";
        do {
            System.out.println("\nSelecciona una sucursal\n1 - Madero\n2 - Acueducto\n0 - Regresar");
            System.out.print("Selección: ");
            branch = scanner.next();
            switch (branch){
                case "1": // algo debe señalar que solo buscamos en sucursal 1
                    break;
                case "2": // algo debe señalar que solo buscamos en sucursal 2
                    break;
                case "0":
                    System.out.println("Regresando");
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }

        } while (!branch.equals("0"));
        continuar();
    }

    public static void continuar(){
        String next;
        System.out.println("1 - Volver a seleccion de sucursal\n2 - Salir del programa");
        next = scanner.next();

        if (next == "1"){
            sucursal();
        } else if (next != "2") {
            continuar();
        }
    }

    // Seleccion de rol
    public static void rolEntrar() {
        String rol;
        do {
            System.out.println("\n1 - Cliente\n2 - Empleado\n3 - Inversionista\n0 - Regresar");
            System.out.print("Selección: ");
            rol = scanner.next();
            switch (rol){
                case "1": // menu clientes
                    break;
                case "2": // menu empleados
                    break;
                case "3": // menu inversionistas
                    break;
                case "0":
                    System.out.println("Regresando");
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!rol.equals("0"));
        continuar();
    }
}
