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
        String nombre, apellido1, apellido2, ciudad, estado, curp="", direccion, homoclave, usuario, contrasena;
        char sexo=' ';
        Sucursal sucursal;
        Gente rol;
        boolean incorrecto = true;
        LocalDate birth=LocalDate.now();

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
        System.out.print("Ingrese dirección: ");
        direccion = scanner.next();
        usuario = obtenerNombreUsuario();
        System.out.print("Ingrese contraseña: ");
        contrasena = scanner.next();

        while (incorrecto) {
            try {
                incorrecto = false;
                System.out.print("Ingrese sexo (M - Masculino / F - Femenino): ");
                sexo = (scanner.next()).charAt(0);
            } catch (Exception ew) {
                incorrecto = true;
                System.out.println("Hubo un error al ingresar los datos");
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
        try {
            curp = generarCURP(nombre, apellido1, apellido2, birth, sexo, estado);
        } catch (Exception ew) {
            incorrecto = true;
            System.out.println("SI SALE ESTE MENSAJE: ERROR EN CURP SOS!!!!");
        }
        datosComun.addAll(Arrays.asList(nombre, apellido1, apellido2, String.valueOf(sexo), ciudad, estado, curp, direccion, usuario, contrasena));
        return datosComun;
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
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("YYMMdd");
        String fechaNacimientoS = formatoFecha.format(fechaNacimiento);
        Random r = new Random();
        int numero1 = r.nextInt(26)+65;
        char caracter1 = (char) numero1;
        String letra1 = Character.toString(caracter1);
        int numero2 = r.nextInt(26)+65;
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

    // metodo para nombre de usuario
    private static String obtenerNombreUsuario(){
        boolean nombreUsExis = true;
        String nombUsu = "";
        do {
            System.out.print("Ingrese nombre de usuario: ");
            nombUsu = scanner.next();
            nombreUsExis = false;
            if (Sistema.usuarios.containsKey(nombUsu) == true){
                nombreUsExis = true;
            }
            if (nombreUsExis){
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
                incorrecto = true;
                System.out.println("Datos incorrectos, pruebe de nuevo");
            }

        }
        fecha = LocalDate.of(ano, mes, dia);
        return fecha;
    }
}

