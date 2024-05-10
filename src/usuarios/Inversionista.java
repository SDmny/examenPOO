package usuarios;

import sistema.Sistema;
import usuarios.utils.Gente;
import usuarios.utils.Sucursal;
import utils.Fondos;

import java.time.LocalDate;
import java.util.Scanner;

public class Inversionista extends Usuario{
    public Inversionista(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curb, String direccion, Sucursal sucursal, String usuario, String contrasena, LocalDate birth) {
        super(nombre, apellido1, apellido2, sexo, ciudad, estado, curb, direccion, sucursal, Gente.INVERSIONISTA, usuario, contrasena,birth);
    }

    @Override
    public String toString(){
        return String.format("%s", super.toString());
    }

    // invertir
    public static void invertir(String nombre, String apellido){
        Scanner scanner = new Scanner(System.in);
        double inversion=0;
        boolean incorrecto=true;
        while (incorrecto) {
            try {
                incorrecto = false;
                System.out.println("Cantidad a invertir: ");
                inversion = scanner.nextDouble();
            } catch (Exception ew) {
                incorrecto = true;
                System.out.println("Hubo un error al ingresar los datos");
            }
        }
        Fondos fondo = new Fondos(nombre, apellido, inversion);
        Sistema.fondos.add(fondo);
    }
}
