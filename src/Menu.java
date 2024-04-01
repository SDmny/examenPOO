import java.util.ArrayList;
import java.util.Scanner;

//Menú en construcción.
public class Menu {

    Scanner scan = new Scanner(System.in);

    //METODOS DEL MENU PRINCIPAL
    //contraseña del programa
    private String word = "TROYANO";

    public Menu() {
        Selection();
    }

    public void Selection() {
        char program = ' ';
        while (program != '0') {

            System.out.println("Ingrese un caracter para continuar, use 0 para salir del programa: ");
            program = scan.nextLine().charAt(0);
            int select = 0;
            Password();
            while (select != 7) {

                System.out.println("Elija la sección a utilizar: ");
                System.out.println("1 Menu de empleados");
                System.out.println("2 Menu de animales");
                System.out.println("3 Menu de visitantes");
                System.out.println("4 Menu de mantenimientos");
                System.out.println("5 Menu de visitas");
                System.out.println("6 Cambiar contraseña");
                System.out.println("7 Salir del Menu principal");

                select = scan.nextInt();
                scan.nextLine();
                switch (select) {
                    case 1:
                        MenuEmployees();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:

                        System.out.println("Ingrese nueva contraseña");
                        word = scan.nextLine();
                        break;
                    case 7:
                        System.out.println("Usted está saliendo del menú");
                        break;
                    default:
                        System.out.println("Esa opción no se encuentra en el menú");
                        break;

                }
            }
        }
    }


    //Contraseña del menu
    public void Password() {
        String password;

        do {
            System.out.println("Ingrese la contraseña");
            password = scan.nextLine();
            if (!password.equals(word)) {
                System.out.println("Contraseña incorrecta");
            } else System.out.println("Contraseña correcta");
        }

        while (!password.equals(word));

    }


    //METODOS DE EMPLEADOS
    ArrayList<Employee> employees = new ArrayList<>();

    //Menu de empleados
    public void MenuEmployees() {
        int employee, choice = 0;
        String name, lastname;
        while (choice != 6) {
            System.out.println("Menu de empleados: Elija una opción ");
            System.out.println("1 Registrar empleados");
            System.out.println("2 Eliminar empleado");
            System.out.println("3 Modificar datos de un empleado");
            System.out.println("4 Consultar a todos los empleados");
            System.out.println("5 Consultar datos de un empleado");
            System.out.println("6 Salir del menú de empleados");


            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Ingrese la cantidad de empleados a registrar");
                    employee = scan.nextInt();
                    scan.nextLine();
                    for (int i = 0; i < employee; i++) {
                        addEmployee();
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el Id del empleado: ");
                    employee = scan.nextInt();
                    scan.nextLine();
                    DeleteEmployee(employee);
                    break;
                case 3:
                    System.out.println("Ingrese el Id del empleado");
                    employee = scan.nextInt();
                    scan.nextLine();
                    ModifyEmployee(employee);

                    break;
                case 4:

                    for (Employee em : employees) {

                        em.showData();
                    }
                    break;
                case 5:
                    System.out.println("Ingrese los apellidos del empleado");
                    lastname = scan.nextLine().toUpperCase();
                    System.out.println("Ingrese el nombre del empleado");
                    name = scan.nextLine().toUpperCase();
                    for (Employee value : employees) {
                        if (value.getLastname().equals(lastname) && value.getName().equals(name)) {
                            value.showData();
                        }
                    }

                    break;
                case 6:
                    System.out.println("Volviendo a menú principal");
                    break;

                default:
                    System.out.println("Esa opción no se encuentra en el menú");
                    break;


            }
        }

    }


