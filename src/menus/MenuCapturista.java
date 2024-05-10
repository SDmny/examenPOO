package menus;

import sistema.Sistema;
import usuarios.utils.DatosComun;
import usuarios.utils.Gente;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCapturista {
    static Scanner scanner = new Scanner(System.in);
    public static void menuCapturista(){
        String action;
        do {
            System.out.println("1 - Registrar ejecutivos de cuenta");
            System.out.println("2 - Modificar ejecutivos de cuenta");
            System.out.println("3 - Eliminar ejecutivos de cuenta");
            System.out.println("4 - Buscar ejecutivos de cuenta");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "0":
                    Menu.continuar();
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }
    public static void registrarEjecutivos(){
        System.out.println("- - - Registrar Ejecutivo de Cuenta - - -");
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
        //Ejecutivo ejecutivo = new Ejecutivo(nombre, apellido1, apellido2, sexo, ciudad, estado, curp, direccion, usuario, contrasena);
        if (!Sistema.usuarios.containsKey(Gente.EJECUTIVO)){
            Sistema.usuarios.put(Gente.EJECUTIVO, new ArrayList<>());
        }
        //Sistema.usuarios.get(Gente.EJECUTIVO).add(ejecutivo);
        System.out.println("Ejecutivo registrado");
    }
}
