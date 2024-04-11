package Usuario.utils;

import Usuario.Usuario;
import Usuario.Rol;

import java.time.LocalDate;

public class Cliente extends Usuario {
LocalDate fechaRegistro=LocalDate.now();
    public Cliente(String nombre, String apellido, String nombreUsuario, String contraseña, LocalDate fechaNacimiento){
        super(nombre,apellido,Rol.CLIENTE,nombreUsuario,contraseña, fechaNacimiento);
    }
    @Override
    public String toString(){
        return super.toString()+String.format(", fecha de registro %s",fechaRegistro);
    }

}
