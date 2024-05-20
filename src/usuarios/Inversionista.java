package usuarios;

import sistema.Sistema;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;
import usuarios.utils.Sucursal;
import utils.Fondos;
import utils.UsuarioEnSesion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Inversionista extends Usuario {
    ArrayList<Fondos> fondosRegistro;

    public Inversionista(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curb, String direccion, Sucursal sucursal, String usuario, String contrasena, LocalDate birth) {
        super(nombre, apellido1, apellido2, sexo, ciudad, estado, curb, direccion, sucursal, Gente.INVERSIONISTA, usuario, contrasena, birth);
        fondosRegistro = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }

    // invertir
    public static void invertir(String nombre, String apellido) {
        Scanner scanner = new Scanner(System.in);
        double inversion = 0;
        boolean incorrecto = true;
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
        ((Inversionista) UsuarioEnSesion.getInstancia().getUsuarioActual()).getFondosRegistro().add(fondo);
    }

    //METODOS INVERSIONISTA
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
        int eliminar = 0;
        if (!Sistema.usuarios.containsKey(Gente.INVERSIONISTA)) {
            System.out.println("No hay inversionistas registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.INVERSIONISTA)) {
                if (usuario.getId() == id) {
                    existe = true;
                    for (Fondos fondo : Sistema.fondos) {
                        for (Fondos fondo2 : ((Inversionista) usuario).getFondosRegistro()) {
                            if (fondo.getId() == fondo2.getId()) {
                                System.out.printf("El inversionista ha dado %f fondos ¿desea eliminar?", fondo.getInversion());
                                System.out.println("\n1. Si\n2. No");
                                try {
                                   eliminar = DatosComun.scanner.nextInt();
                                    DatosComun.scanner.nextLine();
                                    if (eliminar < 1 || eliminar > 2) {
                                        throw new Exception();
                                    }
                                } catch (Exception ew) {
                                    System.out.println("Esa opción no se encuentra");
                                    System.out.println("Sí el programa no continua, ingrese enter");
                                    DatosComun.scanner.nextLine();
                                }
                                if(eliminar==1){

                                Sistema.usuarios.get(Gente.INVERSIONISTA).remove(usuario);
                                    System.out.println("El inversionista se ha eliminado");
                                    existe=false;
                                break;}
                                else {

                                    System.out.println("El inversionista no se eliminó");
                                }
                            }
                            else {

                                Sistema.usuarios.get(Gente.INVERSIONISTA).remove(usuario);
                                System.out.println("El inversionista se ha eliminado");
                                existe=false;
                                break;

                            }
                        }

                    }
                    if(Sistema.fondos.isEmpty()){
                        Sistema.usuarios.get(Gente.INVERSIONISTA).remove(usuario);
                        System.out.println("El inversionista se ha eliminado");
                        existe=false;
                        break;
                    }
                }
                if(!existe){
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

    public ArrayList<Fondos> getFondosRegistro() {
        return fondosRegistro;
    }

    public void setFondosRegistro(ArrayList<Fondos> fondosRegistro) {
        this.fondosRegistro = fondosRegistro;
    }
}
