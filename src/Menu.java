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

    //METODOS DE ANIMALES
    ArrayList<Animal> animals = new ArrayList<>();

    //Lista de enfermedades
    public ArrayList<String> diseasesList(){
        ArrayList<String> diseases = new ArrayList<>();
        String disease;
        System.out.print("Enfermedades\n0 - Terminar lista\n");
        disease = scan.next();
        if (disease!="0"){
            diseases.add(disease);
        }
        return diseases;
    }
    //Vacunas
    public boolean animalVaccines(){
        boolean vaccines = false;
        String aux;
        System.out.println("¿El animal cuenta con vacunas?\n0 - No\n 1 - Sí");
        aux = scan.next();
        if (aux == "1"){
            vaccines = true;
        }
        return vaccines;
    }
    //Añadir animal
    public void addAnimal() {
        // variables
        String type, dateAdmission, birthdate, feeding, feedingFrequencyHrs;
        double weight;
        ArrayList<String> diseases;
        boolean haveVaccines;
        // asignar valor
        System.out.println(" - - - Añadir animal - - -");
        System.out.print("Tipo de animal: ");
        type = scan.next();
        System.out.print("Fecha de ingreso: ");
        dateAdmission = scan.next();
        System.out.print("Fecha de nacimiento: ");
        birthdate = scan.next();
        System.out.print("Peso del animal: ");
        weight = scan.nextDouble();
        diseases = diseasesList();
        System.out.print("Tipo de alimentacion: ");
        feeding = scan.next();
        System.out.print("Frecuencia de alimentacion en horas: ");
        feedingFrequencyHrs = scan.next();
        haveVaccines = animalVaccines();
        // crear y añadir
        Animal animal = new Animal(type, dateAdmission, birthdate, weight, diseases, feeding, feedingFrequencyHrs, haveVaccines);
        animals.add(animal);
    }
    //Comprobar acontecimientos
    //Eliminar animal
    public void deleteAnimal(int id) {
        id--;
        if (id>=0 && id<animals.size()){
            animals.remove(animals.get(id));
        }
    }
    //Modificar animal

    //METODOS DE MANTENIMIENTOS
    ArrayList<Maintenance> maintenances = new ArrayList<>();

    //Verificar empleado de mantenimiento
    public int employeeRolMaintenance(){
        int idEmployee, empInArray=-1;
        System.out.print("ID del empleado encargado del mantenimiento: ");
        idEmployee = scan.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == idEmployee){
                empInArray = i;
            }
        }
        if (empInArray < 0){
            System.out.println("ID incorrecta");
            idEmployee = -1;
        }
        if (employees.get(empInArray).getRol() != 'm'){
            System.out.println("El empleado no es del rol mantenimiento");
            idEmployee = -1;
        }
        return idEmployee;
    }
    //Tipo de mantenimiento
    public String maintenanceType(){
        String processType = "", type;
        System.out.println("Tipo de proceso: \n0 - Cancelar\n1 - Mantenimiento\n2 - Limpieza\n3 - Alimentación\n4 - Otro\n");
        type = scan.next();
        switch (type){
            case "1": processType = "Mantenimiento";
                break;
            case "2": processType = "Limpieza";
                break;
            case "3": processType = "Alimentación";
                break;
            case "4":
                System.out.println("Ingrese tipo de mantenimiento: ");
                processType = scan.next();
                break;
            default:
        }
        return processType;
    }
    //Observaciones mantenimiento
    public String observationsMaintenance(){
        String observations = "", aux;
        System.out.println("¿Observaciones?\n0 - No\n1 - Sí\n");
        aux = scan.next();
        if (aux == "1"){
            System.out.print("Ingrese observaciones: ");
            observations = scan.next();
        }
        return observations;
    }
    //Añadir mantenimiento
    public void addMaintenance() {
        // variables
        String processType, processDate, observations;
        int idEmployee, idAnimal;
        // asignar valor
        System.out.println(" - - - Añadir acontecimiento de mantenimiento - - -");
        idEmployee = employeeRolMaintenance();
        if (idEmployee != -1){
            processType = maintenanceType();
            if (processType != ""){
                System.out.print("ID del animal: ");
                idAnimal = scan.nextInt();
                System.out.print("Fecha del proceso: ");
                processDate = scan.next();
                observations = observationsMaintenance();
                // crear y añadir
                if (observations != ""){
                    Maintenance maintenance = new Maintenance(idEmployee, processType, idAnimal, processDate, observations);
                    maintenances.add(maintenance);
                }
                else {
                    Maintenance maintenance = new Maintenance(idEmployee, processType, idAnimal, processDate);
                    maintenances.add(maintenance);
                }
            }
            else {
                System.out.println("Mantenimiento cancelado, tipo de proceso incorrecto");
            }
        }
        else {
            System.out.println("Mantenimiento cancelado, empleado encargado incorrecto");
        }
    }

}
