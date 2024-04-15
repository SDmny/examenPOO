package Menu;

import Productos.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Cliente {
    Scanner leer = new Scanner(System.in);
    ArrayList<Producto> comprado = new ArrayList<>();
    ArrayList<Integer> cantidad = new ArrayList<>();
    ArrayList<LocalDate> fecha = new ArrayList<>();
    String nombre;
    LocalDate fechaActual;
    int edad, id;

    public Cliente(String nombre, int edad) {
        this.edad = edad;
        this.nombre = nombre;
        id = 0;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void registrarProducto(Producto producto, int cantidad) {
        this.fechaActual = LocalDate.now();
        fecha.add(fechaActual);
        comprado.add(producto);
        this.cantidad.add(cantidad);
    }

    public void mostrarProductos() {
        int i = 0;
        LocalDate fechaAnterior = LocalDate.of(1996, 1, 1);
        for (Producto producto : comprado) {
            if (!fechaAnterior.isEqual(fecha.get(i))) {
                System.out.println("\nFecha de compra(s): " + fecha.get(i) + "\n");
            }
            fechaAnterior = fecha.get(i);
            System.out.println("Nombre: " + producto.getName());
            System.out.println("id: " + producto.getId());
            System.out.println("Número de serie: " + producto.getNo());
            System.out.println("Fecha de importación: " + producto.getFechaImportacion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Clase: " + producto.getClass());
            System.out.println("Cantidad comprada: " + this.cantidad.get(i));
            System.out.println("Precio total: " + (producto.getPrecio() * cantidad.get(i)));
            i++;
        }
    }



    @Override
    public String toString() {
        return " Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                ", Id=" + id +
                '}';
    }
}
