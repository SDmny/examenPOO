package menus;

import sistema.Sistema;
import usuarios.Capturista;
import usuarios.Gerente;
import usuarios.Inversionista;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;
import utils.UsuarioEnSesion;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuGerente {
    static Scanner scanner = new Scanner(System.in);
    public static void menuGerente(){
        String action;
        do {
            System.out.println("1 - Acciones sobre inversionistas");
            System.out.println("2 - Acciones sobre ejecutivos");
            System.out.println("3 - Acciones de clientes y tarjetas");
            System.out.println("4 - Ver fondos del banco");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1": menuGerenteInversionista();
                    break;
                case "2":
                    MenuCapturista.menuCapturista();
                    break;
                case "3":
                    MenuEjecutivo.menuEjecutivo();
                    break;
                case "4":
                    mostrarFondos();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }
    private static void mostrarFondos(){
        for (int i = 0; i < Sistema.fondos.size(); i++) {
            System.out.println(Sistema.fondos.get(i).toString());
        }
    }
    private static void menuGerenteInversionista(){
        String action;
        int id;
        do {
            System.out.println("1 - Registrar inversionista");
            System.out.println("2 - Modificar inversionista");
            System.out.println("3 - Eliminar inversionista");
            System.out.println("4 - Mostrar inversionista");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    if(segundaContrasena()){
                        Inversionista.registrarInversionista();
                    }
                    break;
                case "2":
                    if(segundaContrasena()){
                        id = obtenerId();
                        Inversionista.modificarInversionista(id);
                    }

                    break;
                case "3":
                    if(segundaContrasena()){
                        id = obtenerId();
                        Inversionista.eliminarInversionista(id);
                    }
                    break;
                case "4":
                    if(segundaContrasena()){
                        menuMostrarInversionistas();
                    }
                    break;
                case "0":
                    System.out.println("Regresando");
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }

    private static boolean segundaContrasena(){
        boolean access = false;
        String password;
        Gerente gerente = (Gerente)UsuarioEnSesion.getInstancia().getUsuarioActual();
        System.out.print("Contraseña de autorización: ");
        password = scanner.next();
        if (password.equals(gerente.getContrasena())){
            access = true;
        } else {
            System.out.println("Contraseña incorrecta");
        }
        return access;
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

    private static void menuMostrarInversionistas(){
        String action, user;
        do {
            System.out.println("1 - Mostrar todos los inversionistas");
            System.out.println("2 - Mostrar inversionista por usuario");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    Inversionista.mostrarInversionistas();
                    break;
                case "2":
                    System.out.println("Usuario del inversionista: ");
                    user = scanner.next();
                    Inversionista.mostrarInversionista(user);
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