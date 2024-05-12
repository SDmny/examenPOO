package menus;

import sistema.Sistema;
import usuarios.Ejecutivo;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuEjecutivo {
    static Scanner scanner = new Scanner(System.in);
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
                    //Ejecutivo.registrarCliente();
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
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }

}