package usuarios;

import sistema.Sistema;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;
import usuarios.utils.Sucursal;
import utils.UsuarioEnSesion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Gerente extends Empleado {
    private static Gerente geMad;
    private static Gerente geAcue;

    private Gerente(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curp, String direccion, Sucursal sucursal, double salario, String usuario, String contrasena, LocalDate birth) {
        super(nombre, apellido1, apellido2, sexo, ciudad, estado, curp, direccion, sucursal, Gente.GERENTE, salario, usuario, contrasena, birth);
        //Contraseña Gerente Madero= a
        // Contraseña Gerente Acueducto= b

    }

    public static Gerente getGeMad() {
        if (geMad == null) {
            geMad = new Gerente("Kaeya", "Alberich", "García", 'M', "Mondstad", "Teyvat", "", "Taberna Cola de Gato, no. 456", Sucursal.MADERO, 50000, "Captain", "a", LocalDate.of(1998, 11, 12));
        }
        return geMad;
    }

    public static Gerente getGeAcue() {
        if (geAcue == null) {
            geAcue = new Gerente("Misaka", "Mikoto", "Gonzalez", 'F', "Tokio", "Kanto", "", "Gakuen Toshi no.67", Sucursal.ACUEDUCTO, 50000, "Hime", "b", LocalDate.of(2002, 11, 12));
        }
        return geAcue;
    }

    public void cambiarGeMad() {
        System.out.println("- - - Cambiar Gerente - - -");
        ArrayList<String> datosComun = DatosComun.obtenerDatos();
        geMad.setNombre(datosComun.get(0));
        geMad.setApellido1(datosComun.get(1));
        geMad.setApellido2(datosComun.get(2));
        geMad.setSexo(datosComun.get(3).charAt(0));
        geMad.setCiudad(datosComun.get(4));
        geMad.setEstado(datosComun.get(5));
        geMad.setCurb(datosComun.get(6));
        geMad.setDireccion(datosComun.get(7));
        geMad.setUsuario(datosComun.get(8));
        geMad.setContrasena(datosComun.get(9));
        LocalDate birth = LocalDate.parse(datosComun.get(10));
        geMad.setBirth(birth);
        geMad.setSalario(asignarSalario());

    }

    public void cambiarGeAcue() {
        System.out.println("- - - Cambiar Gerente - - -");
        ArrayList<String> datosComun = DatosComun.obtenerDatos();
        geAcue.setNombre(datosComun.get(0));
        geAcue.setApellido1(datosComun.get(1));
        geAcue.setApellido2(datosComun.get(2));
        geAcue.setSexo(datosComun.get(3).charAt(0));
        geAcue.setCiudad(datosComun.get(4));
        geAcue.setEstado(datosComun.get(5));
        geAcue.setCurb(datosComun.get(6));
        geAcue.setDireccion(datosComun.get(7));
        geAcue.setUsuario(datosComun.get(8));
        geAcue.setContrasena(datosComun.get(9));
        LocalDate birth = LocalDate.parse(datosComun.get(10));
        geAcue.setBirth(birth);
        geAcue.setSalario(asignarSalario());
    }


    //METODOS INVERSIONISTA

    //Le quite el statico a registrar para que quien lo use pueda pasarle su Sucursal, no sé sí es lo más correcto de momento
    // ACTUALIZACIÓN!!! dara error en un monton de lugares en el menu así que lo cambie y puse que para agarrar la sucursal
    // utilize UsuarioEnSesion.getInstancia.getUsuarioActual.getSucursal() o algo así, debería ser lo mismo en teoría
    public static void registrarInversionista() {
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
        Inversionista inversionista = new Inversionista(nombre, apellido1, apellido2, sexo, ciudad, estado, curp, direccion, UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal(), usuario, contrasena, birth);
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

    // Metodos ejecutivos fue transferido a Capturista.java porque ahí son más necesarios y exclusivos xd


}
