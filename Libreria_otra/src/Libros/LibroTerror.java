
package Libros;

import Libros.constants.Genero;
import Libros.constants.SubgeneroTerror;
import biblioteca.Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroTerror extends Libro {
    private SubgeneroTerror subgenero;

    public LibroTerror(String nombre, String autor, String editorial, LocalDate fechaDePublicacion, double precio, int stock, SubgeneroTerror subgenero) {
        super(nombre, autor, editorial, fechaDePublicacion, Genero.TERROR, precio, stock);
        this.subgenero = subgenero;
    }

    public static void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = LibrosUtils.obtenerLibrosDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        System.out.println("Ingresa el subgenero del libro");
        System.out.println("Selecciona una opción");
        System.out.println("1. Psicológico");
        System.out.println("2. Crímen");

        int opcionSubgenero = 0;
        SubgeneroTerror subgeneroInput = null;
        boolean incorrecto = true;
        while (incorrecto) {
            try {
                incorrecto = false;
                opcionSubgenero = Biblioteca.scanner.nextInt();
                scanner.nextLine();
                if(opcionSubgenero<1||opcionSubgenero>2){
                    throw new Exception();
                }
            } catch (Exception ew) {
                incorrecto=true;
                System.out.println("Esa opción no se encuentra, pruebe de nuevo");
                scanner.next();
            }
        }

        if (opcionSubgenero == 1) {
            subgeneroInput = SubgeneroTerror.PSICOLOGICO;
        } else {
            subgeneroInput = SubgeneroTerror.CRIMEN;
        }

        LibroTerror libroTerror = new LibroTerror(nombre, autor, editorial, fechaPublicacion, precio, stock, subgeneroInput);
        if (Biblioteca.libros.containsKey(Genero.TERROR)) {
            Biblioteca.libros.put(Genero.TERROR, new ArrayList<>());
        }
        Biblioteca.libros.get(Genero.TERROR).add(libroTerror);
    }
    public static void eliminarLibro(String nombre,String autor){
        for(Libro libro:Biblioteca.libros.get(Genero.TERROR)){
            if(libro.getNombre().equals(nombre)&&libro.getAutor().equals(autor)){
                Biblioteca.libros.get(Genero.TERROR).remove(libro);
                System.out.println("El libro ha sido eliminado");
            }
        }

    }
}

