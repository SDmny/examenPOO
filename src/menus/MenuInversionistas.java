package menus;

import java.util.Scanner;

public class MenuInversionistas {
    static Scanner scanner = new Scanner(System.in);
    public static void menuInversionistas(){
        String action;
        do {
            System.out.println("1 - Salir");
            System.out.println("2 - Salir");
            System.out.println("3 - Salir");
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
                    Menu.continuar();
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }
}
