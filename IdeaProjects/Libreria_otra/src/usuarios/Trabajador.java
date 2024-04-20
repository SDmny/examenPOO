package usuarios;

import usuarios.utils.Rol;

import java.time.LocalDate;

public class Trabajador extends usuarios.utils.Usuario {
    LocalDate fechaRegistro=LocalDate.now();
    double sueldo;
    public Trabajador(String nombre, String apellido, String nombreUsuario,String numeroTelefono, String contraseña, LocalDate fechaNacimiento, double sueldo){
        super(nombre,apellido,Rol.CLIENTE,nombreUsuario,numeroTelefono,contraseña, fechaNacimiento);
        this.sueldo=sueldo;
    }
    @Override
    public String toString(){
        return super.toString()+String.format(", fecha de registro %s\nSueldo: %f",fechaRegistro,sueldo);
    }

}
