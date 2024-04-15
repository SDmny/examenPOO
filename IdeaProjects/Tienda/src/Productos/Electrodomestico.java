package Productos;

import java.time.LocalDate;

public class Electrodomestico extends Producto {
    double watts;
    String color, descripcion;

    public Electrodomestico(String name, double precio, int stock, int no, LocalDate fechaImportacion, String tipo, double watts,
                            String color, String descripcion) {
        super(name, precio, stock, no, fechaImportacion, tipo);
        this.watts = watts;
        this.descripcion = descripcion;
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWatts() {
        return watts;
    }

    public void setWatts(double watts) {
        this.watts = watts;
    }
}
