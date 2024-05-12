package menus;

import sistema.Sistema;
import usuarios.Capturista;
import usuarios.Gerente;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCapturista {
    static Scanner scanner = new Scanner(System.in);
    public static void menuCapturista(){
        String action;
        int id;
        do {
            System.out.println("1 - Registrar ejecutivo de cuenta");
            System.out.println("2 - Modificar ejecutivo de cuenta");
            System.out.println("3 - Eliminar ejecutivo de cuenta");
            System.out.println("4 - Mostrar ejecutivo de cuenta");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    //Capturista.registrarEjecutivos();
                    break;
                case "2":
                    id = obtenerId();
                    //Capturista.modificarEjecutivo(id);
                    break;
                case "3":
                    id = obtenerId();
                    //Capturista.eliminarEjecutivo(id);
                    break;
                case "4":
                    menuMostrarEjecutivos();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }
    private static int obtenerId(){
        int id = 0;
        boolean incorrecto = true;
        System.out.print("ID del inversionista a eliminar");
        while (incorrecto) {
            try {
                incorrecto = false;
                id = scanner.nextInt();
            } catch (Exception e){
                incorrecto = true;
                System.out.println("Error");
            }
        }
        return id;
    }
    private static void menuMostrarEjecutivos(){
        String action, user;
        do {
            System.out.println("1 - Mostrar todos los ejecutivos de cuenta");
            System.out.println("2 - Mostrar ejecutivo por usuario");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    //Capturista.mostrarEjecutivos();
                    break;
                case "2":
                    System.out.println("Usuario del ejecutivo: ");
                    user = scanner.next();
                    //Capturista.mostrarEjecutivo(user);
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