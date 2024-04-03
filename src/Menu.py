from Employee import Employee


# Menú en construcción.
class Menu:
    # METODOS DEL MENU PRINCIPAL
    # contraseña del programa
    word = "TROYANO"
    program = ' '
    select = 1

    def __init__(self):
        self.Selection()

    def Selection(self):
        while self.program != '0':

            self.program = input("Ingrese un caracter para continuar, use 0 para salir del programa: ")
            if (self.program != '0'):
                self.Password()
                self.select=0
                while self.select != 7:

                    print("Menu ")
                    print("1 Menu de empleados")
                    print("2 Menu de animales")
                    print("3 Menu de visitantes")
                    print("4 Menu de mantenimientos")
                    print("5 Menu de visitas")
                    print("6 Cambiar contraseña")
                    print("7 Salir del Menu principal\n")

                    self.select = int(input("Elija la sección a utilizar: \n"))
                    if self.select == 1:
                        self.MenuEmployees()
                    elif self.select == 2:
                        print("")
                    elif self.select == 3:
                        print("")
                    elif self.select == 4:
                        print("")
                    elif self.select == 5:
                        print("")
                    elif self.select == 6:
                        self.word = input("Ingrese nueva contraseña: ")
                    elif self.select == 7:
                        print("Usted está saliendo del menú\n")
                    else:
                        print("Esa opción no se encuentra en el menú\n")

    # Contraseña del menu
    def Password(self):
        password = ""

        while True:
            password = input("Ingrese la contraseña: ")
            if (password != self.word):
                print("Contraseña incorrecta")
            else:
                print("Contraseña correcta")
                break

    # METODOS DE EMPLEADOS
    employees = []

    # Menu de empleados
    def MenuEmployees(self):
        choice = 0
        while (choice != 6):
            print("Menu de empleados: ")
            print("1 Registrar empleados")
            print("2 Eliminar empleado")
            print("3 Modificar datos de un empleado")
            print("4 Consultar a todos los empleados")
            print("5 Consultar datos de un empleado")
            print("6 Salir del menú de empleados\n")

            choice = int(input("Elija una opción \n"))
            if choice == 1:
                employee = int(input("Ingrese la cantidad de empleados a registrar: "))
                for i in range(employee):
                    self.addEmployee()


            elif choice == 2:
                employee = int(input("Ingrese el Id del empleado: ") )
                self.DeleteEmployee(employee)
            elif (choice == 3):
                employee = int(input("Ingrese el Id del empleado: ") )
                self.modify_employee(employee)

            elif (choice == 4):
                for em in self.employees:
                    em.showData()

            elif (choice == 5):
                lastname = input("Ingrese los apellidos del empleado: ")
                name = input("Ingrese el nombre del empleado: ")
                for value in self.employees:
                    print (f"apellido: {value.getLastname()}")
                    print(f"nombre: {value.getName()}")
                    if value.getLastname() == lastname.upper() and value.getName() == name.upper():
                        value.showData()

            elif (choice == 6):
                print("Volviendo a menú principal")


            else:
                print("Esa opción no se encuentra en el menú")

    # Añadir empleado
    def addEmployee(self):
        rol = input("Ingrese con una letra el rol del empleado: ")
        r = self.Verify_rol(rol)
        if r != 'n':
            name = input("Ingrese el nombre: ")
            lastname = input("Ingrese el apellido: ")
            birthday = input("Ingrese la fecha de nacimiento: ")
            date = input("Ingrese la fecha de ingreso: ")
            rfc = input("Ingrese el RFC: ")
            curb = input("Ingrese la CURP: ")
            schedule = input("Ingrese el horario: ")
            salary = float(input("Ingrese el salario: "))
            employee = Employee(name, lastname, birthday, date, rfc, curb, r, salary, schedule)
            self.employees.append(self.verify_id(employee))

    # Verificar rol del empleado que se registró
    def Verify_rol(self, rol):
        r = rol.lower()
        if r == 'v':
            return r
        if r == 'g':
            return r
        if r == 'm':
            return r

        if r == 'a':
            return r

        else:
            r = 'n'
            print("El rol del empleado no existe\n")
            return r

    # Verificar id del empleado que se registró para que no se repita con otra id
    def verify_id(self, employee):
        i = 54
        while (i < 1):
            for em in self.employees:
                if em.getId() == employee.getId():
                    employee.changeId()
                    i = i - 1
            i = i + 1

        return employee

    # Eliminar empleado
    def DeleteEmployee(self, id):
        for i in self.employees:
            if i.getId() == id:
                self.employees.remove(i)

    # Modificar empleado
    def modify_employee(self, id):
        option = 99
        for em in self.employees:
            if em.getId() == id:
                while option != 0:
                    print("Menu modificar empleado: ")
                    print("1 Nombre")
                    print("2 Apellidos")
                    print("3 Fecha de Nacimiento")
                    print("4 Fecha de ingreso")
                    print("5 RFC")
                    print("6 CURP")
                    print("7 Rol dentro del zoológico")
                    print("8 Salario")
                    print("9 Horario")
                    print("0 Salir del menu de modificar\n")
                    option = int(input("Ingrese la opción a modificar"))

                    if (option == 0):
                        print("Volviendo al menú de empleados\n")
                    elif (option == 1):
                        name = input("Ingrese nuevo nombre: ")
                        em.setName(name)
                    elif option == 2:
                        lastname = input("Ingrese nuevo apellido: ")
                        em.setLastname(lastname)
                    elif option == 3:
                        birthday = input("Ingrese otra fecha de nacimiento: ")
                        em.setBirthday(birthday)
                    elif option == 4:
                        date = input("Ingrese otra fecha de ingreso: ")
                        em.setDate(date)
                    elif option == 5:
                        rfc = input("Ingrese otro RFC: ")
                        em.setRfc(rfc)
                    elif option == 6:
                        curb = input("Ingrese otra CURP: ")
                        em.setCurb(curb)
                    elif option == 7:
                        rol = input("Ingrese otro rol: ")
                        em.setRol(self.Verify_rol(rol))
                    elif option == 8:
                        salary = input("Ingrese nuevo salario")
                        em.setSalary(salary)
                    elif option == 9:
                        schedule = input("Ingrese nuevo horario: ")
                        em.setSchedule(schedule)
                    else:
                        print("Esa opción no se encuentra en el menú\n")
