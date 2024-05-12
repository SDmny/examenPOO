package menus;

import java.util.Scanner;

public class MenuClientes {
    static Scanner scanner = new Scanner(System.in);
    public static void menuCliente(){
        String action;
        boolean accessToAsk = false;
        do {
            // metodo para saber si mostrar o no la opcion de solicitud de tarjeta
            if (accessToAsk){
                System.out.println("1 - Solicitar tarjeta");
            }
            System.out.println("2 - Depositar");
            System.out.println("3 - Retirar");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    if (accessToAsk){
                        // metodo de solicitar tarjeta
                    }
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }
}