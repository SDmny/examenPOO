
import java.util.ArrayList;

public class Libreria {
    ArrayList<Usuario> __usuarios = new ArrayList<>();
    ArrayList<Libro> __libros = new ArrayList<>();

    public void agregar_usuario(Usuario usuario) {
        this.__usuarios.add(usuario);
    }

    public void agregar_libro(Libro libro) {
        this.__libros.add(libro);
    }

    public void mostrar_libros_no_rentados() {
        System.out.println("*** LIBROS ***");
        for (Libro libro : this.__libros) {
            if (libro.get_rentado() == false) {
                libro.get_data();
            }
        }
    }

    public void mostrar_libros() {
        System.out.println("*** LIBROS ***");
        for (Libro libro : this.__libros) {
            libro.get_data();
        }
    }

    public void mostrar_usuarios() {
        System.out.println("*** USUARIOS **");
        for (Usuario usuario : this.__usuarios) {
            System.out.println(usuario.get_nombre());
        }
    }

    public void rentar(String nombre, String autor, String name) {
        for (Libro i : this.__libros) {

            if (i.get_nombre().equals(nombre) && i.get_autor().equals(autor)) {

                if (i.get_rentado() == false) {
                    for (Usuario a : this.__usuarios) {

                        if (a.get_nombre().equals(name)) {
                            i.rentar();
                            a.rentar_libro(i);
                        }
                    }
                } else {
                    System.out.println("El libro está rentado\n");
                }
            }
        }
    }

    public void devolver(String nombre, String autor, String name) {
        for (Libro i : this.__libros)
            if (i.get_nombre().equals(nombre) && i.get_autor().equals(autor)) {
                if (i.get_rentado()) {
                    for (Usuario a : this.__usuarios) {
                        if (a.get_nombre().equals(name)) {
                            i.devolver();
                            a.devolver_libro(i.get_nombre());
                        }
                    }
                }
            }
    }

    public void mostrar_usuarios_con_libros() {
        int si = 0;
        for (Usuario i : this.__usuarios) {
            if (i.have_a_book()) {
                System.out.println("Usuario: ");
                System.out.println(i.get_nombre());
                i.show_books();
                si = si + 1;
            }
        }
        if (si == 0) {
            System.out.println("No hay libros rentados\n");
        }
    }
}
