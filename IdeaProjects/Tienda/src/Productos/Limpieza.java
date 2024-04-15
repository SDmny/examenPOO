package Productos;

import java.time.LocalDate;

public class Limpieza extends Producto {
    String aroma;
    boolean recomend;

    public Limpieza(String name, double precio, int stock, int no, LocalDate fechaImportacion, String tipo, String aroma, Boolean recomend) {
        super(name, precio, stock, no, fechaImportacion, tipo);
        this.aroma = aroma;
        this.recomend = recomend;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public boolean isRecomend() {
        return recomend;
    }

    public void setRecomend(boolean recomend) {
        this.recomend = recomend;
    }


public String toString(){
        String si=" no";
        if(recomend){
            si=" si";
        }

    return super.toString()+" aroma: "+this.aroma+ " Recomendado"+si;
}}