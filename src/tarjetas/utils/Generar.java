package tarjetas.utils;

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


}