package Tarjetas.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Generar {
    private static ArrayList<String> tarjetas = new ArrayList<>();
    
    public static String generarTarjeta(int clave) {
        boolean flag = true;
        Random r = new Random();
        String numeroTarjeta;
        do{
            String campo1 = Integer.toString(clave);
            String campo2 = String.format("%04d",r.nextInt(10000));
            String campo3 = String.format("%04d",r.nextInt(10000));
            String campo4 = String.format("%04d",r.nextInt(10000));
            numeroTarjeta = campo1 + " " + campo2 + " " + campo3 + " " + campo4;
            if (!tarjetas.contains(numeroTarjeta)) {
                tarjetas.add(numeroTarjeta);
                flag = false;
            }
        }while(flag);
        return numeroTarjeta;
    }

    public static String generarRFC(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("YYMMdd"); 
        String fechaNacimientoS = formatoFecha.format(fechaNacimiento);
        Random r = new Random(); 
        int numero1 = r.nextInt(65,91); 
        char caracter1 = (char) numero1; 
        String letra1 = Character.toString(caracter1); 
        int numero2 = r.nextInt(65,91);
        char caracter2 = (char) numero2;
        String letra2 = Character.toString(caracter2);
        int caracter3 = r.nextInt(10);
        String letra3 = Integer.toString(caracter3); 
        String cadena = "" + apellidoPaterno.charAt(0) + apellidoPaterno.charAt(1) + apellidoMaterno.charAt(0) + nombre.charAt(0) + fechaNacimientoS + letra1 + letra2 + letra3;//Concatenando los valores de todas las variables para crear una sola cadena String.
        String rfc = cadena.toUpperCase();
        return rfc;
    }

    public static String generarCURP(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, char sexo, String estado) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("YYMMdd");
        Random r = new Random();
        String fechaNacimientoS = formatoFecha.format(fechaNacimiento);
        int letra = estado.length() - 1; 
        int numero1 = r.nextInt(10);
        int numero2 = r.nextInt(10);
        String digito1 = Integer.toString(numero1);
        String digito2 = Integer.toString(numero2);
        String cadena = "" + apellidoPaterno.charAt(0) + apellidoPaterno.charAt(1) + apellidoMaterno.charAt(0) + nombre.charAt(0) + fechaNacimientoS + sexo + estado.charAt(0) + estado.charAt(letra) + apellidoPaterno.charAt(2) + apellidoMaterno.charAt(2) + nombre.charAt(2) + digito1 + digito2;
        String curp = cadena.toUpperCase();
        return curp;
    }
}