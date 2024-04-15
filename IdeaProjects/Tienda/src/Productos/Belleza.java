package Productos;

import java.time.LocalDate;

public class Belleza extends Producto {
    String color;
    int duracionDiaria;
    public Belleza(String name, double precio, int stock, int no, LocalDate fechaImportacion,String tipo, int duracionDiaria, String color){
        super( name,  precio, stock , no, fechaImportacion,tipo);
        this.color=color;
        this.duracionDiaria=duracionDiaria;
    }

    public int getDuracionDiaria() {
        return duracionDiaria;
    }

    public void setDuracionDiaria(int duracionDiaria) {
        this.duracionDiaria = duracionDiaria;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
