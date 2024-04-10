package Cliente;

import Usuario.Usuario;
import Usuario.Rol;

import java.time.LocalDate;
public class Cliente extends Usuario {
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido){
        super(nombre,apellido,Rol.CLIENTE);
        this.fechaRegistro=LocalDate.now();
    }
    @Override
    public String toString(){
        return super.toString()+String.format(", fecha de registro %s",fechaRegistro);
    }

}
