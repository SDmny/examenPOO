package usuarios;

import sistema.Sistema;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;
import usuarios.utils.Sucursal;
import utils.Fondos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Inversionista extends Usuario{
    public Inversionista(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curb, String direccion, Sucursal sucursal, String usuario, String contrasena, LocalDate birth) {
        super(nombre, apellido1, apellido2, sexo, ciudad, estado, curb, direccion, sucursal, Gente.INVERSIONISTA, usuario, contrasena,birth);
    }

    @Override
    public String toString(){
        return String.format("%s", super.toString());
    }

    // invertir
    public static void invertir(String nombre, String apellido){
        Scanner scanner = new Scanner(System.in);
        double inversion=0;
        boolean incorrecto=true;
        while (incorrecto) {
            try {
                incorrecto = false;
                System.out.println("Cantidad a invertir: ");
                inversion = scanner.nextDouble();
            } catch (Exception ew) {
                incorrecto = true;
                System.out.println("Hubo un error al ingresar los datos");
            }
        }
        Fondos fondo = new Fondos(nombre, apellido, inversion);
        Sistema.fondos.add(fondo);
    }
    //METODOS INVERSIONISTA
//Requiere la sucursal de quien lo ejecuta, así que se usa en otras clases
    public static void registrarInversionista(Sucursal sucursal) {
        System.out.println("- - - Registrar Inversionista - - -");
        ArrayList<String> datosComun = DatosComun.obtenerDatos();
        String nombre = datosComun.get(0);
        String apellido1 = datosComun.get(1);
        String apellido2 = datosComun.get(2);
        char sexo = datosComun.get(3).charAt(0);
        String ciudad = datosComun.get(4);
        String estado = datosComun.get(5);
        String curp = datosComun.get(6);
        String direccion = datosComun.get(7);
        String usuario = datosComun.get(8);
        String contrasena = datosComun.get(9);
        LocalDate birth = LocalDate.parse(datosComun.get(10));
        Inversionista inversionista = new Inversionista(nombre, apellido1, apellido2, sexo, ciudad, estado, curp, direccion, sucursal, usuario, contrasena, birth);
        if (!Sistema.usuarios.containsKey(Gente.INVERSIONISTA)) {
            Sistema.usuarios.put(Gente.INVERSIONISTA, new ArrayList<>());
        }
        Sistema.usuarios.get(Gente.INVERSIONISTA).add(inversionista);
        System.out.println("Inversionista registrado");
    }

    public static void eliminarInversionista(int id) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.INVERSIONISTA)) {
            System.out.println("No hay inversionistas registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.INVERSIONISTA)) {
                if (usuario.getId() == id) {
                    existe = true;
                    Sistema.usuarios.get(Gente.INVERSIONISTA).remove(usuario);
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Inversionista no existe");
            }
        }

    }

    public static void mostrarInversionista(String user) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.INVERSIONISTA)) {
            System.out.println("No hay inversionistas registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.INVERSIONISTA)) {
                if (usuario.getUsuario().equals(user)) {
                    existe = true;
                    System.out.println(usuario.toString());
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Inversionista no existe");
            }
        }
    }

    public static void modificarInversionista(int id) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.INVERSIONISTA)) {
            System.out.println("No hay inversionistas registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.INVERSIONISTA)) {
                if (usuario.getId() == id) {
                    existe = true;
                    usuario.ModificarDato();
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Inversionista no existe");
            }
        }
    }

    public static void mostrarInversionistas() {
        if (!Sistema.usuarios.containsKey(Gente.INVERSIONISTA)) {
            System.out.println("No hay inversionistas registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.INVERSIONISTA)) {
                System.out.println(usuario);
            }
        }
    }
}
