package Usuarios;

import Usuarios.utils.Sucursal;
import Tarjetas.TarjetaDebito;
import Usuarios.utils.Gente;

public class Cliente extends Usuario {
    TarjetaDebito tarjeta;
    public Cliente(String nombre, String apellido1, String apellido2, String ciudad, String estado, String curb, String direccion, Sucursal sucursal, TarjetaDebito tarjeta, Gente rol) {
        super(nombre, apellido1, apellido2, ciudad, estado, curb, direccion, sucursal, Gente.CLIENTE);
        this.tarjeta=tarjeta;
    }

}
