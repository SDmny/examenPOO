package menus;

import sistema.Sistema;
import usuarios.Inversionista;
import usuarios.Usuario;
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
        String rol = UsuarioEnSesion.getInstancia().getUsuarioActual().getRol().toString();
        System.out.println(String.format("- - - Menu %s - - -", rol.toLowerCase()));
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case GERENTE:
                MenuGerente.menuGerente();
                break;
            case CAPTURISTA:
                MenuCapturista.menuCapturista();
                break;
            case EJECUTIVO:
                MenuEjecutivo.menuEjecutivo();
                break;
            case INVERSIONISTA:
                MenuInversionistas.menuInversionista();
                break;
            case CLIENTE:
                MenuClientes.menuCliente();
                break;
            default:
        }
        continuar();
    }
}
