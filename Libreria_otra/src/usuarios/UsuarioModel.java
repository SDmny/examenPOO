package usuarios;

import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Trabajador;

import java.util.ArrayList;

/**
 * Esta clase representa el modelo o estructura que debe de tener el archivo JSON de usuarios
 *
 * Es obligatorio que coincida exáctamente con la estructura del JSON ya que de lo contrario arrojara un error al momento de hacer el parseo
 *
 */
public class UsuarioModel {
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<Gerente> gerente;
    private ArrayList<Cliente> clientes;

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public ArrayList<Gerente> getGerente() {
        return gerente;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}