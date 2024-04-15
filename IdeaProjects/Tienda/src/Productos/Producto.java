package Productos;

import java.time.LocalDate;
import java.util.Objects;

public class Producto {

    protected String name, tipo;
    protected double precio;
    protected int stock, no, id;
    protected LocalDate fechaImportacion;


    public Producto(String name, double precio, int stock, int no, LocalDate fechaImportacion, String tipo) {
        this.name = name;
        this.precio = precio;
        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }
        this.no = no;
        this.fechaImportacion = fechaImportacion;
        this.tipo = tipo;

    }

    public LocalDate getFechaImportacion() {
        return fechaImportacion;
    }

    public void setFechaImportacion(LocalDate fechaImportacion) {
        this.fechaImportacion = fechaImportacion;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        if (Objects.equals(name, "")) {
            return "No hay nombre";
        } else {
            return name;
        }
    }

    public void setName(String name) {

        this.name = name;

    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    public int getStock() {
        return this.stock;
    }

    public void aumentarStock(int stock) {
        if (stock >= 0) {
            this.stock = this.stock + stock;
        } else {
            System.out.println("No se puede introducir una cantidad negativa");
        }
    }

    public boolean reducirStock(int stock) {
        boolean cPuede;
        if (stock <= this.stock) {
            this.stock = this.stock - stock;
            cPuede = true;
        } else {
            System.out.println("No se puede comprar " + this.name + " " + this.id + ", hay menos productos en stock de los que se piden");
            cPuede = false;
        }
        return cPuede;

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Nombre='" + name + '\'' +
                ", Tipo de producto='" + tipo + '\'' +
                ", Precio=" + precio +
                ", stock=" + stock +
                ", Número de serie=" + no +
                ", Fecha de importacion=" + fechaImportacion +
                ", Id= " + id +
                '}';
    }
}

