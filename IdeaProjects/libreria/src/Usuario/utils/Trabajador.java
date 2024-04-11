package Usuario.utils;

import Usuario.Usuario;
import Usuario.Rol;

import java.time.LocalDate;

public class Trabajador extends Usuario {
    LocalDate fechaRegistro=LocalDate.now();
    double sueldo;
    public Trabajador(String nombre, String apellido, String nombreUsuario, String contraseña, LocalDate fechaNacimiento, double sueldo){
        super(nombre,apellido,Rol.CLIENTE,nombreUsuario,contraseña, fechaNacimiento);
        this.sueldo=sueldo;
    }
    @Override
    public String toString(){
        return super.toString()+String.format(", fecha de registro %s\nSueldo: %f",fechaRegistro,sueldo);
    }

}
