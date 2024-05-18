package Libros;

import Libros.constants.Genero;
import Libros.constants.SubgeneroAccion;
import biblioteca.Biblioteca;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroAccion extends Libro {
    private SubgeneroAccion subgenero;
    public LibroAccion(String nombre, String autor, String editorial, LocalDate fechaDePublicacion, double precio, int stock, SubgeneroAccion subgenero) {
        super(nombre, autor, editorial, fechaDePublicacion, Genero.ACCION, precio, stock);
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
        System.out.println("1. Ciencia Ficción");
        System.out.println("2. Polocíaco");

        int opcionSubgenero = 0;
        SubgeneroAccion subgeneroInput = null;
        boolean incorrecto=true;
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
            subgeneroInput = SubgeneroAccion.CIENCIAFICCION;
        } else {
            subgeneroInput = SubgeneroAccion.POLICIACO;
        }

        LibroAccion libroAccion = new LibroAccion(nombre, autor, editorial, fechaPublicacion, precio, stock, subgeneroInput);
        if (!Biblioteca.libros.containsKey(Genero.ACCION)) {
            Biblioteca.libros.put(Genero.ACCION, new ArrayList<Libro>());
        }
        Biblioteca.libros.get(Genero.ACCION).add(libroAccion);
    }

    public static void eliminarLibro(String nombre,String autor){
        for(Libro libro:Biblioteca.libros.get(Genero.ACCION)){
            if(libro.getNombre().equals(nombre)&&libro.getAutor().equals(autor)){
                Biblioteca.libros.get(Genero.ACCION).remove(libro);
                System.out.println("El libro ha sido eliminado");
            }
        }

    }

}
