package Bibiloteca;

import Usuario.Usuario;
import Usuario.Rol;

import java.util.Scanner;

public class Menu {
    private static Biblioteca biblioteca = new Biblioteca();
    static Scanner leer = new Scanner(System.in);

    public static void EjecutarMenu() {
        Password();
        int i = 0;
        System.out.println("--__BIENVENIDO AL SISTEMA__--");
        for (Usuario usuario : biblioteca.usuarios) {
            if (usuario.getRol() == Rol.CLIENTE) {
                menuClientes();
            }
            if (usuario.getRol() == Rol.TRABAJADOR) {
                menuTrabajadores();
            }
            if (usuario.getRol() == Rol.GERENTE) {
                menuGerente();

            }
        }
    }

    private static void Password() {
        boolean corrrecta = false;
        while (!corrrecta) {
            System.out.println("Ingrese su nombre de usuario: ");
            String nombre = leer.nextLine();
            System.out.println("Ingrese su contraseña: ");
            String contraseña = leer.nextLine();
            for (Usuario usuario : biblioteca.usuarios) {
                if (usuario.getNombre().equals(nombre)) {
                    if (usuario.getContraseña().equals(contraseña)) {
                        corrrecta = true;
                    }
                }

            }
            if (corrrecta) {
                System.out.println("La contraseña es correcta, ingresando a sistema");
            } else {
                System.out.println("La contraseña o el nombre de usuario son incorrectos, intente de nuevo");
            }
        }
    }

    private static void menuClientes() {
        System.out.println("__Menu de Clientes__");
        int opcion = 0;
        while (opcion < 6) {
            System.out.println("Ingrese la opción a ejecutar");
            System.out.println("1 Ver libros disponibles");
            System.out.println("2 Ver información de usuario");
            System.out.println("3 Rentar libro(s)");
            System.out.println("4 Mostrar libros rentados");
            System.out.println("5 Mostrar historial de libros rentados");
            System.out.println("6 Salir del menu");
            opcion = leer.nextInt();
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
                    System.out.println("Usted esta saliendo del menu principal");
                    break;
            }
        }
    }

    private static void menuGerente() {

        int opcion = 0;
        int opcionT = 0;
        int opcionL = 0;
        int opcionC = 0;
        while (opcion < 4) {
            System.out.println("__Menu de Gerente__");
            System.out.println("1 Menu Libros");
            System.out.println("2 Menu Clientes");
            System.out.println("3 Menu de Usuario");
            System.out.println("4 Salir");
            System.out.println("Ingrese la opción a ejecutar: ");
            opcion = leer.nextInt();
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
                        opcionL = leer.nextInt();
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
                        opcionC = leer.nextInt();
                        switch (opcionC) {
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
                        opcionT = leer.nextInt();
                        switch (opcionT) {
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
                                System.out.println("Usted esta saliendo del menu de trabajadores");
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Usted esta saliendo del menu principal");
                    break;
            }
        }
    }


    private static void menuTrabajadores() {
        int opcionT = 0;
        int opcionL = 0;
        int opcionC = 0;
        while (opcionT < 4) {
            System.out.println("__Menu de Trabajadores__");
            System.out.println("1 Menu Libros");
            System.out.println("2 Menu Clientes");
            System.out.println("3 Menu de Usuario");
            System.out.println("4 Salir");
            System.out.println("Ingrese la opción a ejecutar: ");
            opcionT = leer.nextInt();
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
                        opcionL = leer.nextInt();
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
                        opcionC = leer.nextInt();
                        switch (opcionC) {
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
                                System.out.println("Usted esta saliendo del menu clientes");
                                break;

                        }
                    }
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Usted esta saliendo del menu principal");
                    break;
            }
        }
    }
}