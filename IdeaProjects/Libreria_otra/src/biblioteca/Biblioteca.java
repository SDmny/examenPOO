package biblioteca;

import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Trabajador;
import usuarios.utils.Usuario;
import usuarios.utils.Rol;

import java.util.*;
import java.time.LocalDate;
;
public class Biblioteca {
    private ArrayList <Usuario> ListaDeUsuarios= new ArrayList<>();
    static Map <Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    private static Scanner scanner = new Scanner(System.in);

    public  Biblioteca() {

    }

    public static void registrarGerente() {
        System.out.println("\nRegistrar Gerente: ");

        ArrayList<String> commonData = obtenerDatos(Rol.GERENTE);

        String nombre = commonData.get(0);
        String apellido = commonData.get(1);
        String telefono = commonData.get(2);
        String usuario = commonData.get(3);
        String contraseña = commonData.get(4);
        LocalDate fechaNacimiento=asignarFecha();
        Gerente gerente = new Gerente (nombre,apellido,telefono,usuario,contraseña,fechaNacimiento);

        if (!usuarios.containsKey(Rol.GERENTE)){
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);


        System.out.println("\nEl Gerente ha sido agregado. \n");
    }
    public void registrarTrabajador() {
        System.out.println("\nRegistrar trabajador: ");

        ArrayList<String> commonData = obtenerDatos(Rol.TRABAJADOR);

        String nombre = commonData.get(0);
        String apellido = commonData.get(1);
        String telefono = commonData.get(2);
        String usuario = commonData.get(3);
        String contraseña = commonData.get(4);
        LocalDate fechaNacimiento=asignarFecha();
        System.out.println("Ingrese el sueldo: ");
        double sueldo =scanner.nextDouble();
        Trabajador trabajador = new Trabajador (nombre,apellido,telefono,usuario,contraseña,fechaNacimiento,sueldo);

        if (!usuarios.containsKey(Rol.TRABAJADOR)){
                usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.TRABAJADOR).add(trabajador);


        System.out.println("\nEl trabajador ha sido agregado. \n");
    }


    private static ArrayList<String> obtenerDatos(Rol rol){

        ArrayList<String> Datos = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        String CurrentRole = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.TRABAJADOR ? "Trabajador" : "Gerente";

        System.out.println("\nRegistrar usuarios."+CurrentRole);

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido: ");
        String apellido = scanner.nextLine();
        System.out.println("Ingresa el telefono: ");
        String telefono = getPhone();
        System.out.println("Ingresa el nombre de usuario: ");
        String nombreUsuario = getUsername();

        System.out.println("Ingresa la contrasena: ");
        String contrasena = scanner.nextLine();

        Datos.addAll(Arrays.asList(nombre,apellido,telefono,nombreUsuario,contrasena));
        return Datos;
    }
    private static String getPhone() {
        Scanner scan = new Scanner(System.in);
        boolean existe = true;
        String telefono = "";

        do {
            System.out.println("Ingresar: ");
            telefono = scan.nextLine();

            existe = false;
            if (telefono.length() == 10){
                for(Map.Entry<Rol, ArrayList<Usuario>> entry : usuarios.entrySet()){
                    for (Usuario usuario : entry.getValue()){
                        if (usuario.getNumeroTelefono().equals(telefono)) {
                            existe = true;
                            break;
                        }
                    }
                }

                if (existe) {
                    System.out.println("Número en uso, volver a ingresar.");

                }
            }
            else {
                System.out.println("El número se ha registrado");

            }



        } while (existe);

        return telefono;
    }

    private static String getUsername() {
        Scanner scan = new Scanner(System.in);
        boolean existe;
        String username = "";

        do {
            System.out.println("Ingresar: ");
            username = scan.nextLine();

            existe = false;
            for(Map.Entry<Rol, ArrayList<Usuario>> entry : usuarios.entrySet()){
                for (Usuario user : entry.getValue()){
                    if (user.getNombreUsuario().equals(username)) {
                        existe = true;
                        break;
                    }
                }
            }

            if (existe) {
                System.out.println("El nombre de usuario ya está en uso");
            }
        } while (existe);

        return username;
    }
    public void registrarCliente() {
        System.out.println("\nRegistrar cliente: ");

        ArrayList<String> commonData = obtenerDatos(Rol.CLIENTE);

        String nombre = commonData.get(0);
        String apellido = commonData.get(1);
        String telefono = commonData.get(2);
        String usuario = commonData.get(3);
        String contraseña = commonData.get(4);
        LocalDate fechaNacimiento=asignarFecha();

        Cliente cliente = new Cliente (nombre,apellido,telefono,usuario,contraseña,fechaNacimiento);

        if (!usuarios.containsKey(Rol.CLIENTE)){
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.CLIENTE).add(cliente);


        System.out.println("\nEl cliente ha sido agregado. \n");
    }

    public void mostrarTrabajadores() {
        System.out.println("\nTrabajadores: \n");
        if (!usuarios.containsKey(Rol.TRABAJADOR)) {
            System.out.println("There are no employees registered\n");
        } else {
            for (Usuario user : usuarios.get(Rol.TRABAJADOR)) {

                Trabajador trabajador = (Trabajador) user;
                System.out.println(trabajador.toString());
            }
        }
    }
    public void mostrarClientes() {
        System.out.println("\nClientes: \n");
        if (!usuarios.containsKey(Rol.TRABAJADOR)) {
            System.out.println("No hay clientes registrados:\n");
        } else {
            for (Usuario usuario : usuarios.get(Rol.TRABAJADOR)) {

                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
            }
        }
    }






    public static LocalDate asignarFecha() {
        Scanner scanner = new Scanner(System.in);
        int dia = 43, mes = 1, ano = 2024;
        LocalDate fecha;
        while ((dia > 32 || dia < 0) || (mes < 0 || mes > 12) || (ano < 2023)) {
            System.out.println("Ingrese día: ");
            dia = scanner.nextInt();

            scanner.nextLine();
            System.out.println("Ingrese mes: ");
            mes = scanner.nextInt();

            scanner.nextLine();
            System.out.println("Ingrese año: ");
            ano = scanner.nextInt();

            scanner.nextLine();

        }
        fecha = LocalDate.of(ano, mes, dia);
        return fecha;
    }
}

