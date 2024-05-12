package menus;

import sistema.Sistema;
import usuarios.Cliente;
import usuarios.Ejecutivo;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuEjecutivo {
    static Scanner scanner = new Scanner(System.in);
    public static void menuEjecutivo(){
        int id;
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
                    Cliente.registrarCliente();
                    break;
                case "2":
                    id=obtenerId();
                  Cliente.modificarCliente(id);
                    break;
                case "3":
                    id=obtenerId();
                    Cliente.eliminarClientes(id);
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

}