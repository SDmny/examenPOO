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

    //METODOS CAPTURISTAS
    public static void registrarCapturista() {
        System.out.println("- - - Registrar Capturista de Cuenta - - -");
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
        double salario = asignarSalario();
        Ejecutivo ejecutivo = new Ejecutivo(nombre, apellido1, apellido2, sexo, ciudad, estado, curp, direccion, UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal(), salario, usuario, contrasena, birth);
        if (!Sistema.usuarios.containsKey(Gente.CAPTURISTA)) {
            Sistema.usuarios.put(Gente.CAPTURISTA, new ArrayList<>());
        }
        Sistema.usuarios.get(Gente.CAPTURISTA).add(ejecutivo);
        System.out.println("Capturista registrado");
    }
    public static void eliminarCapturista(int id) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.CAPTURISTA)) {
            System.out.println("No hay capturistas registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.CAPTURISTA)) {
                if (usuario.getId() == id) {
                    existe = true;
                    Sistema.usuarios.get(Gente.CAPTURISTA).remove(usuario);
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Capturista no existe");
            }
        }

    }

    public static void mostrarCapturista(String user) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.CAPTURISTA)) {
            System.out.println("No hay capturistas registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.CAPTURISTA)) {
                if (usuario.getUsuario().equals(user)) {
                    existe = true;
                    System.out.println(usuario.toString());
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Capturista no existe");
            }
        }
    }

    public static void modificarCapturista(int id) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.CAPTURISTA)) {
            System.out.println("No hay capturistas registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.CAPTURISTA)) {
                if (usuario.getId() == id) {
                    existe = true;
                    ((Empleado) usuario).modificarEmpleado();
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Capturista no existe");
            }
        }

    }
    public static void mostrarCapturistas() {
        if (!Sistema.usuarios.containsKey(Gente.CAPTURISTA)) {
            System.out.println("No hay capturistas registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.CAPTURISTA)) {
                System.out.println(usuario);
            }
        }
    }

}