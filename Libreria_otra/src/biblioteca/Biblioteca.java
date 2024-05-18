package biblioteca;

import Libros.Libro;
import Libros.LibroAccion;
import Libros.LibroComedia;
import Libros.LibroTerror;
import Libros.constants.Genero;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Trabajador;
import usuarios.Usuario;
import usuarios.utils.Rol;
import usuarios.utils.UsuarioEnSesion;

import java.util.*;


public class Biblioteca {
    public static Map<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    public static Map<Genero, ArrayList<Libro>> libros = new HashMap<Genero, ArrayList<Libro>>();
    public static Scanner scanner = new Scanner(System.in);

    public Biblioteca() {

    }

    public void comprarLibro() {
        int genero = 0;
        boolean incorrecto = true;
        double precioTotal = 0;
        while (incorrecto) {
            try {
                incorrecto = false;

                System.out.println("Ingresa género del libro a comprar: ");
                System.out.println("1. Acción");
                System.out.println("2. Comedia");
                System.out.println("3. Terror");
                System.out.println("4. Salir");
                genero = scanner.nextInt();
                scanner.nextLine();
                switch (genero) {
                    case 1:
                        precioTotal = precioTotal + comprar(Genero.ACCION);
                        break;
                    case 2:
                        precioTotal = precioTotal + comprar(Genero.COMEDIA);
                        break;
                    case 3:
                        precioTotal = precioTotal + comprar(Genero.TERROR);
                        break;
                    case 4:
                        System.out.println("Usted ha terminado de comprar");
                        System.out.println("El total es: " + precioTotal);
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

    }

    private double comprar(Genero genero) {
        System.out.println("Ingrese nombre del libro");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese nombre del autor");
        String autor = scanner.nextLine();
        for (Libro libro : Biblioteca.libros.get(genero)) {
            if (libro.getNombre().equals(nombre) && libro.getAutor().equals(autor)) {
                if (libro.comprar()) {
                    ((Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual()).comprar(libro);
                    System.out.printf("Precio de %s %f%n", libro.getNombre(), libro.getPrecio());
                    return libro.getPrecio();
                }
            }
        }
        return 0;
    }

    public void registrarLibroMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean esDatoValido = false;

        do {
            System.out.println("\nRegistrar un Libro");
            System.out.println("Selecciona una opción");
            System.out.println("1. Terror");
            System.out.println("2. Comedia");
            System.out.println("3. Acción");
            System.out.println("4. Regresa al menú principal");

            while (!esDatoValido) {
                try {
                    opcion = scanner.nextInt();

                    if (opcion < 1 || opcion > 4) {
                        throw new InputMismatchException();
                    }

                    esDatoValido = true;
                } catch (InputMismatchException error) {
                    System.out.println("Opción no válida. Intena de nuevo");
                } finally {
                    scanner.nextLine();
                }
            }

            esDatoValido = false;

            switch (opcion) {
                case 1:
                    System.out.println("Registrar libro terror");
                    LibroTerror.registrarLibro();
                    break;
                case 2:
                    System.out.println("Registrar libro comedia");
                    LibroComedia.registrarLibro();
                    break;
                case 3:
                    LibroAccion.registrarLibro();
                    System.out.println("Registrar libro accion");
                    break;
            }
        } while (opcion != 4);
    }

    public void eliminarLibro() {
        String nombre, autor;
        int genero = 0;
        boolean incorrecto = true;

        while (incorrecto) {
            try {
                incorrecto = false;

                System.out.println("Ingresa género del libro a elminar: ");
                System.out.println("1. Acción");
                System.out.println("2. Comedia");
                System.out.println("3. Terror");
                System.out.println("4. Salir");
                genero = scanner.nextInt();
                scanner.nextLine();
                switch (genero) {
                    case 1:
                        System.out.println("Ingrese el nombre del libro");
                        nombre = scanner.nextLine();
                        System.out.println("Ingrese el autor del libro");
                        autor = scanner.nextLine();
                        LibroAccion.eliminarLibro(nombre, autor);
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre del libro");
                        nombre = scanner.nextLine();
                        System.out.println("Ingrese el autor del libro");
                        autor = scanner.nextLine();
                        LibroComedia.eliminarLibro(nombre, autor);
                        break;
                    case 3:
                        System.out.println("Ingrese el nombre del libro");
                        nombre = scanner.nextLine();
                        System.out.println("Ingrese el autor del libro");
                        autor = scanner.nextLine();
                        LibroTerror.eliminarLibro(nombre, autor);
                        break;
                    case 4:
                        break;
                    default:
                        incorrecto = true;
                        System.out.println("Esa opción no se encuentra");
                }

            } catch (Exception ew) {
                System.out.println("No se encontró el libro a eliminar");
                scanner.next();
            }
        }
    }


    public void MostrarLibros() {
        for (Map.Entry<Genero, ArrayList<Libro>> entry : libros.entrySet()) {
            for (Libro libro : entry.getValue()) {
                System.out.println(libro.toString());
            }
        }
    }

    public void BuscarLibrosPorAutor(String autor) {
        System.out.printf("Libros de %s: %n", autor);
        for (Map.Entry<Genero, ArrayList<Libro>> entry : libros.entrySet()) {
            for (Libro libro : entry.getValue()) {
                if (Objects.equals(libro.getAutor(), autor)) {
                    System.out.println(libro);
                }
            }
        }
    }

    public void BuscarLibrosPorGenero(Genero genero) {
        System.out.printf("Libros de  %s:", genero);
        for (Map.Entry<Genero, ArrayList<Libro>> entry : libros.entrySet()) {
            for (Libro libro : entry.getValue()) {
                if (libro.getGenero() == genero) {
                    System.out.println(libro);
                }
            }
        }
    }

    public void BuscarLibrosPorLetras(String letras) {
        int largo = letras.length();
        System.out.printf("Libros que coinciden con %s:", letras);
        for (Map.Entry<Genero, ArrayList<Libro>> entry : libros.entrySet()) {
            for (Libro libro : entry.getValue()) {
                if (libro.getNombre().length() >= largo) {
                    if (libro.getNombre().substring(0, largo).equals(letras)) {
                        System.out.println(libro);
                    }
                }
            }
        }
    }

    public void Inicializar() {
        Gerente.getGerente();
        usuarios.put(Rol.CLIENTE, new ArrayList<>());
        usuarios.put(Rol.TRABAJADOR, new ArrayList<>());
        usuarios.put(Rol.GERENTE, new ArrayList<>());
        usuarios.get(Rol.GERENTE).add(Gerente.getGerente());
    }

    public void LibrosPorA() {

    }

    public static Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (Map.Entry<Rol, ArrayList<Usuario>> entry : usuarios.entrySet()) {
            for (Usuario usuarioActual : entry.getValue()) {
                if(usuarioActual.getRol().equals(Rol.GERENTE)){
                    if (Gerente.getGerente().getNombreUsuario().equals(nombreUsuario) && Gerente.getGerente().getContrasena().equals(contrasena)) {
                        System.out.println("usuario");
                        return usuarioActual;

                    }
                }
                if (usuarioActual.getNombreUsuario().equals(nombreUsuario) && usuarioActual.getContrasena().equals(contrasena)) {
                    System.out.println("usuario");
                    return usuarioActual;

                }
            }
        }
        return null;
    }



    public void registrarTrabajador() {
        Trabajador.registrarTrabajador();
    }


    public void registrarCliente() {

        Cliente.registrarCliente();

    }

    public void mostrarTrabajadores() {
        Trabajador.mostrarTrabajadores();
    }

    public void mostrarClientes() {
        Cliente.mostrarClientes();
    }

    public void eliminarCliente() {
        System.out.println("Ingrese el id del cliente: ");
        int id = scanner.nextInt();
        Cliente.eliminarCliente(id);
    }

    public void eliminarTrabajador() {
        System.out.println("Ingrese el id del trabajador: ");
        int id = scanner.nextInt();
        Trabajador.eliminarTrabajador(id);
    }

    public void modificarCliente() {
        System.out.println("Ingrese el id del cliente: ");
        int id = scanner.nextInt();
        Cliente.modificarCliente(id);
    }

    public void modificarTrabajador() {
        System.out.println("Ingrese el id del trabajador: ");
        int id = scanner.nextInt();
        Trabajador.modificarTrabajador(id);
    }

    //es un metodo incorrecto dice que uwu y retorna owo
    public void mostrarCliente() {
        System.out.println("Ingrese el id del cliente: ");
        int id = scanner.nextInt();
        Cliente.mostrarCliente(id);
    }

    public void mostrarTrabajador() {
        System.out.println("Ingrese el id del trabajador: ");
        int id = scanner.nextInt();
        Trabajador.mostrarTrabajador(id);
    }

}

