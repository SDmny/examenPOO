package usuarios;

import usuarios.utils.Sucursal;
import usuarios.utils.Gente;

public class Empleado extends Usuario {

    double salario;

    public Empleado(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curb, String direccion, Sucursal sucursal,  Gente rol, double salario, String usuario, String contrasena) {
        super(nombre, apellido1, apellido2, sexo, ciudad, estado, curb, direccion, sucursal, rol, usuario, contrasena);
        this.salario = salario;

    }
}
