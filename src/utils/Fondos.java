package utils;

import usuarios.Inversionista;

import java.time.LocalDateTime;

public class Fondos {
    private String nombre;
    private String apellido;
    private double inversion;
    private LocalDateTime fecha;
    private int id;
    int CANT_FONDOS=1;
    public Fondos(String nombre, String apellido, double inversion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.inversion = inversion;
        this.fecha = LocalDateTime.now();
        this.id = CANT_FONDOS;
        CANT_FONDOS++;
    }
    @Override
    public String toString(){
        String cadena = String.format("%d - Inversionista: %s %s; Inversión: %f", id, nombre, apellido, inversion);
        return cadena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getInversion() {
        return inversion;
    }

    public void setInversion(double inversion) {
        this.inversion = inversion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCANT_FONDOS() {
        return CANT_FONDOS;
    }

    public void setCANT_FONDOS(int CANT_FONDOS) {
        this.CANT_FONDOS = CANT_FONDOS;
    }
}
