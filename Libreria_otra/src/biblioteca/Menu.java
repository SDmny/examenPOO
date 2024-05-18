package biblioteca;

import Libros.LibroAccion;
import Libros.LibroComedia;
import Libros.LibroTerror;
import Libros.constants.Genero;
import usuarios.Trabajador;
import usuarios.Usuario;
import usuarios.utils.UsuarioEnSesion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static Biblioteca biblioteca = new Biblioteca();
    private final Scanner scanner = new Scanner(System.in);

    public Menu() {
        biblioteca.Inicializar();
        inciarSesion();

    }


    public  void inciarSesion() {
        boolean datosCorrectos = false;

        do {
            System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA");
            System.out.println("Inicia sesión para continuar");

            System.out.println("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contrasena: ");
            String contrasena = scanner.nextLine();

              Usuario usuarioActual = Biblioteca.verificarInicioSesion(usuario, contrasena);

            if (usuarioActual != null) {
                UsuarioEnSesion.getInstancia().setUsuario(usuarioActual);
                datosCorrectos = true;
                seleccionarMenu();
            } else {
                System.out.println("Usuario o contrasena incorrectos. Intenta de nuevo.");


            }

        } while (!datosCorrectos);
    }

    // Función lambda
    private void seleccionarMenu() {
        if (UsuarioEnSesion.getInstancia().getUsuarioActual() != null) {
            switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
                case CLIENTE -> mostrarMenuCliente();
                case TRABAJADOR -> mostrarMenuTrabajador();
                case GERENTE -> mostrarMenuGerente();
            }
        }
    }

    private void mostrarMenuCliente() {
        int opcion = 0;

        do {
            System.out.println("Menú Cliente");
            System.out.println("Selecciona una opción para continuar");
            System.out.println("1. Ver libros disponibles");
            System.out.println("2. Comprar libro");
            System.out.println("3. Consultar mis compras");
            System.out.println("4. Mostrar mis datos");
            System.out.println("5. Editar mi información");
            System.out.println("6. Cerrar sesión");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuBuscarLibros();
                    break;
                case 2:
                    biblioteca.comprarLibro();
                    break;
                case 5:
                    UsuarioEnSesion.getInstancia();
                    UsuarioEnSesion.cerrarSesion();
                    inciarSesion();
                    break;
            }
        } while (opcion != 5);
    }

    private void menuBuscarLibros() {
        int op = 0, genero = 0;
        boolean incorrecto = true;
        while (op != 5) {
            System.out.println("Ingrese modo de búsqueda");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Mostrar libros por autor");
            System.out.println("3. Mostrar libros por género");
            System.out.println("4. Mostrar libros por primeras letras");
            System.out.println("5. Salir");
            op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1:
                    biblioteca.MostrarLibros();
                    break;
                case 2:
                    System.out.println("Ingrese autor:");
                    String autor = scanner.nextLine();
                    biblioteca.BuscarLibrosPorAutor(autor);
                    break;
                case 3:

                    while (incorrecto) {
                        try {
                            incorrecto = false;

                            System.out.println("Ingresa género de los libros a mostrar: ");
                            System.out.println("1. Acción");
                            System.out.println("2. Comedia");
                            System.out.println("3. Terror");
                            System.out.println("4. Salir");
                            genero = scanner.nextInt();
                            scanner.nextLine();
                            switch (genero) {
                                case 1:
                                    biblioteca.BuscarLibrosPorGenero(Genero.ACCION);
                                    break;
                                case 2:
                                    biblioteca.BuscarLibrosPorGenero(Genero.COMEDIA);
                                    break;
                                case 3:
                                    biblioteca.BuscarLibrosPorGenero(Genero.TERROR);
                                    break;
                                case 4:
                                    System.out.println("Usted ha salido de la busqueda por genero");
                                    break;
                                default:
                                    System.out.println("Esa opción no se encuentra");
                            }
                        } catch (Exception ew) {
                            incorrecto = true;
                            System.out.println("Error al buscar libro");
                            scanner.nextLine();
                        }
                    }

                    break;
                case 4:
                    System.out.println("Ingrese nombre del libro o inicio del nombre del libro :");
                    String nombre = scanner.nextLine();
                    biblioteca.BuscarLibrosPorLetras(nombre);
                    break;
                case 5:
                    break;
            }
        }
    }

    private void mostrarMenuTrabajador() {
        Scanner scanner = new Scanner(System.in);
        String nombre, autor;
        int opcion = 0;

        do {
            System.out.println("\nMenú Trabajador");
            System.out.println("Selecciona una opción para continuar");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Registrar Libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Cerrar sesión");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    biblioteca.registrarCliente();
                    break;
                case 2:
                    biblioteca.mostrarClientes();
                    break;
                case 3:
                    biblioteca.registrarLibroMenu();
                    break;
                case 4:
                    biblioteca.eliminarLibro();
                    break;
                case 5:
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    inciarSesion();
                    break;
            }
        } while (opcion != 5);
    }



    private void mostrarMenuGerente() {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\nMenú Gerente");
            System.out.println("Selecciona una opción para continuar");
            System.out.println("1. Registrar Trabajador");
            System.out.println("2. Mostrar Funciones de Trabajador");
            System.out.println("3. Cerrar sesión");
opcion=scanner.nextInt();
            switch (opcion) {
                case 1:
                    Trabajador.registrarTrabajador();
                    break;
                case 2:
                    mostrarMenuTrabajador();
                    break;
                case 3:
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    inciarSesion();
                    break;
            }
        } while (opcion != 3);
    }
}