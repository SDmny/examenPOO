package usuarios;

import usuarios.utils.Rol;

import java.time.LocalDate;

public class Gerente extends usuarios.utils.Usuario {
    public Gerente(String nombre, String apellido, String nombreUsuario,String numeroTelefono, String contraseña, LocalDate fechaNacimiento){
        super(nombre,apellido,Rol.CLIENTE,nombreUsuario,numeroTelefono,contraseña, fechaNacimiento);
    }
    @Override
    public String toString(){
        return super.toString();
    }

}
