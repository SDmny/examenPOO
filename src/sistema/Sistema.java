package sistema;

import usuarios.utils.Gente;
import usuarios.Usuario;
import usuarios.utils.Sucursal;
import utils.Fondos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sistema {
    public static final Map<Gente, ArrayList<Usuario>> usuarios = new HashMap<Gente, ArrayList<Usuario>>();
    public static  ArrayList<Fondos> fondos = new ArrayList<Fondos>();

    //METODO ENCONTRAR SUCURSAL

    // ACTUALIZACION: lo deje en comentarios, quiero probar si así puedo usarlo directamente en metodos para que se busque solo
    // y evitar tener que poner ifs, el original está abajo
    public static Sucursal ObtenerSucursal(int id) {
        Sucursal sucursal = null;
        for (Map.Entry<Gente, ArrayList<Usuario>> entry : Sistema.usuarios.entrySet()) {
            for (Usuario user : entry.getValue()) {
                if (user.getId()==id) {
                    sucursal = user.getSucursal();
                    break;
                }
            }
        }
        return sucursal;

    }

    //Devuelve true sí es de Madero, no sé sí deba ir aqui pero weno
    //éste método no comprueba que el usuario exista xd, solo su sucursal
    public static boolean EncontrarSucursal(int id) {
        boolean sucursalMadero = true;
        for (Map.Entry<Gente, ArrayList<Usuario>> entry : Sistema.usuarios.entrySet()) {
            for (Usuario user : entry.getValue()) {
                if (user.getId()==id && user.getSucursal() == Sucursal.ACUEDUCTO) {
                    sucursalMadero = false;
                    break;
                }
            }
        }
        return sucursalMadero;

    }
    public static Usuario verificarInicioSesion(String nombreUsuario, String contrasena){
        for (Map.Entry<Gente, ArrayList<Usuario>> entry : usuarios.entrySet()){
            for (Usuario usuarioActual : entry.getValue()){
                if (usuarioActual.getNombre().equals(nombreUsuario) && usuarioActual.getContrasena().equals(contrasena)){
                    return usuarioActual;
                }
            }
        }
        return null;
    }

}
