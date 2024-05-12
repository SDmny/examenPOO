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
    public String toString(){
        String cadena = String.format("%d - Inversionista: %s %s; Inversión: %f", id, nombre, apellido, inversion);
        return cadena;
    }
}
