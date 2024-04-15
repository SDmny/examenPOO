package Menu;

import Productos.Alimento;
import Productos.Belleza;
import Productos.Electrodomestico;
import Productos.Limpieza;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Sistema {
    Scanner leer = new Scanner(System.in);
    Compra compra = new Compra();
    int idC, idP;

    public Sistema() {
        String salir = " ";
        while (!salir.equals("0")) {
            System.out.println("Ingrese un caracter para continuar,0 para salir: ");
            salir = leer.nextLine();
            if (!Objects.equals(salir, "0")) {
               if( password()){
                   Menu();
                }

            }
        }

    }

    public boolean password() {
        String word = "TROYANO", password = "";

        while (!word.equals(password)&&!password.equals("0")) {
            System.out.println("Ingrese la contraseña, o ingrese 0 para salir: ");
            password = leer.nextLine();
            if (password.equals(word)) {
                System.out.println("La contraseña es correcta");
                System.out.println("Ingresando......");

            } else {
                if (password.equals("0")) {
                    System.out.println("Usted ha salido del menú");
                }
                System.out.println("La contraseña es incorrecta");
            }
        }
        if(password.equals("0")){
            return false;
        }
        else {
            return true;
        }
    }

    public void Menu() {

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\t----Bienvenido al menú----");
            System.out.println("\tSeleccione una opción para continuar: ");
            System.out.println("\t1 Menu de Tienda");
            System.out.println("\t2 Menu de Clientes");
            System.out.println("\t3 Menu de Productos");
            System.out.println("\t4 Cambiar contraseña");
            System.out.println("\t5 Salir");

            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    MenuTienda();
                    break;
                case 2:
                    if(password()){
                        MenuCliente();
                    }
                    break;
                case 3:if (password()){

                    MenuProducto();
                }
                    break;
                case 4:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Esa opción no se encuentra");
                    break;
            }
        }

    }

    public void MenuTienda() {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("\t----Bienvenido a la Tienda----");
            System.out.println("\tSeleccione una opción para continuar: ");
            System.out.println("\t1 Comprar producto");
            System.out.println("\t2 Mostrar todos los productos");
            System.out.println("\t3 Salir");
            opcion = leer.nextInt();

            leer.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese id del Cliente:");
                    idC = leer.nextInt();
                    System.out.println("Ingrese cantidad de tipos de productos a comprar: ");
                    int i = leer.nextInt();
                    leer.nextLine();
                    for (int j = 0; j < i; j++) {
                        System.out.println("Ingrese id del producto:");
                        idP = leer.nextInt();
                        leer.nextLine();
                        System.out.println("Ingrese cantidad a comprar de éste producto: ");
                        int c = leer.nextInt();
                        leer.nextLine();
                        compra.comprar(idC, idP, c);
                    }


                    break;
                case 2:
                    compra.mostrarProductos();
                    break;
                case 3:
                    System.out.println("Usted está saliendo de la tienda");
                    break;
                default:
                    System.out.println("Esa opción no se encuentra");
                    break;
            }
        }

    }

    public void MenuCliente() {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\t----Bienvenido al menú----");
            System.out.println("\tSeleccione una opción para continuar: ");
            System.out.println("\t1 Registrar cliente(s)");
            System.out.println("\t2 Eliminar cliente");
            System.out.println("\t3 Modificar cliente");
            System.out.println("\t4 Mostrar a todos los clientes");
            System.out.println("\t 5 Mostrar a un cliente");
            System.out.println("\t6 Salir");
            opcion = leer.nextInt();

            leer.nextLine();
            switch (opcion) {
                case 1:
                    String nombre;
                    int edad;

                    System.out.println("Ingrese el nombre: ");
                    nombre = leer.nextLine();
                    System.out.println("Ingrese la edad: ");
                    edad = leer.nextInt();
                    leer.nextLine();
                    Cliente cliente = new Cliente(nombre, edad);
                    compra.addCliente(cliente);
                    break;
                case 2:
                    System.out.println("Ingrese el id del cliente");
                    idC = leer.nextInt();
                    leer.nextLine();
                    compra.eliminarCliente(idC);
                    break;
                case 3:
                    System.out.println("Ingrese el id del cliente");
                    idC = leer.nextInt();
                    leer.nextLine();
                    compra.modificarCliente(idC);
                    break;
                case 4:
                    compra.mostrarClientes();
                    break;
                case 5:
                    System.out.println("Ingrese el id del cliente");
                    idC = leer.nextInt();
                    leer.nextLine();
                    compra.mostrarCliente(idC);
                    break;
                default:
                    System.out.println("Esa opción no se encuentra");
                    break;
            }
        }
    }

    public void MenuProducto() {
        String name, tipo;
        double precio;
        int stock, no;
        LocalDate fechaImportacion;
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\t----Bienvenido al Menú de producto----");
            System.out.println("\tSeleccione una opción para continuar: ");
            System.out.println("\t1 Registrar producto");
            System.out.println("\t2 Eliminar producto");
            System.out.println("\t3 Modificar producto");
            System.out.println("\t4 Mostrar todos los productos");
            System.out.println("\t5 Aumentar stock del producto");
            System.out.println("\t6 Salir");
            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese  nombre: ");
                    name = leer.nextLine();

                    System.out.println("Ingrese tipo: ");
                    tipo = leer.nextLine();

                    System.out.println("Ingrese precio: ");
                    precio = leer.nextDouble();

                    leer.nextLine();

                    System.out.println("Ingrese stock: ");
                    stock = leer.nextInt();

                    leer.nextLine();

                    System.out.println("Ingresando fecha de importación: ");
                    fechaImportacion = compra.asignarFecha();


                    System.out.println("Ingrese número de serie: ");
                    no = leer.nextInt();

                    leer.nextLine();

                    System.out.println("Elija el tipo de producto");
                    System.out.println("1 Alimento");
                    System.out.println("2 Limpieza");
                    System.out.println("3 Electrodomestico");
                    System.out.println("4 Belleza");
                    opcion=leer.nextInt();

                    leer.nextLine();
                    switch (opcion) {
                        case 1:
                            System.out.println("Escriba fecha de caducidad");
                            LocalDate caducidad = compra.asignarFecha();
                            Alimento alimento = new Alimento(name, precio, stock, no, fechaImportacion, tipo, caducidad);
                            compra.addProducto(alimento);
                            break;
                        case 2:
                            boolean reco = true;
                            System.out.println("Ingresar aroma: ");
                            String aroma = leer.nextLine();

                            System.out.println("¿El producto es recomendado por al menos 8 de cada 10 expertos?: ");
                            System.out.println("Digite 0 sí la respuesta es NO, digite otro carácte sí la respuesta es si");
                            String caracter = leer.nextLine();
                            if (!caracter.equals("0")) {
                                reco = false;
                            } else {
                                reco = true;
                            }

                            Limpieza limpieza = new Limpieza(name, precio, stock, no, fechaImportacion, tipo, aroma, reco);
                            compra.addProducto(limpieza);
                            break;
                        case 3:
                            System.out.println("Ingresar color: ");
                            String color = leer.nextLine();

                            System.out.println("Ingresar watts: ");
                            double watts = leer.nextDouble();
                            leer.nextLine();

                            System.out.println("Ingresar descripción: ");
                            String descripcion = leer.nextLine();
                            Electrodomestico electrodomestico = new Electrodomestico(name, precio, stock, no, fechaImportacion, tipo, watts, descripcion, color);
                            compra.addProducto(electrodomestico);
                            break;
                        case 4:
                            System.out.println("Ingresar color: ");

                            color = leer.nextLine();

                            System.out.println("Ingresar duración diaria en horas enteras");
                            int duracion = leer.nextInt();
                            leer.nextLine();
                            Belleza belleza = new Belleza(name, precio, stock, no, fechaImportacion, tipo, duracion, color);
                            compra.addProducto(belleza);
                            break;
                        default:
                            System.out.println("Esa opción no se encuentrra, el producto no se pudo registrar");

                    }
                    break;
                case 2:
                    System.out.println("Ingrese id: ");
                    idP = leer.nextInt();
                    leer.nextLine();
                    compra.eliminarProducto(idP);
                    break;
                case 3:
                    System.out.println("Ingrese id: ");
                    idP = leer.nextInt();
                    leer.nextLine();
                    compra.modificarProducto(idP);

                    break;
                case 4:
                    compra.mostrarProductos();
                    break;
                case 5:
                    System.out.println("Ingrese cantidad de stock: ");
                    int cantidad=leer.nextInt();
                    leer.nextLine();
                    System.out.println("Ingrese id del producto: ");
                    idP=leer.nextInt();
                    leer.nextLine();
                    compra.aumentarStock(idP,cantidad);
                    break;
                case 6:
                    System.out.println("Saliendo del menú");
                    break;

                default:
                    System.out.println("Esa opción no se encuentra");
                    break;
            }
        }

    }

}
