package biblioteca;

import usuarios.utils.Rol;
import usuarios.utils.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class DatosComun {
    public static ArrayList<String> obtenerDatos(Rol rol) {

         ArrayList<String> Datos = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        String CurrentRole = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.TRABAJADOR ? "Trabajador" : "Gerente";

        System.out.println("\nRegistrar usuarios." + CurrentRole);

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido: ");
        String apellido = scanner.nextLine();
        System.out.println("Ingresa el telefono: ");
        String telefono = getPhone();
        System.out.println("Ingresa el nombre de usuario: ");
        String nombreUsuario = getUsername();

        System.out.println("Ingresa la contrasena: ");
        String contrasena = scanner.nextLine();

        Datos.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contrasena));
        return Datos;
    }

    private static String getPhone() {
        Scanner scan = new Scanner(System.in);
        boolean existe = true;
        String telefono = "";

        do {
            System.out.println("Ingresar: ");
            telefono = scan.nextLine();

            existe = false;
            if (telefono.length() == 10) {
                for (Map.Entry<Rol, ArrayList<Usuario>> entry : Biblioteca.usuarios.entrySet())//regresa las llaves y los valores
                {
                    for (Usuario usuario : entry.getValue()) {
                        if (usuario.getNumeroTelefono().equals(telefono)) {
                            existe = true;
                            break;
                        }
                    }
                }

                if (existe) {
                    System.out.println("Número en uso, volver a ingresar.");

                }
            } else {
                System.out.println("El número se ha registrado");

            }


        } while (existe);

        return telefono;
    }

    private static String getUsername() {
        Scanner scan = new Scanner(System.in);
        boolean existe;
        String username = "";

        do {
            System.out.println("Ingresar: ");
            username = scan.nextLine();

            existe = false;
            for (Map.Entry<Rol, ArrayList<Usuario>> entry : Biblioteca.usuarios.entrySet()) {
                for (Usuario user : entry.getValue()) {
                    if (user.getNombreUsuario().equals(username)) {
                        existe = true;
                        break;
                    }
                }
            }

            if (existe) {
                System.out.println("El nombre de usuario ya está en uso");
            }
        } while (existe);

        return username;
    }

    public static String ModificarUnDato(){
        String dato = " ";
        int opcion ;
        System.out.println("Ingrese la opción a modificar: ");
        System.out.println("0 Para dejar de modificar");
        System.out.println("1 Nombre: ");
        System.out.println("2 Apellido: ");
        System.out.println("3 Fecha de Nacimiento: ");
        System.out.println("4 Contraseña: ");
        System.out.println("5 Nombre de Usuario: ");
        System.out.println("6 Número de telefono: ");
        System.out.println("7 Otro dato");
        opcion=Biblioteca.scanner.nextInt();
        Biblioteca.scanner.nextLine();
        if(0<=opcion&&opcion<5&&opcion!=3){
            System.out.println("Ingrese el dato: ");
            dato=Biblioteca.scanner.nextLine();
            dato=dato+opcion;
        }

        switch (opcion){
            case 3:
                dato= " 3";
                break;
            case 5:
                dato=getUsername()+'5';
                break;
            case 6:
                dato=getPhone()+'6';
                break;
            case 7:
                dato= " 7";
                break;
            default:
                System.out.println("Esa opción no se encuentra");
                break;
        }

        return dato;



    }

    public static LocalDate asignarFecha() {
        Scanner scanner = new Scanner(System.in);
        int dia = 43, mes = 1, ano = 2024;
        LocalDate fecha;
        while ((dia > 32 || dia < 0) || (mes < 0 || mes > 12) || (ano < 1900)) {
            System.out.println("Ingrese día: ");
            dia = scanner.nextInt();

            scanner.nextLine();
            System.out.println("Ingrese mes: ");
            mes = scanner.nextInt();

            scanner.nextLine();
            System.out.println("Ingrese año: ");
            ano = scanner.nextInt();

            scanner.nextLine();

        }
        fecha = LocalDate.of(ano, mes, dia);
        return fecha;
    }

}
