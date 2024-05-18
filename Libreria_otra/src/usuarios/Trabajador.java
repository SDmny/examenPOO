package usuarios;
import biblioteca.Menu;
import biblioteca.Biblioteca;
import biblioteca.DatosComun;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;


public class Trabajador extends Usuario {
    LocalDate fechaRegistro = LocalDate.now();
    double sueldo;

    public Trabajador(String nombre, String apellido, String nombreUsuario, String numeroTelefono, String contraseña, LocalDate fechaNacimiento, double sueldo) {
        super(nombre, apellido, Rol.TRABAJADOR, nombreUsuario, numeroTelefono, contraseña, fechaNacimiento);
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", fecha de registro %s\nSueldo: %f", fechaRegistro, sueldo);
    }
    @Override
    public void checarEntrada(){
        System.out.println("Checar entrada por correo ");}
    @Override
    public void checarSalida(){
        System.out.println("Checar salida por correo ");
    }
    public static void mostrarTrabajadores() {
        System.out.println("\nTrabajadores: \n");
        if (!Biblioteca.usuarios.containsKey(Rol.TRABAJADOR)) {
            System.out.println("There are no employees registered\n");
        } else {
            for (Usuario user : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {

                Trabajador trabajador = (Trabajador) user;
                System.out.println(trabajador.toString());
            }
        }
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public static void registrarTrabajador() {
        System.out.println("\nRegistrar trabajador: ");

        ArrayList<String> commonData = DatosComun.obtenerDatos(Rol.TRABAJADOR);

        String nombre = commonData.get(0);
        String apellido = commonData.get(1);
        String telefono = commonData.get(2);
        String usuario = commonData.get(3);
        String contraseña = commonData.get(4);
        LocalDate fechaNacimiento = DatosComun.asignarFecha();
        System.out.println("Ingrese el sueldo: ");
        double sueldo = Biblioteca.scanner.nextDouble();
        Trabajador trabajador = new Trabajador(nombre, apellido, telefono, usuario, contraseña, fechaNacimiento, sueldo);

        if (!Biblioteca.usuarios.containsKey(Rol.TRABAJADOR)) {
            Biblioteca.usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        }
        Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);


        System.out.println("\nEl trabajador ha sido agregado. \n");
    }

    public static void eliminarTrabajador(int id) {
        boolean existe = false;
        for (Map.Entry<Rol, ArrayList<Usuario>> entry : Biblioteca.usuarios.entrySet()) {
            for (Usuario user : entry.getValue()) {
                if (user.getId() == (id)) {
                    entry.getValue().remove(user);
                    existe = true;
                }
            }
        }
        if (!existe) {


        }
    }
    public static void mostrarTrabajador(int id) {
        System.out.println("\nTrabajador: \n");
        if (!Biblioteca.usuarios.containsKey(Rol.TRABAJADOR)) {
            System.out.println("No hay trabajadores registrados:\n");
        } else {
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {
                if (usuario.getId() == id) {
                    Trabajador trabajador= (Trabajador)  usuario;
                    System.out.println(trabajador.toString());
                }
            }
        }
    }
    public static void modificarTrabajador(int id) {
        boolean existe = false;
        String dato = "";
        char opcion = ' ';
        ArrayList<String> datos = new ArrayList<>();
        for (Map.Entry<Rol, ArrayList<Usuario>> entry : Biblioteca.usuarios.entrySet()) {
            for (Usuario user : entry.getValue()) {
                if (user.getId() == (id)) {
                    while (opcion != '0') {
                        dato = DatosComun.ModificarUnDato();
                        opcion = dato.charAt(dato.length() - 1);
                        dato = dato.substring(0, dato.length() - 2);
                        switch (opcion) {
                            case '0':
                                System.out.println("Usted salió de modificar");
                                break;
                            case '1':
                                user.setNombre(dato);
                                break;
                            case '2':
                                user.setApellido(dato);
                                break;
                            case '3':
                                user.setFechaNacimiento(DatosComun.asignarFecha());
                                break;
                            case '4':
                                user.setContrasena(dato);
                                break;
                            case '5':
                                user.setNombreUsuario(dato);
                                break;
                            case '6':
                                user.setNumeroTelefono(dato);
                                break;
                            case '7':
                                System.out.println("Para modificar salario ingrese 1 ");
                                System.out.println("Para NO modificar ingrese otro número: ");
                                try{
                                double nsueldo=Biblioteca.scanner.nextDouble();
                                ((Trabajador)(user)).setSueldo(nsueldo);}
                                catch (Exception e){
                                    System.out.println("Ese no era un número");
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (!existe) {
            System.out.println("El id del empleado no existe xd");
        }

    }


}
