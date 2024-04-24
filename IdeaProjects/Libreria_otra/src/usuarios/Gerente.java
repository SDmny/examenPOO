package usuarios;

import biblioteca.Biblioteca;
import biblioteca.DatosComun;
import usuarios.utils.Rol;
import usuarios.utils.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gerente extends usuarios.utils.Usuario {
    public Gerente(String nombre, String apellido, String nombreUsuario, String numeroTelefono, String contraseña, LocalDate fechaNacimiento) {
        super(nombre, apellido, Rol.CLIENTE, nombreUsuario, numeroTelefono, contraseña, fechaNacimiento);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void registrarGerente() {
        System.out.println("\nRegistrar Gerente: ");

        ArrayList<String> commonData = DatosComun.obtenerDatos(Rol.GERENTE);

        String nombre = commonData.get(0);
        String apellido = commonData.get(1);
        String telefono = commonData.get(2);
        String usuario = commonData.get(3);
        String contraseña = commonData.get(4);
        LocalDate fechaNacimiento = DatosComun.asignarFecha();
        Gerente gerente = new Gerente(nombre, apellido, telefono, usuario, contraseña, fechaNacimiento);

        if (!Biblioteca.usuarios.containsKey(Rol.GERENTE)) {
            Biblioteca.usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);


        System.out.println("\nEl Gerente ha sido agregado. \n");
    }

}
