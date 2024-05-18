package usuarios;

import biblioteca.Biblioteca;
import biblioteca.DatosComun;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;


public class Gerente extends Usuario {
    private static Gerente gerente;
    private Gerente(String nombre, String apellido, String nombreUsuario, String numeroTelefono, String contraseña, LocalDate fechaNacimiento) {
        super(nombre, apellido, Rol.GERENTE, nombreUsuario, numeroTelefono, contraseña, fechaNacimiento);
    }

    public static Gerente getGerente(){
        if(gerente!=null){
            return gerente;
        }
        registrarGerente();
        return gerente;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public void checarEntrada(){
        System.out.println("Checar entrada por correo ");}
    @Override
    public void checarSalida(){
        System.out.println("Checar salida por correo ");
    }

    private   static void registrarGerente() {
        System.out.println("\nRegistrar Gerente: ");

        ArrayList<String> commonData = DatosComun.obtenerDatos(Rol.GERENTE);

        String nombre = commonData.get(0);
        String apellido = commonData.get(1);
        String telefono = commonData.get(2);
        String usuario = commonData.get(3);
        String contraseña = commonData.get(4);
        LocalDate fechaNacimiento = DatosComun.asignarFecha();
         gerente = new Gerente(nombre, apellido, telefono, usuario, contraseña, fechaNacimiento);

        if (!Biblioteca.usuarios.containsKey(Rol.GERENTE)) {
            Biblioteca.usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);


        System.out.println("\nEl Gerente ha sido agregado. \n");
    }

}
