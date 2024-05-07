package menus;

import java.util.Scanner;

public class MenuEmpleados {
    static Scanner scanner = new Scanner(System.in);
    public static void menuEmpleados(){
        String action;
        do {
            System.out.println("1 - Gerente");
            System.out.println("2 - Ejecutivo");
            System.out.println("3 - Capturista");
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
                case "0":
                    System.out.println("Regresando");
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }
}
