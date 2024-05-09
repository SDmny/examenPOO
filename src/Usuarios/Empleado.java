package Usuarios;

import Usuarios.utils.Sucursal;
import Usuarios.utils.Gente;

public class Empleado extends Usuario {

    double salario;

    public Empleado(String nombre, String apellido1, String apellido2, String ciudad, String estado, String curb, String direccion, Sucursal sucursal,  Gente rol,double salario) {
        super(nombre, apellido1, apellido2, ciudad, estado, curb, direccion, sucursal, rol);
        this.salario = salario;

    }
}
