package usuarios.utils;

import sistema.Sistema;
import usuarios.Usuario;
import usuarios.utils.Gente;
import usuarios.utils.Sucursal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DatosComun {
    //SCANNER ESTATICO
    public static Scanner scanner = new Scanner(System.in);

    //METODO PARA OBTENER DATOS INCOMPLETO
    public static ArrayList obtenerDatos() {
        ArrayList<String> datosComun = new ArrayList<String>();
        String nombre = "", apellido1 = "", apellido2 = "", ciudad="", estado = "", curp = "", direccion, homoclave, usuario, contrasena;
        char sexo = ' ';
        Sucursal sucursal;
        Gente rol;
        boolean incorrecto = true;
        LocalDate birth = LocalDate.now();
        while (incorrecto) {
            try {
                incorrecto = false;
                System.out.print("Ingrese nombre: ");
                nombre = scanner.next();
                System.out.print("Ingrese primer apellido: ");
                apellido1 = scanner.next();
                System.out.print("Ingrese segundo apellido: ");
                apellido2 = scanner.next();
                System.out.print("Ingrese ciudad: ");
                ciudad = scanner.next();
                System.out.print("Ingrese estado: ");
                estado = scanner.next();
               if(nombre.length()<2||apellido1.length()<2||apellido2.length()<2||estado.length()<2){
                   throw  new Exception();
               }

            }
            catch (Exception ew){
                incorrecto=true;
                System.out.println("Los datos deben al menos dos letras");
            }
        }
        incorrecto=true;
        System.out.print("Ingrese dirección: ");
        direccion = scanner.next();
        System.out.print("Ingrese contraseña: ");
        contrasena = scanner.next();
        usuario = obtenerNombreUsuario();
        while (incorrecto) {
            try {
                incorrecto = false;
                System.out.print("Ingrese sexo (M - Masculino / F - Femenino): ");
                sexo = (scanner.next()).charAt(0);
            } catch (Exception ew) {
                incorrecto = true;
                System.out.println("Hubo un error al ingresar los datos");
                scanner.next();
            }
        }
        incorrecto = true;
        while (incorrecto) {
            try {
                incorrecto = false;
                birth = asignarFecha();
            } catch (Exception ew) {
                incorrecto = true;
                System.out.println("Hubo un error al ingresar los datos");
            }
        }
        incorrecto = true;
        try {
            incorrecto=false;
            curp = generarCURP(nombre, apellido1, apellido2, birth, sexo, estado);
        } catch (Exception ew) {
            incorrecto = true;
            System.out.println("SI SALE ESTE MENSAJE: ERROR EN CURP SOS!!!!");
        }
        datosComun.addAll(Arrays.asList(nombre, apellido1, apellido2, String.valueOf(sexo), ciudad, estado, curp, direccion, usuario, contrasena, String.valueOf(birth)));
        return datosComun;
    }

    public static String ModificarDatoUsuario() {
        int op = 0;
        boolean incorrecto=true;
        String dato = null;
        System.out.println("Ingreser la opción a modificar: ");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido Paterno");
        System.out.println("3. Apellido Materno");
        System.out.println("4. Sexo");
        System.out.println("5. Ciudad");
        System.out.println("6. Estado");
        System.out.println("7. Direccion");
        System.out.println("8. Usuario");
        System.out.println("9. Contraseña");
        System.out.println("10. Fecha de Nacimiento");
        System.out.println("11 No modificar");
        while (incorrecto) {
            try {
                incorrecto = false;
                op = scanner.nextInt();
                scanner.nextLine();
                if (op < 1 || op > 11) {
                    throw new Exception();
                }
            } catch (Exception ew) {
                incorrecto = true;
                System.out.println("La opción no es válida, intente de nuevo");
                scanner.next();
            }
        }
        incorrecto = true;
        while (incorrecto) {
            switch (op) {
                case 4:
                    try {
                        incorrecto = false;
                        System.out.println("Ingrese el nuevo valor(F/M): ");
                        dato = scanner.nextLine();
                        dato = dato.toUpperCase();
                        if (dato.charAt(0) == 'F' || dato.charAt(0) == 'M') {
                            dato = dato + op;
                        } else {
                            System.out.println("Esa no es una opción");
                            throw new Exception();
                        }
                    } catch (Exception ew) {
                        incorrecto = true;
                        System.out.println("El valor no pudo ser ingresado");
                        scanner.next();
                    }
                    break;
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    try {
                        incorrecto = false;
                        System.out.println("Ingrese el nuevo valor: ");
                        dato = scanner.nextLine();
                        if (dato.length() < 2) {
                            System.out.println("Debe tener más de dos letras");
                            throw new Exception();
                        }
                        dato = dato + op;
                    } catch (Exception ew) {
                        incorrecto = true;
                        System.out.println("El valor no pudo ser ingresado, pruebe de nuevo");
                        scanner.next();
                    }
                    break;
                case 10:
                    incorrecto = false;
                    LocalDate birth = asignarFecha();
                    dato = String.valueOf(birth);
                    dato = dato + op;
                    break;
                case 11:
                    System.out.println("No se modificó ningún dato");
                    dato = "0";
                    break;
            }
        }
        return dato;
    }

    //METODO PARA EVITAR REPETIR RFC
    //Es prácticamente imposible que se repita, pero weno
    public static boolean rfcRepetida(String rfc, String homo) {
        boolean repetida = false;
        if (!Sistema.usuarios.isEmpty()) {
            for (Map.Entry<Gente, ArrayList<Usuario>> entry : Sistema.usuarios.entrySet()) {
                for (Usuario usuario : entry.getValue()) {
                    if (usuario.getRfc().equals(rfc)) {
                        if (usuario.getHomoclave().equals(homo)) {
                            repetida = true;
                        }
                    }
                }
            }
        }
        return repetida;
    }

    // VERIFICAR SI ESTE METODO ES MEJOR O PEOR QUE EL DEL USUARIO GENERAR HOMOCLAVE-RFC Y DEJAR AL MEJOR
    public static String generarRFC(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyMMdd");
        String fechaNacimientoS = formatoFecha.format(fechaNacimiento);
        Random r = new Random();
        int numero1 = r.nextInt(26) + 65;
        char caracter1 = (char) numero1;
        String letra1 = Character.toString(caracter1);
        int numero2 = r.nextInt(26) + 65;
        char caracter2 = (char) numero2;
        String letra2 = Character.toString(caracter2);
        int caracter3 = r.nextInt(10);
        String letra3 = Integer.toString(caracter3);
        String cadena = "" + apellidoPaterno.charAt(0) + apellidoPaterno.charAt(1) + apellidoMaterno.charAt(0) + nombre.charAt(0) + fechaNacimientoS + letra1 + letra2 + letra3;//Concatenando los valores de todas las variables para crear una sola cadena String.
        String rfc = cadena.toUpperCase();
        return rfc;
    }

    public static String generarCURP(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, char sexo, String estado) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyMMdd");
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

    // metodo para nombre de usuario
    private static String obtenerNombreUsuario() {
        boolean nombreUsExis = true;
        String nombUsu = "";
        do {
            System.out.print("Ingrese nombre de usuario: ");
            nombUsu = scanner.next();
            nombreUsExis = false;
            if (Sistema.usuarios.containsKey(nombUsu) == true) {
                nombreUsExis = true;
            }
            if (nombreUsExis) {
                System.out.println("Nombre de usuario existente");
            }
        } while (nombreUsExis);
        return nombUsu;
    }


    //METODO PARA ASIGNAR FECHA
    //
    public static LocalDate asignarFecha() {
        LocalDate fecha;
        int dia = 43, mes = 1, ano = 2024;
        boolean incorrecto = true;

        while ((dia > 32 || dia < 0) || (mes < 0 || mes > 12) || (ano < 1900) || incorrecto) {
            boolean mostrar=true;
            try {
                incorrecto = false;
                System.out.println("Ingrese día: ");
                dia = scanner.nextInt();

                scanner.nextLine();
                System.out.println("Ingrese mes: ");
                mes = scanner.nextInt();

                scanner.nextLine();
                System.out.println("Ingrese año: ");
                ano = scanner.nextInt();

                scanner.nextLine();
            } catch (Exception ew) {
                mostrar=false;
                incorrecto = true;
                System.out.println("Datos incorrectos, pruebe de nuevo");
                scanner.next();
            }
            if(((dia > 31|| dia < 0) || (mes < 0 || mes > 12) || (ano < 1900)) && mostrar){
                System.out.println("Datos incorrectos, pruebe de nuevo");
            }
        }


        fecha = LocalDate.of(ano, mes, dia);
        return fecha;
    }
}

