package menus;

import java.util.Scanner;

public class MenuClientes {
    static Scanner scanner = new Scanner(System.in);
    public static void menuClientes(){
        String rol;
        do {
            System.out.println("\n1 - Cliente\n2 - Empleado\n3 - Inversionista\n0 - Regresar");
            System.out.print("Selección: ");
            rol = scanner.next();
            switch (rol){
                case "1": // menu clientes
                    break;
                case "2": // menu empleados
                    break;
                case "3": // menu inversionistas
                    break;
                case "0":
                    System.out.println("Regresando");
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!rol.equals("0"));
    }
}
