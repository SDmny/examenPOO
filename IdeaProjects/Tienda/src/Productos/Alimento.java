package Productos;

import java.time.LocalDate;

public class Alimento extends Producto {
    LocalDate caducidad,fechaActual;
    boolean caduco=false;

    public Alimento(String name, double precio, int stock, int no, LocalDate fechaImportacion, String tipo, LocalDate caducidad) {
        super(name, precio, stock, no, fechaImportacion, tipo);
        fechaActual=LocalDate.now();
        this.caducidad = caducidad;
        if (fechaActual.isAfter(caducidad)) {
            System.out.println("Este producto está caduco");
            caduco=true;
        }
    }

    public LocalDate getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(LocalDate caducidad) {
        this.caducidad = caducidad;
        if (fechaActual.isAfter(caducidad)) {
            System.out.println("Este producto está caduco");
            caduco=true;
        }
    }

}
