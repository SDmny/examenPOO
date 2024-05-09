package Usuarios;

import Tarjetas.TarjetaDebito;
import Usuarios.utils.Gente;
import Usuarios.utils.Sucursal;

public class Inversionista extends Usuario{
    public Inversionista(String nombre, String apellido1, String apellido2, String ciudad, String estado, String curb, String direccion, Sucursal sucursal, TarjetaDebito tarjeta, Gente rol) {
        super(nombre, apellido1, apellido2, ciudad, estado, curb, direccion, sucursal,rol);

    }
}