    //Añadir empleado
    public void addEmployee() {
        String name, lastname, birthday, date, rfc, curb, rol, schedule;
        double salary;
        char r;
        System.out.println("Ingrese con una letra el rol del empleado");
        rol = scan.nextLine();
        r = Verify_rol(rol);
        if (r != 'n') {
            System.out.println("Ingrese el nombre");
            name = scan.nextLine();
            System.out.println("Ingrese el apellido");
            lastname = scan.nextLine();
            System.out.println("Ingrese la fecha de nacimiento");
            birthday = scan.nextLine();
            System.out.println("Ingrese la fecha de ingreso");
            date = scan.nextLine();
            System.out.println("Ingrese el RFC");
            rfc = scan.nextLine();
            System.out.println("Ingrese la CURP");
            curb = scan.nextLine();
            System.out.println("Ingrese el horario");
            schedule = scan.nextLine();
            System.out.println("Ingrese el salario ");
            salary = scan.nextDouble();
            scan.nextLine();
            Employee employee = new Employee(name, lastname, birthday, date, rfc, curb, r, salary, schedule);
            employees.add(VerifyId(employee));
        }
    }

    //Verificar rol del empleado que se registró
    public char Verify_rol(String rol) {
        rol = rol.toLowerCase();
        char r = rol.charAt(0);
        switch (r) {
            case 'v':

            case 'g':

            case 'm':

            case 'a':

                break;
            default:
                r = 'n';
                System.out.println("El rol del empleado no existe");
                break;

        }
        return r;
    }

    //Verificar id del empleado que se registró para que no se repita con otra id
    public Employee VerifyId(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employee.getId()) {
                i = 0;
                employee.changeId();
            }
        }
        return employee;
    }

    //Eliminar empleado
    public void DeleteEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(employees.get(i));
            }
        }
    }

    //Modificar empleado
    public void ModifyEmployee(int id) {
        String name, lastname, birthday, date, rfc, curb, rol, schedule;
        double salary;
        int opcion = 99;
        for (Employee em : employees) {
            if (em.getId() == id) {
                while (opcion != 0) {
                    System.out.println("Ingrese la opción a modificar:");
                    System.out.println("1 Nombre");
                    System.out.println("2 Apellidos");
                    System.out.println("3 Fecha de Nacimiento");
                    System.out.println("4 Fecha de ingreso");
                    System.out.println("5 RFC");
                    System.out.println("6 CURP");
                    System.out.println("7 Rol dentro del zoológico");
                    System.out.println("8 Salario");
                    System.out.println("9 Horario");
                    System.out.println("0 Salir del menu de modificar");
                    opcion = scan.nextInt();
                    scan.nextLine();
                    switch (opcion) {
                        case 0:
                            System.out.println("Volviendo al menú de empleados");
                            break;
                        case 1:
                            System.out.print("Ingrese nuevo nombre: ");
                            name = scan.nextLine();
                            em.setName(name);

                            break;
                        case 2:
                            System.out.print("Ingrese nuevo apellido: ");
                            lastname = scan.nextLine();
                            em.setLastname(lastname);
                            break;
                        case 3:
                            System.out.print("Ingrese otra fecha de nacimiento: ");
                            birthday = scan.nextLine();
                            em.setBirthday(birthday);
                            break;
                        case 4:
                            System.out.print("Ingrese otra fecha de ingreso: ");
                            date = scan.nextLine();
                            em.setDate(date);
                            break;
                        case 5:
                            System.out.print("Ingrese otro RFC: ");
                            rfc = scan.nextLine();
                            em.setRfc(rfc);
                            break;
                        case 6:
                            System.out.print("Ingrese otra CURP: ");
                            curb = scan.nextLine();
                            em.setCurb(curb);
                            break;
                        case 7:
                            System.out.print("Ingrese otro rol: ");
                            rol = scan.nextLine();
                            em.setRol(Verify_rol(rol));
                            break;
                        case 8:
                            System.out.println("Ingrese nuevo salario");
                            salary = scan.nextDouble();
                            scan.nextLine();
                            em.setSalary(salary);
                            break;
                        case 9:
                            System.out.print("Ingrese nuevo horario: ");
                            schedule = scan.nextLine();
                            em.setSchedule(schedule);
                            break;

                        default:
                            System.out.println("Esa opción no se encuentra en el menú");
                            break;
                    }
                }
            }
        }


    }
}
