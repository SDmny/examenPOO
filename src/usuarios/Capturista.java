package usuarios;

import sistema.Sistema;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;
import usuarios.utils.Sucursal;
import utils.UsuarioEnSesion;

import java.time.LocalDate;
import java.util.ArrayList;

public class Capturista extends Empleado {
    public Capturista (String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curp, String direccion, Sucursal sucursal, double salario, String usuario, String contrasena, LocalDate birth){
        super( nombre,  apellido1,  apellido2,  sexo,  ciudad,  estado,  curp,  direccion,  sucursal,  Gente.CAPTURISTA, salario, usuario,  contrasena,birth);
    }


    //METODOS EJECUTIVOS

    // !!!! sobre el static: actualización escrita en gerente !!!!

    public static void registrarEjecutivos(){
        System.out.println("- - - Registrar Ejecutivo de Cuenta - - -");
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
        LocalDate birth=LocalDate.parse(datosComun.get(10));
        double salario= asignarSalario();
        Ejecutivo ejecutivo = new Ejecutivo(nombre, apellido1, apellido2, sexo, ciudad, estado, curp,direccion, UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal(), salario,usuario, contrasena,birth);
        if (!Sistema.usuarios.containsKey(Gente.EJECUTIVO)){
            Sistema.usuarios.put(Gente.EJECUTIVO, new ArrayList<>());
        }
        Sistema.usuarios.get(Gente.EJECUTIVO).add(ejecutivo);
        System.out.println("Ejecutivo registrado");
    }
    public static void eliminarEjecutivo(int id) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.EJECUTIVO)) {
            System.out.println("No hay ejecutivos registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.EJECUTIVO)) {
                if (usuario.getId() == id) {
                    existe = true;
                    Sistema.usuarios.get(Gente.EJECUTIVO).remove(usuario);
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Ejecutivo no existe");
            }
        }

    }

    public static void mostrarEjecutivo(String user) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.EJECUTIVO)) {
            System.out.println("No hay ejecutivos registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.EJECUTIVO)) {
                if (usuario.getUsuario().equals(user)) {
                    existe = true;
                    System.out.println(usuario.toString());
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Ejecutivo no existe");
            }
        }
    }

    public static void modificarEjecutivo(int id) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.EJECUTIVO)) {
            System.out.println("No hay ejecutivos registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.EJECUTIVO)) {
                if (usuario.getId() == id) {
                    existe = true;
                    ((Empleado) usuario).modificarEmpleado();
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Ejecutivo no existe");
            }
        }

    }
    public static void mostrarEjecutivos() {
        if (!Sistema.usuarios.containsKey(Gente.EJECUTIVO)) {
            System.out.println("No hay ejecutivos registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.EJECUTIVO)) {
                System.out.println(usuario);
            }
        }
    }


}