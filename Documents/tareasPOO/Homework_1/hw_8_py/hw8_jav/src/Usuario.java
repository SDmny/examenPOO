import java.util.Random;
import java.util.ArrayList;

public class Usuario {
    Random ran = new Random();
    int __id = 0;
    String __nombre = "";
    int __edad = 0;
    ArrayList<Libro> __libros_rentados = new ArrayList<>();

    public Usuario(String nombre, int edad) {
        this.__id = ran.nextInt(1000);
        this.__nombre = nombre;
        this.__edad = edad;
    }

    public String get_nombre() {
        return this.__nombre;
    }

    public int get_id() {
        return this.__id;
    }

    public boolean have_a_book() {
        if (this.__libros_rentados.size() != 0) {
            return true;
        } else
            return false;
    }

    public void show_books() {
        if (this.__libros_rentados.size() != 0) {
            System.out.println("Libros: ");
            for (Libro libro : this.__libros_rentados) {
                libro.get_data();
            }
        }
    }

    public void rentar_libro(Libro libro) {
        this.__libros_rentados.add(libro);
    }

    public void devolver_libro(String name) {
        int h = -4;
        for (Libro libro : this.__libros_rentados) {
            if (libro.get_nombre().equals(name)) {
                h = this.__libros_rentados.indexOf(libro);
            }
        }
        if (h != -4) {
            if (h == 0) {
                this.__libros_rentados.clear();
            } else {
                this.__libros_rentados.remove(h);
            }

        }
    }
}
