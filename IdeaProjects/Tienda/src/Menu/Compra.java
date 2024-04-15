package Menu;

import Productos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Compra {
    Scanner leer = new Scanner(System.in);
    ArrayList<Producto> productos = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    private int cantidadP, cantidadC;
    //Esta cantidad sigue contando a los clientes que han sido eliminados, pues solo sirve para no repetir el id


    public double comprar(int idC, int idP, int cantidad) {
        boolean cPudo;
        double precio = 0;
        for (Producto producto : productos) {
            if (idP == producto.getId()) {
                cPudo = producto.reducirStock(cantidad);
                if (cPudo) {
                    precio = producto.getPrecio() * cantidad;
                    for (Cliente cliente : clientes) {
                        if (idC == cliente.getId()) {
                            cliente.registrarProducto(producto, cantidad);
                        }
                    }
                }

            }
        }
        return precio;

    }


    public void addProducto(Producto producto) {
        producto.setId(cantidadP);
        productos.add(producto);
        cantidadP++;

    }
    public void aumentarStock(int id,int cantidad){
        for (Producto producto:productos){
            if(id==producto.getId()){
                producto.aumentarStock(cantidad);
            }

        }
    }

    public void modificarProducto(int id) {
        String name;
        double precio;
        int stock;
        int no;
        LocalDate fechaImportacion;
        String tipo;
        int opcion = 0;
        while (opcion != 8) {
            for (Producto producto : productos) {
                if (id == producto.getId()) {
                    System.out.println("Ingrese la opción a modificar: ");
                    System.out.println("1 Nombre");
                    System.out.println("2 Tipo");
                    System.out.println("3 Precio");
                    System.out.println("4 Stock");
                    System.out.println("5 Fecha de importación");
                    System.out.println("6 Número de serie");
                    System.out.println("7 Otros");
                    System.out.println("8 Salir de la modificación");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese nuevo valor: ");
                            name = leer.nextLine();
                            producto.setName(name);
                            break;
                        case 2:
                            System.out.println("Ingrese nuevo valor: ");
                            tipo = leer.nextLine();
                            producto.setTipo(tipo);
                            break;
                        case 3:
                            System.out.println("Ingrese nuevo valor: ");
                            precio = leer.nextDouble();

                            leer.nextLine();
                            producto.setPrecio(precio);
                            break;
                        case 4:
                            System.out.println("Ingrese nuevo valor: ");
                            stock = leer.nextInt();

                            leer.nextLine();
                            producto.setStock(stock);
                            break;
                        case 5:
                            fechaImportacion = asignarFecha();
                            producto.setFechaImportacion(fechaImportacion);

                            break;
                        case 6:
                            System.out.println("Ingrese nuevo valor: ");
                            no = leer.nextInt();

                            leer.nextLine();
                            producto.setNo(no);
                            break;
                        case 7:
                            if (producto instanceof Alimento) {
                                String caracter;
                                System.out.println("Cambiar fecha de caducidad: ingresar carácter, sí no lo desea ingrese 0");
                                caracter = leer.nextLine();
                                if (!caracter.equals("0")) {
                                    LocalDate caducidad = asignarFecha();
                                    producto.setFechaImportacion(caducidad);
                                }
                            }
                            if (producto instanceof Limpieza) {
                                int op = 0;
                                while (op != 3) {
                                    System.out.println("Ingrese la opción a modificar: ");
                                    System.out.println("1 Aroma");
                                    System.out.println("2 Recomendado por expertos");
                                    System.out.println("3 Salir");
                                    op = leer.nextInt();

                                    leer.nextLine();
                                    switch (op) {
                                        case 1:
                                            System.out.println("Ingresar nuevo aroma: ");
                                            String aroma = leer.nextLine();
                                            break;
                                        case 2:
                                            System.out.println("¿El producto es recomendado por al menos 8 de cada 10 expertos?: ");
                                            System.out.println("Digite 0 sí la respuesta es NO, digite otro carácte sí la respuesta es si");
                                            String caracter = leer.nextLine();
                                            if (!caracter.equals("0")) {
                                                ((Limpieza) producto).setRecomend(true);
                                            } else {
                                                ((Limpieza) producto).setRecomend(false);
                                            }
                                            break;
                                        default:
                                            System.out.println("Esa opción no se encuentra");
                                            break;
                                    }
                                }

                            }
                            if (producto instanceof Electrodomestico) {

                                int op = 0;
                                while (op != 3) {
                                    System.out.println("Ingrese la opción a modificar: ");
                                    System.out.println("1 Color");
                                    System.out.println("2 Watts");
                                    System.out.println("3 Descripción del producto");
                                    System.out.println("4 Salir");
                                    op = leer.nextInt();

                                    leer.nextLine();
                                    switch (op) {
                                        case 1:
                                            System.out.println("Ingresar nuevo color: ");
                                            String color = leer.nextLine();
                                            ((Electrodomestico) (producto)).setColor(color);
                                            break;
                                        case 2:
                                            System.out.println("Ingresar watts: ");
                                            double watts = leer.nextDouble();
                                            ((Electrodomestico) (producto)).setWatts(watts);

                                            break;
                                        case 3:
                                            System.out.println("Ingresar descripción: ");
                                            String descripcion = leer.nextLine();
                                            ((Electrodomestico) (producto)).setDescripcion(descripcion);

                                            break;
                                        default:
                                            System.out.println("Esa opción no se encuentra");
                                            break;
                                    }
                                }

                            }
                            if (producto instanceof Belleza) {
                                int op = 0;
                                while (op != 3) {
                                    System.out.println("Ingrese la opción a modificar: ");
                                    System.out.println("1 Color");
                                    System.out.println("2 Duración diaria");
                                    System.out.println("3 Salir");
                                    op = leer.nextInt();

                                    leer.nextLine();
                                    switch (op) {
                                        case 1:
                                            System.out.println("Ingresar nuevo color: ");
                                            String color = leer.nextLine();
                                            ((Belleza) producto).setColor(color);
                                            break;
                                        case 2:
                                            System.out.println("Ingresar duración diaria en horas enteras");
                                            int duracion = leer.nextInt();
                                            leer.nextLine();
                                            ((Belleza) producto).setDuracionDiaria(duracion);
                                            break;
                                        default:
                                            System.out.println("Esa opción no se encuentra");
                                            break;
                                    }
                                }

                            }
                            break;
                        case 8:
                            System.out.println("Usted ha salido de modificar");
                            break;
                        default:
                            System.out.println("Esa opción no se encuentra");
                            break;


                    }
                }
            }

        }
    }

    public LocalDate asignarFecha() {
        int dia = 43, mes = 1, ano = 2024;
        LocalDate fecha;
        while ((dia > 32 || dia < 0) || (mes < 0 || mes > 12) || (ano < 2023)) {
            System.out.println("Ingrese día: ");
            dia = leer.nextInt();

            leer.nextLine();
            System.out.println("Ingrese mes: ");
            mes = leer.nextInt();

            leer.nextLine();
            System.out.println("Ingrese año: ");
            ano = leer.nextInt();

            leer.nextLine();

        }
        fecha = LocalDate.of(ano, mes, dia);
        return fecha;
    }

    public void mostrarProductos() {
        int i = 0;
        while (i < 4) {
            if (i == 0) {
                System.out.println("Alimentos: ");
            }
            if (i == 1) {
                System.out.println("Limpieza: ");
            }
            if (i == 2) {
                System.out.println("Electrodomesticos: ");
            }
            if (i == 3) {
                System.out.println("Belleza: ");
            }

            for (Producto producto : productos) {

                if (producto instanceof Alimento && i == 0) {
                    System.out.println(producto.getName() + " " + producto.getTipo() + " " + producto.getId() + " " + producto.getStock());
                }
                if (producto instanceof Limpieza && i == 1) {
                    System.out.println(producto.getName() + " " + producto.getTipo() + " " + producto.getId() + " " + producto.getStock());
                }
                if (producto instanceof Electrodomestico && i == 2) {
                    System.out.println(producto.getName() + " " + producto.getTipo() + " " + producto.getId() + " " + producto.getStock());
                }
                if (producto instanceof Belleza && i == 3) {
                    System.out.println(producto.getName() + " " + producto.getTipo() + " " + producto.getId() + " " + producto.getStock());
                }
            }

            i++;
        }
    }


    public void mostrarProducto(int id) {
        for (Producto producto : productos) {
            if (id == producto.getId()) {
                System.out.println("Producto: " + (producto).toString());
            }
        }

    }

    public void eliminarProducto(int id) {
        for (Producto producto : productos) {
            if (id == producto.getId()) {
                productos.remove(producto);
            }
        }
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
        cliente.setId(cantidadC);
        cantidadC++;

    }

    public void modificarCliente(int id) {
        String nombre;
        int edad;
        int opcion = 0;
        while (opcion != 3) {
            for (Cliente cliente : clientes) {
                if (id == cliente.getId()) {
                    System.out.println("Ingrese la opción a modificar: ");
                    System.out.println("1 Nombre");
                    System.out.println("2 Edad");
                    System.out.println("3 Salir");
                    opcion = leer.nextInt();
                    leer.nextLine();
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nombre: ");
                            nombre=leer.nextLine();
                            cliente.setNombre(nombre);
                            break;
                        case 2:
                            System.out.println("Ingrese la edad: ");
                            edad=leer.nextInt();
                            leer.nextLine();
                            cliente.setEdad(edad);
                            break;
                        case 3:
                            System.out.println("Saliendo del menú");
                            break;
                        default:
                            System.out.println("Esa opción no se encuentra");
                            break;
                    }
                }
            }
        }
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }

    }

    public void mostrarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (id == cliente.getId()) {
                System.out.println(cliente.toString());
            }
        }

    }

    public void eliminarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (id == cliente.getId()) {
                clientes.remove(cliente);
            }
        }


    }
}
