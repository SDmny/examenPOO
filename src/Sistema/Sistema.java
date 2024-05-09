package Sistema;

import Usuarios.utils.Gente;
import Usuarios.Usuario;
import Usuarios.utils.Sucursal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sistema {
    public static final Map<Gente, ArrayList<Usuario>> usuarios = new HashMap<Gente, ArrayList<Usuario>>();

    //METODO ENCONTRAR SUCURSAL
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

}
