package usuarios;

import biblioteca.Biblioteca;
import biblioteca.DatosComun;
import usuarios.utils.Rol;
import usuarios.utils.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Cliente extends Usuario {
    LocalDate fechaRegistro = LocalDate.now();

    public Cliente(String nombre, String apellido, String nombreUsuario, String numeroTelefono, String contraseña, LocalDate fechaNacimiento) {
        super(nombre, apellido, Rol.CLIENTE, nombreUsuario, numeroTelefono, contraseña, fechaNacimiento);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", fecha de registro %s", fechaRegistro);
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public static void registrarCliente() {
        System.out.println("\nRegistrar cliente: ");

        ArrayList<String> commonData = DatosComun.obtenerDatos(Rol.CLIENTE);

        String nombre = commonData.get(0);
        String apellido = commonData.get(1);
        String telefono = commonData.get(2);
        String usuario = commonData.get(3);
        String contraseña = commonData.get(4);
        LocalDate fechaNacimiento = DatosComun.asignarFecha();

        Cliente cliente = new Cliente(nombre, apellido, telefono, usuario, contraseña, fechaNacimiento);

        if (!Biblioteca.usuarios.containsKey(Rol.CLIENTE)) {
            Biblioteca.usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        Biblioteca.usuarios.get(Rol.CLIENTE).add(cliente);


        System.out.println("\nEl cliente ha sido agregado. \n");
    }

    public static void mostrarClientes() {
        System.out.println("\nClientes: \n");
        if (!Biblioteca.usuarios.containsKey(Rol.CLIENTE)) {
            System.out.println("No hay clientes registrados:\n");
        } else {
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.CLIENTE)) {

                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }

    public static void mostrarCliente(int id) {
        System.out.println("\nCliente: \n");
        if (!Biblioteca.usuarios.containsKey(Rol.CLIENTE)) {
            System.out.println("No hay clientes registrados:\n");
        } else {
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.CLIENTE)) {
                if (usuario.getId() == id) {
                    Cliente cliente = (Cliente) usuario;
                    System.out.println(cliente.toString());
                }
            }
        }
    }

    public static void eliminarCliente(int id) {
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
            System.out.println("El id del empleado no existe xd");
        }

    }

    public static void modificarCliente(int id) {
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
                                System.out.println("No hay otros datos disponibles a cambiar en clientes");
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
