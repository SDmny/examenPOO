package biblioteca;

import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Trabajador;
import usuarios.utils.Usuario;
import usuarios.utils.Rol;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;


public class Biblioteca {
    private ArrayList<Usuario> ListaDeUsuarios = new ArrayList<>();
    public static final Map<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    public static Scanner scanner = new Scanner(System.in);

    public Biblioteca() {

    }

    public static void registrarGerente() {
        Gerente.registrarGerente();
    }

    public void registrarTrabajador() {
       Trabajador.registrarTrabajador();
    }


    public void registrarCliente() {

        Cliente.registrarCliente();

    }

    public void mostrarTrabajadores() {
       Trabajador.mostrarTrabajadores();
    }

    public void mostrarClientes() {
        Cliente.mostrarClientes();
    }

    public void eliminarCliente(){
        System.out.println("Ingrese el id del cliente: ");
        int id=scanner.nextInt();
        Cliente.eliminarCliente(id);
    }
    public void eliminarTrabajador(){
        System.out.println("Ingrese el id del trabajador: ");
        int id=scanner.nextInt();
        Trabajador.eliminarTrabajador(id);
    }
    public void modificarCliente(){
        System.out.println("Ingrese el id del cliente: ");
        int id=scanner.nextInt();
        Cliente.modificarCliente(id);
    }
    public void modificarTrabajador(){
        System.out.println("Ingrese el id del trabajador: ");
        int id=scanner.nextInt();
        Trabajador.modificarTrabajador(id);
    }

    public void mostrarCliente(){
        System.out.println("Ingrese el id del cliente: ");
        int id=scanner.nextInt();
        Cliente.mostrarCliente(id);
    }
    public void mostrarTrabajador(){
        System.out.println("Ingrese el id del trabajador: ");
        int id=scanner.nextInt();
       Trabajador.mostrarTrabajador(id);
    }

}

