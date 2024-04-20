package biblioteca;

import usuarios.utils.Usuario;
import usuarios.utils.UsuarioEnSesion;
import java.util.*;
import usuarios.utils.Rol;
import java.util.Scanner;

public class Menu {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);

    public static void ejecucion() {
        boolean valido = false;
        String rol = null;
        do {
            System.out.println(" ");
            System.out.println("Username: ");
            String username = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();
            for(Map.Entry<Rol, ArrayList<Usuario>> entry : Biblioteca.usuarios.entrySet()){
                for (Usuario usuario : entry.getValue()){
                    if (usuario.getNombreUsuario().equals(username)) {
                        if (usuario.getContrasena().equals(password)) {
                            valido = true;
                            rol = String.format("%s",usuario.getRol());
                            break;
                        }
                    }
                }
            }System.out.println("Password or user invalid");


        } while (!valido);
        if (Objects.equals(rol, "CLIENTE")) {
            mostrarMenuCliente();
        }
        if (Objects.equals(rol, "TRABAJADOR")) {
            mostrarMenuTrabajador();
        }
        if (Objects.equals(rol, "GERENTE")) {
            mostrarMenuGerente();
        }
    }
    // Función lambda


    private static void mostrarMenuCliente() {
        int opcion = 0;

        do {
            System.out.println("Ingrese la opción a ejecutar");
            System.out.println("1 Ver libros disponibles");
            System.out.println("2 Ver información de usuario");
            System.out.println("3 Rentar libro(s)");
            System.out.println("4 Mostrar libros rentados");
            System.out.println("5 Mostrar historial de libros rentados");
            System.out.println("6 Editar mi información");
            System.out.println("7 Salir del menu");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    ejecucion();
                    break;
            }
        } while(opcion>0&&opcion< 7);
    }

    private static void mostrarMenuGerente() {

        int opcion ;

        do {
            int opcionT = 0;
            int opcionL = 0;
            int opcionC = 0;
                System.out.println("__Menu de Gerente__");
                System.out.println("1 Menu Libros");
                System.out.println("2 Menu Clientes");
                System.out.println("3 Menu de Usuario");
                System.out.println("4 Salir");
                System.out.println("Ingrese la opción a ejecutar: ");
                opcion = scanner.nextInt();
                switch (opcion) {

                    case 1:
                        while (opcionL < 7) {
                            System.out.println("Ingrese la opción a ejecutar");
                            System.out.println("1 Registrar Libro(s)");
                            System.out.println("2 Mostrar a todos los Libros");
                            System.out.println("3 Mostrar a un Libro");
                            System.out.println("4 Modificar Libro");
                            System.out.println("5 Eliminar Libro");
                            System.out.println("6 Mostrar libros rentados actualmente");
                            System.out.println("7 Salir del menu");
                            opcionL = scanner.nextInt();
                            switch (opcionL) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    System.out.println("Usted esta saliendo del menu libros");
                                    break;

                            }
                        }
                        break;

                    case 2:
                        while (opcionC < 6) {
                            System.out.println("__Menu Clientes");
                            System.out.println("Ingrese la opción a ejecutar");
                            System.out.println("1 Registrar Cliente(s)");
                            System.out.println("2 Mostrar a todos los Clientes");
                            System.out.println("3 Mostrar a un Cliente");
                            System.out.println("4 Modificar cliente");
                            System.out.println("5 Eliminar cliente");
                            System.out.println("6 Salir del menu");
                            opcionC = scanner.nextInt();
                            switch (opcionC) {
                                case 1:
                                    biblioteca.registrarCliente();
                                    break;
                                case 2:
                                    biblioteca.mostrarClientes();
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    System.out.println("Usted esta saliendo del menu clientes");
                                    break;

                            }
                        }
                        break;
                    case 3:
                        while (opcionT < 6) {
                            System.out.println("Menu Trabajadores");
                            System.out.println("Ingrese la opción a ejecutar");
                            System.out.println("1 Registrar Trabajador(es)");
                            System.out.println("2 Mostrar a todos los Trabajadores");
                            System.out.println("3 Mostrar a un Trabajador");
                            System.out.println("4 Modificar trabajador");
                            System.out.println("5 Eliminar trabajador");
                            System.out.println("6 Salir del menu");
                            opcionT = scanner.nextInt();
                            switch (opcionT) {
                                case 1:
                                    biblioteca.registrarTrabajador();
                                    break;
                                case 2:
                                    biblioteca.mostrarTrabajadores();
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    System.out.println("Usted esta saliendo del menu de trabajadores");
                                    break;
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Usted está cerrando sesión");
                        Menu.ejecucion();
                        break;

            }
        } while(opcion < 4);
    }

    private static void mostrarMenuTrabajador() {

        int opcion = 0;

        do {
            int opcionT = 0;
            int opcionL = 0;
            int opcionC = 0;
            while (opcionT < 4) {
                System.out.println("__Menu de Trabajadores__");
                System.out.println("1 Menu Libros");
                System.out.println("2 Menu Clientes");
                System.out.println("3 Menu de Usuario");
                System.out.println("4 Cerrar sesión");
                System.out.println("Ingrese la opción a ejecutar: ");
                opcionT = scanner.nextInt();
                switch (opcionT) {

                    case 1:
                        while (opcionL < 7) {
                            System.out.println("Ingrese la opción a ejecutar");
                            System.out.println("1 Registrar Libro(s)");
                            System.out.println("2 Mostrar a todos los Libros");
                            System.out.println("3 Mostrar a un Libro");
                            System.out.println("4 Modificar Libro");
                            System.out.println("5 Eliminar Libro");
                            System.out.println("6 Mostrar libros rentados actualmente");
                            System.out.println("7 Salir del menu");
                            opcionL = scanner.nextInt();
                            switch (opcionL) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    System.out.println("Usted esta saliendo del menu libros");
                                    break;

                            }
                        }
                        break;

                    case 2:
                        while (opcionC < 6) {
                            System.out.println("__Menu de Trabajadores");
                            System.out.println("Ingrese la opción a ejecutar");
                            System.out.println("1 Registrar Cliente(s)");
                            System.out.println("2 Mostrar a todos los Clientes");
                            System.out.println("3 Mostrar a un Cliente");
                            System.out.println("4 Modificar cliente");
                            System.out.println("5 Eliminar cliente");
                            System.out.println("6 Salir del menu");
                            opcionC = scanner.nextInt();
                            switch (opcionC) {
                                case 1:
                                    biblioteca.registrarCliente();
                                    break;
                                case 2:
                                    biblioteca.mostrarClientes();
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    System.out.println("Usted esta saliendo del menu clientes");
                                    break;

                            }
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("Usted esta cerrando sesión");
                        ejecucion();
                        break;
                }
            }


        } while(opcion <4);
    }
}

// UsuarioEnSesion.getInstancia().cerrarSesion();
//                    inciarSesion();