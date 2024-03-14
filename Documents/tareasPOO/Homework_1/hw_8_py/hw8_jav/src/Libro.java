import java.util.Random; 

public class Libro {
    Random ran = new Random();
    int __id = 0;
    String __nombre = "";
    String __autor = "";
    boolean __es_rentado = false;

    public Libro(String nombre, String autor) {
        this.__id = ran.nextInt(0, 1000);
        this.__nombre = nombre;
        this.__autor = autor;
    }

    public String get_nombre() {
        return this.__nombre;
    }

    public String get_autor() {
        return this.__autor;
    }

    public int get_id() {
        return this.__id;
    }

    public void get_data() {
        System.out.println("El libro es "+ this.__nombre+" y su autor es "+this.__autor);
        System.out.println();
    }

    public boolean get_rentado() {
        return this.__es_rentado;
    }

    public void rentar() {
        this.__es_rentado = true;
    }

    public void devolver() {
        this.__es_rentado = false;
    }

}
