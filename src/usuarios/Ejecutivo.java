package usuarios;

import sistema.Sistema;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;
import usuarios.utils.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ejecutivo extends Empleado {
    public Ejecutivo(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curp, String direccion, Sucursal sucursal, double salario, String usuario, String contrasena, LocalDate birth){
        super( nombre,  apellido1,  apellido2,  sexo,  ciudad,  estado,  curp,  direccion,  sucursal,  Gente.EJECUTIVO,  salario,usuario,  contrasena,birth);
    }
    public static void registrarInversionista(){
        System.out.println("- - - Registrar Cliente - - -");
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
        LocalDate birth=LocalDate.parse(datosComun.get(10));
        //Cliente cliente = new Cliente(nombre, apellido1, apellido2, sexo, ciudad, estado, curp, direccion, usuario, contrasena,birth);
        if (!Sistema.usuarios.containsKey(Gente.CLIENTE)){
            Sistema.usuarios.put(Gente.CLIENTE, new ArrayList<>());
        }
        //Sistema.usuarios.get(Gente.CLIENTE).add(cliente);
        System.out.println("Cliente registrado");
    }
}
