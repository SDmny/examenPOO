package menus;

import sistema.Sistema;
import usuarios.Capturista;
import usuarios.Ejecutivo;
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
            System.out.println("\n1 - Registrar ejecutivo de cuenta");
            System.out.println("2 - Modificar ejecutivo de cuenta");
            System.out.println("3 - Eliminar ejecutivo de cuenta");
            System.out.println("4 - Mostrar ejecutivo de cuenta");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    Ejecutivo.registrarEjecutivo();
                    break;
                case "2":
                    id = obtenerId();
                    Ejecutivo.modificarEjecutivo(id);
                    break;
                case "3":
                    id = obtenerId();
                    Ejecutivo.eliminarEjecutivo(id);
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
        System.out.print("ID del Ejecutivo: ");
        while (incorrecto) {
            try {
                incorrecto = false;
                id = scanner.nextInt();
            } catch (Exception e){
                incorrecto = true;
                System.out.println("Error");
                scanner.nextLine();
            }
        }
        return id;
    }
    private static void menuMostrarEjecutivos(){
        String action, user;
        do {
            System.out.println("\n1 - Mostrar todos los ejecutivos de cuenta");
            System.out.println("2 - Mostrar ejecutivo por usuario");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    Ejecutivo.mostrarEjecutivos();
                    break;
                case "2":
                    System.out.println("Usuario del ejecutivo: ");
                    user = scanner.next();
                    Ejecutivo.mostrarEjecutivo(user);
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