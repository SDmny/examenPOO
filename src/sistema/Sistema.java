package sistema;

import tarjetas.utils.SolicitudTarjetaC;
import usuarios.Gerente;
import usuarios.utils.Gente;
import usuarios.Usuario;
import usuarios.utils.Sucursal;
import utils.Fondos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sistema {
    public static final Map<Gente, ArrayList<Usuario>> usuarios = new HashMap<Gente, ArrayList<Usuario>>();
    public static  ArrayList<Fondos> fondos = new ArrayList<Fondos>();
    public static  ArrayList<SolicitudTarjetaC> solicitudes = new ArrayList<SolicitudTarjetaC>();

    //METODO ENCONTRAR SUCURSAL

    // ACTUALIZACION: lo deje en comentarios, quiero probar si así puedo usarlo directamente en metodos para que se busque solo
    // y evitar tener que poner ifs, el original está abajo
    //oki :>
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
    public static void inicializar(){
        usuarios.put(Gente.EJECUTIVO, new ArrayList<>());
        usuarios.put(Gente.CLIENTE, new ArrayList<>());
        usuarios.put(Gente.GERENTE, new ArrayList<>());
        usuarios.put(Gente.INVERSIONISTA, new ArrayList<>());
        usuarios.put(Gente.CAPTURISTA, new ArrayList<>());
        Gerente gMad = new Gerente("Kaeya", "Alberich", "García", 'M', "Mondstad", "Teyvat", "", "Taberna Cola de Gato, no. 456", Sucursal.MADERO, 50000, "Captain", "a", LocalDate.of(1998, 11, 12));
        usuarios.get(Gente.GERENTE).add(gMad);
        Gerente gAcue = new Gerente("Misaka", "Mikoto", "Gonzalez", 'F', "Tokio", "Kanto", "", "Gakuen Toshi no.67", Sucursal.ACUEDUCTO, 50000, "Hime", "b", LocalDate.of(2002, 11, 12));
        usuarios.get(Gente.GERENTE).add(gAcue);
    }

}
