package menus;

import sistema.Sistema;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCapturista {
    static Scanner scanner = new Scanner(System.in);
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

}
