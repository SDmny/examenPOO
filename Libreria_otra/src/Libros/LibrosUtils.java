package Libros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrosUtils {
    public static ArrayList<String> obtenerLibrosDatosComun() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();

        System.out.println("Ingresa el nombre del libro: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el autor libro: ");
        String autor = scanner.nextLine();

        System.out.println("Ingresa el editorial del libro: ");
        String editorial = scanner.nextLine();

        System.out.println("Ingresa el día de publicación del libro: ");
        int diaPublicacion = scanner.nextInt();

        System.out.println("Ingresa el mes de publicación del libro: ");
        int mesPublicacion = scanner.nextInt();

        System.out.println("Ingresa el año de publicación del libro: ");
        int añoPublicacion = scanner.nextInt();

        LocalDate fechaPublicacion = LocalDate.of(añoPublicacion, mesPublicacion, diaPublicacion);

        System.out.println("Ingresa el precio del libro: ");
        double precio = scanner.nextDouble();

        System.out.println("Ingresa el stock del libro: ");
        int stock = scanner.nextInt();

        datosComun.addAll(Arrays.asList(nombre, autor, editorial, String.valueOf(fechaPublicacion), String.valueOf(precio), String.valueOf(stock)));
        return datosComun;
    }
}