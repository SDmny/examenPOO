package usuarios;

import usuarios.utils.DatosComun;
import usuarios.utils.Sucursal;
import usuarios.utils.Gente;

import java.time.LocalDate;

public class Empleado extends Usuario {

    double salario = 5000;

    public Empleado(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curb, String direccion, Sucursal sucursal, Gente rol, double salario, String usuario, String contrasena, LocalDate birth) {
        super(nombre, apellido1, apellido2, sexo, ciudad, estado, curb, direccion, sucursal, rol, usuario, contrasena, birth);
        this.salario = salario;

    }

    public static double asignarSalario() {
        double sueldo = 5000;
        boolean incorrecto = true;
        while (incorrecto) {
            System.out.println("Ingresar salario");
            try {
                incorrecto = false;
                sueldo = DatosComun.scanner.nextDouble();

                if (sueldo < 0) {
                    throw new Exception();
                }
            } catch (Exception ew) {
                incorrecto = true;
                System.out.println("No se pudo ingresar el salario, pruebe de nuevo");
            }
        }
        return sueldo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void modificarEmpleado() {
        int op = 0;
        boolean incorrecto = true;
        System.out.println("1. Modificar salario");
        System.out.println("2. Modificar otro dato");
        System.out.println("3. Salir");
        while (incorrecto) {
            try {
                incorrecto = false;
                op = DatosComun.scanner.nextInt();
                if (op < 1 || op > 3) {
                    throw new Exception();
                }
            } catch (Exception ew) {
                incorrecto = true;
                System.out.println("Opción inválida, pruebe de nuevo");
            }
        }

        switch (op) {
            case 1:
               salario=asignarSalario();
                break;
            case 2:
                System.out.println("Menu Modificar: ");
                ModificarDato();
                break;
            case 3:
                System.out.println("Usted ha dejado de modificar al empleado");
                break;

        }
    }

    @Override
    public String toString() {
        String cadena = String.format("Id: %d; Nombre completo: %s %s %s; Rol: %s; Nombre de usuario: %s, Salario: %f", id, nombre, apellido1, apellido2, rol, usuario, salario);
        return cadena;
    }
}
