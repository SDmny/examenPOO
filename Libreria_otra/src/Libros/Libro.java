package Libros;

import Libros.constants.Genero;

import java.time.LocalDate;

public abstract class Libro {
    String  nombre, autor,  editorial;
    LocalDate fechaDePublicacion;
    Genero genero;
    double precio;
    int stock;

public Libro(String  nombre, String autor, String editorial, LocalDate fechaDePublicacion, Genero genero, double precio, int stock){
    this.nombre=nombre;
    this.autor=autor;
    this.editorial=editorial;
    this.fechaDePublicacion=fechaDePublicacion;
    this.genero=genero;
    this.precio=precio;
    this.stock=stock;
}

public boolean comprar(){
    if(stock>0){
        stock=stock-1;
        return true;
    }
    else {
        System.out.println("El libro no se pudo comprar porque ya no hay");
        return false;
    }
}

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", fechaDePublicacion=" + fechaDePublicacion +
                ", genero=" + genero +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(LocalDate fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
