package Sistema;

import Usuarios.Usuario;
import Usuarios.utils.Gente;
import Usuarios.utils.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class DatosComun {
    //SCANNER STATICO
    public static Scanner sc = new Scanner(System.in);

    //METODO PARA OBTENER DATOS INCOMPLETO
    public static void ObtenerDatos() {
        String nombre, apellido1, apellido2, ciudad, estado, rfc, curb, direccion, homoclave;
        Sucursal sucursal;
        Gente rol;
        boolean incorrecto = true;
        LocalDate birth;
        while (incorrecto) {
            try {
                incorrecto = false;
                System.out.println("Ingrese nombre: ");
                nombre = sc.nextLine();
                birth = asignarFecha();
            } catch (Exception ew) {
                incorrecto = true;
                System.out.println("Hubo un error al ingresar los datos");
            }
        }

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

    //METODO PARA ASIGNAR FECHA
    //
    public static LocalDate asignarFecha() {
        LocalDate fecha;
        Scanner scanner = new Scanner(System.in);
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

