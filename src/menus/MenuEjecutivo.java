package menus;

import sistema.Sistema;
import tarjetas.utils.SolicitudTarjetaC;
import usuarios.Cliente;
import usuarios.Ejecutivo;
import usuarios.Usuario;
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
            System.out.println("\n1 - Registrar cliente");
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
                    menuMostrarClientes();
                    break;
                case "5":
                    autorizarTarjeta();
                    break;
                case "6":
                    mostrarSolicitudes();
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
    private static void menuMostrarClientes(){
        String action, user;
        do {
            System.out.println("\n1 - Mostrar todos los clientes");
            System.out.println("2 - Mostrar cliente por usuario");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    Cliente.mostrarClientes();
                    break;
                case "2":
                    System.out.println("Usuario del cliente: ");
                    user = scanner.next();
                    Cliente.mostrarCliente(user);
                    break;
                case "0":
                    System.out.println("Regresando");
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }

    private static void mostrarSolicitudes(){
        for (int i = 0; i < Sistema.solicitudes.size(); i++) {
            System.out.println(Sistema.solicitudes.get(i).toString());
        }
    }
    private static void autorizarTarjeta(){
        int id = 0;
        System.out.print("ID de la solicitud: ");
        try {
            id = scanner.nextInt();
        } catch (Exception e){
            System.out.println("ID invalida");
        }
        if (id != 0){
            System.out.print("1 - Aprobar\n2 - Rechazar");
            String action = scanner.next();
            if (action == "1"){
                SolicitudTarjetaC.aprobarTarjeta(id);
            } else if (action == "2") {
                SolicitudTarjetaC.rechazarTarjeta(id);
            } else {
                System.out.println("Acción inexistente");
            }
        }
    }

}