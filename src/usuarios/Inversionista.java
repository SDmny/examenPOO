package usuarios;

import usuarios.utils.Gente;
import usuarios.utils.Sucursal;

public class Inversionista extends Usuario{
    public Inversionista(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curb, String direccion, Sucursal sucursal, Gente rol, String contrasena) {
        super(nombre, apellido1, apellido2, sexo, ciudad, estado, curb, direccion, sucursal,Gente.INVERSIONISTA, contrasena);
    }
}
