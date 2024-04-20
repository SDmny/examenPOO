package usuarios;

import usuarios.utils.Rol;

import java.time.LocalDate;

public class Cliente extends usuarios.utils.Usuario {
    LocalDate fechaRegistro=LocalDate.now();
    public Cliente(String nombre, String apellido, String nombreUsuario,String numeroTelefono, String contraseña, LocalDate fechaNacimiento){
        super(nombre,apellido,Rol.CLIENTE,nombreUsuario,numeroTelefono,contraseña, fechaNacimiento);
    }
    @Override
    public String toString(){
        return super.toString()+String.format(", fecha de registro %s",fechaRegistro);
    }

}
