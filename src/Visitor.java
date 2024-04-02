import java.util.*;
public class ZooVisitor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Registro de usuario
        System.out.println("Bienvenido al registro de visitantes.");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su apellido: ");
        String apellidos = scanner.nextLine();
        String fechaNacimiento;
        do {
            System.out.print("Ingrese su fecha de nacimiento (dia-mes-año): ");
            fechaNacimiento = scanner.nextLine();
        } while (!fechaEsValida(fechaNacimiento));
        System.out.print("Ingrese su CURP: ");
        String curp = scanner.nextLine();
        String fechaRegistro = scanner.nextLine();

        Visitante visitante = new Visitante(nombre, apellidos, fechaNacimiento, curp, fechaRegistro);
        System.out.println("¡Registro exitoso!");

        // Información de visita
        ArrayList<Visitante> visitantes = new ArrayList<>();
        visitantes.add(visitante);

        System.out.print("Ingrese el nombre del guía de la visita: ");
        String guia = scanner.nextLine();
        String fechaVisita = scanner.nextLine();

        Visit visita = new Visit(guia, visitantes, fechaVisita);

        System.out.println("\nInformación de la visita registrada:");
        System.out.println("Guía a cargo: " + visita.getGuia());
        System.out.println("Fecha de la visita: " + visita.getFechaVisita());
        System.out.println("Costo total de la visita: $" + visita.getCostoTotal());
        System.out.println("Cantidad de niños: " + visita.getCantidadNinos());
        System.out.println("Cantidad de adultos: " + visita.getCantidadAdultos());
    }

    // Método para validar si una fecha es válida
    private static boolean fechaEsValida(String fecha) {

            String[] partesFecha = fecha.split("-");
            int dia = Integer.parseInt(partesFecha[0]);
            int mes = Integer.parseInt(partesFecha[1]);
            int anio = Integer.parseInt(partesFecha[2]);
            boolean band=true;

            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || anio < 1700 || anio > 2024) {
                band=false;
            }

            // Comprobar febrero
            if (mes == 2) {
                if (dia > 29) {
                    band=false;
                }
                if (dia == 29 && !((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0)) {
                    band=false;
                }
            }

            // Comprobar meses con 30 días
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                if (dia > 30) {
                    band=false;
                }
            }
            if (band=false){
            System.out.println("La fecha introducida no es válida. Por favor, inténtelo de nuevo.");
            return false;
        } else {
            return true;
        }
    }
}
    