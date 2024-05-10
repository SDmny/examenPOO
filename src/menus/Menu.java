package menus;

import Sistema.Sistema;
import Usuarios.Usuario;
import utils.UsuarioEnSesion;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);


    public static void iniciarSesion() {
        boolean access = false;

        do {
            System.out.println("- - - Bienvenido al sistema - - -");
            System.out.println("Inicia sesión para continuar");

            System.out.print("Usuario: ");
            String usuario = scanner.next();

            System.out.print("Contrasena: ");
            String contrasena = scanner.next();

            Usuario usuarioActual = Sistema.verificarInicioSesion(usuario, contrasena);

            if (usuarioActual != null) {
                UsuarioEnSesion.getInstancia().setUsuarioActual(usuarioActual);
                access = true;
                menu();
            } else {
                System.out.println("Usuario o contrasena incorrectos. Intenta de nuevo.");
            }

        } while (!access);
    }

    public static void continuar(){
        String next;
        System.out.println("1 - Volver a iniciar sesión\n2 - Salir del programa");
        next = scanner.next();

        if (next == "1"){
            UsuarioEnSesion.getInstancia().cerrarSesion();
            iniciarSesion();
        } else if (next != "2") {
            continuar();
        } else {
            System.out.println("Saliendo del programa...");
        }
    }

    // Seleccion de menu por rol
    public static void menu() {
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case GERENTE: MenuEmpleados.menuGerente();
                break;
            case CAPTURISTA: MenuEmpleados.menuCapturista();
                break;
            case EJECUTIVO: MenuEmpleados.menuEjecutivo();
                break;
            case INVERSIONISTA: MenuInversionistas.menuInversionista();
                break;
            case CLIENTE: MenuClientes.menuCliente();
                break;
            default:
        }
    }
}
