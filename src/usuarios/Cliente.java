package usuarios;

import usuarios.utils.Sucursal;
import tarjetas.TarjetaDebito;
import usuarios.utils.Gente;

import java.time.LocalDate;

public class Cliente extends Usuario {
    TarjetaDebito tarjeta;
    public Cliente(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curb, String direccion, Sucursal sucursal, TarjetaDebito tarjeta, Gente rol, String usuario, String contrasena, LocalDate birth) {
        super(nombre, apellido1, apellido2, sexo, ciudad, estado, curb, direccion, sucursal, Gente.CLIENTE, usuario, contrasena,birth);
        this.tarjeta=tarjeta;
    }

}
