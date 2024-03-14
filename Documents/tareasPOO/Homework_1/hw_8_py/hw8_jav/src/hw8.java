import java.util.Scanner;

public class hw8 {
    public static void main(String[] args) throws Exception {
        /*
         * Se desea crear un sistema para una librería, este sistema debe de
         * contener 3 clases, libreria (la cual contiene libros y usuarios).
         * Un usuario puede rentar uno o muchos libros, pero un libro puede ser
         * rentado solo por un usuario.
         * Se solicita que se puede listar a todos los usuarios con
         * libros rentados y los que no.
         * 
         * 
         * 
         * #usuario_uno = Usuario("Juan Pérez", 20)
         * # usuario_dos = Usuario("Pedro Medina", 35)
         * 
         * # libreria.agregar_usuario(usuario_uno)
         * # libreria.agregar_usuario(usuario_dos)
         * 
         * # libreria.mostrar_usuarios()
         */
        Scanner leer = new Scanner(System.in);
        Libreria libreria = new Libreria();
        Usuario usuario;
        Libro libro;
        String nombre, autor, name;
        int edad;
        int opcion = 0;
        while (opcion != 9) {
            System.out.println("***********************************");
            System.out.println("BIENVENIDO A LA LIBRERIA");
            System.out.println("Elige una opción para continuar");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Mostrar Usuarios");
            System.out.println("3. Mostrar usuarios con libro(s)");
            System.out.println("4. Añadir libro");
            System.out.println("5. Mostrar todos los libros");
            System.out.println("6. Mostrar libros disponibles");
            System.out.println("7. Rentar libro(s)");
            System.out.println("8. Entregar libro(s)");
            System.out.println("9. Salir");
            System.out.println("***********************************\n");
            System.out.println("Ingresa la opción: ");
            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("\nElegiste la opción 1\n");
                    System.out.println("Cantidad de usuarios a ingresar: ");
                    int cantidad = leer.nextInt();
                    leer.nextLine();
                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("Ingresa el nombre del usuario: ");
                        nombre = leer.nextLine();
                        System.out.println("Ingresa la edad del usuario: ");
                        edad = leer.nextInt();
                        leer.nextLine();
                        usuario = new Usuario(nombre, edad);
                        libreria.agregar_usuario(usuario);
                        System.out.println("El usuario "+ nombre+" ha sido registrado\n");
                    }

                    break;

                case 2:
                    System.out.println("\nElegiste la opción 2");
                    System.out.println("Se mostrarán los usuarios\n");
                    libreria.mostrar_usuarios();
                    break;

                case 3:
                    System.out.println("Usuarios con libros: ");
                    libreria.mostrar_usuarios_con_libros();
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Cantidad de libros a ingresar: ");
                    cantidad = leer.nextInt();
                    leer.nextLine();
                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("Ingrese título del libro: ");
                        nombre = leer.nextLine();
                        System.out.println("Ingrese autor: ");
                        autor = leer.nextLine();
                        libro = new Libro(nombre, autor);
                        libreria.agregar_libro(libro);
                    }

                    break;
                case 5:
                    libreria.mostrar_libros();
                    break;
                case 6:
                    libreria.mostrar_libros_no_rentados();
                    break;
                case 7:
                    System.out.println("Ingrese título del libro: ");
                    nombre = leer.nextLine();
                    System.out.println("Ingrese autor: ");
                    autor = leer.nextLine();
                    
                    System.out.println("Ingrese nombre completo del usuario: ");
                    name = leer.nextLine();
                    libreria.rentar(nombre, autor, name);
                    break;
                case 8:
                    System.out.println("Ingrese título del libro: ");
                    nombre = leer.nextLine();
                    System.out.println("Ingrese autor: ");
                    autor = leer.nextLine();
                    
                    System.out.println("Ingrese nombre completo del usuario: ");
                    name = leer.nextLine();
                    libreria.devolver(nombre,autor, name);
                    break;
                case 9:
                    break;

                default:
                    break;
            }

        }
        System.out.println("Usted ha salido del programa");
    }
}
