from Employee import Employee
from Animal import Animal
from Maintenance import Maintenance

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
                        self.menu_animals()
                    elif self.select == 3:
                        print("")
                    elif self.select == 4:
                        self.menu_maintenances()
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
                        
    # METODOS DE ANIMALES
    
    animals = []
    
    # Menu de animales
    def menu_animals(self):
        choice = 0
        while (choice != 6):
            print("Menu de animales: ")
            print("1 Registrar animal")
            print("2 Eliminar animal")
            print("3 Modificar datos de un animal")
            print("4 Consultar a todos los animales")
            print("5 Consultar datos de un animal")
            print("6 Salir del menú de animales\n")
            choice = int(input("Elija una opción \n"))
            if choice == 1:
                self.add_animal()
            elif choice == 2:
                id_animal = int(input("ID del animal: "))
                self.delete_animal(id_animal)
            elif (choice == 3):
                self.modify_animal()
            elif (choice == 4):
                for animal in self.animals:
                    animal.showData()
            elif (choice == 5):
                id_animal = int(input("ID del animal a mostrar: "))
                for value in self.animals:
                    if value.get_id_animal() == id_animal:
                        value.showData()    
            elif (choice == 6):
                print("Volviendo a menú principal")
            else:
                print("Esa opción no se encuentra en el menú")

    # Lista de enfermedades
    def diseases_list(self):
        diseases = []
        disease = ""
        disease = input("0 - Terminar lista\nEnfermedad: ")
        while (disease != "0"):
            diseases.append(disease)
            disease = input("0 - Terminar lista\nEnfermedad: ")
        return diseases

    # Vacunas
    def animal_vaccines(self):
        vaccines = False
        aux = input("¿El animal cuenta con vacunas?\n0 - No\n1 - Sí\n")
        if (aux == 1):
            vaccines = True
        return vaccines
    
    
    # Añadir animal
    def add_animal(self):
        print(" - - - Añadir animal - - - \n")
        type = input("Tipo de animal: ")
        date_admission = input("Fecha de ingreso: ")
        birthdate = input("Fecha de nacimiento: ")
        weight = float(input("Peso del animal: "))
        diseases = self.diseases_list()
        feeding = input("Tipo de alimentacion: ")
        feeding_frequency_hrs = input("Frecuencia de alimentacion: ")
        vaccines = self.animal_vaccines()
        animal = Animal(type, date_admission, birthdate, weight, diseases, feeding, feeding_frequency_hrs, vaccines)
        self.animals.append(animal)
        Animal.ids_aux = Animal.ids_aux+1
        
    # Eliminar animal
    def delete_animal(self, id):
        busy = False
        id = id-1
        id_aux = 0        
        for i in self.animals:
            id_aux = id_aux + 1
        if (id >= 0 and id < id_aux):
            for x in self.maintenances:
                if x.get_id_animal() == id+1:
                    busy = True
            if busy == False:
                self.animals.remove(self.animals[id])
            else:
                print("Operación cancelada, el animal tiene un acontecimiento pendiente")
        else:
            print("Operación cancelada, ID incorrecta")       
    
    # Modificar animal
    def modify_animal(self):
        id_animal = int(input("ID del animal a modificar: "))   
        for animal in self.animals:
            if animal.get_id_animal() == id_animal:
                print("\nOpciones\n0 - Cancelar\n1 - Tipo de animal\n2 - Fecha de llegada\n3 - Fecha de nacimiento\n4 - Peso\n5 - Enfermedades\n6 - Tipo de alimentación\n7 - Frecuencia de alimentación\n8 - Vacunas\n")
                option = int(input("Elección: "))
                while option != 0:
                    if option == 0:
                        print("Volviendo al menú\n")
                    elif (option == 1):
                        type = input("Ingrese nuevo tipo: ")
                        animal.set_type(type)
                    elif option == 2:
                        date = input("Ingrese nueva fecha de llegada: ")
                        animal.set_date_admission(date)
                    elif option == 3:
                        date = input("Ingrese nueva fecha de nacimiento: ")
                        animal.set_birthdate(date)
                    elif option == 4:
                        weight = float(input("Ingrese nuevo peso: "))
                        animal.set_weight(weight)
                    elif option == 5:
                        animal.set_diseases(self.diseases_list())
                    elif option == 6:
                        feeding = input("Ingrese nuevo tipo de alimentación: ")
                        animal.set_feeding(feeding)
                    elif option == 7:
                        feeding_frequency = input("Ingrese nueva frecuencia de alimentación: ")
                        animal.set_feeding_frequency(feeding_frequency)
                    elif option == 8:
                        animal.set_vaccines(self.animal_vaccines())
                    else:
                        print("Esa opción no se encuentra en el menú\n")
                    print("\nOpciones\n0 - Cancelar\n1 - Tipo de animal\n2 - Fecha de llegada\n3 - Fecha de nacimiento\n4 - Peso\n5 - Enfermedades\n6 - Tipo de alimentación\n7 - Frecuencia de alimentación\n8 - Vacunas\n")
                    option = int(input("Elección: "))
            else:
                print("Operación cancelada, ID incorrecta")
                        
                
    # METODOS DE MANTENIMIENTOS
    
    maintenances = []
    
    # Menu de mantenimientos
    def menu_maintenances(self):
        choice = 0
        while (choice != 3):
            print("Menu de mantenimientos: ")
            print("1 Registrar mantenimiento")
            print("2 Consultar a todos los mantenimientos")
            print("3 Salir del menú de animales\n")
            choice = int(input("Elija una opción \n"))
            if choice == 1:
                self.add_maintenance()
            elif (choice == 2):
                for maintenance in self.maintenances:
                    maintenance.showData()
            elif (choice == 3):
                print("Volviendo a menú principal")
            else:
                print("Esa opción no se encuentra en el menú")

    
    
    def maintenance_employee_rol(self):
        emp_in_list = -1
        aux = 0
        id_employee = int(input("ID del empleado encargado del mantenimiento: "))
        for x in self.employees:
            if x.getId() == id_employee:
                emp_in_list = aux
            aux = aux + 1
        if emp_in_list < 0:
            print("ID incorrecta")
            id_employee = -1
        if self.employees[emp_in_list].getRol() != 'm':
            print("El empleado no cuenta con el rol de mantenimiento")
            id_employee = -1
        return id_employee
                
    def maintenance_type(self):
        process_type = ""
        type = input("Tipo de proceso: \n0 - Cancelar\n1 - Mantenimiento\n2 - Limpieza\n3 - Alimentación\n4 - Otro\n")
        if type == "1":
            process_type = "Mantenimiento"
        elif type == "2":
            process_type = "Limpieza"   
        elif type == "3":
            process_type = "Alimentación" 
        elif type == "4":
            process_type = input("Ingrese tipo de mantenimiento: ")    
        return process_type
        
    def maintenance_observations(self):
        observations = "Sin observaciones"
        aux = input("¿Observaciones?\n0 - No\n1 - Sí\n")  
        if aux == "1":
            observations =  input("Ingrese observaciones: ")
        return observations
    
    # Añadir mantenimiento
    def add_maintenance(self):
        print(" - - - Añadir mantenimiento - - - \n")
        id_employee = self.maintenance_employee_rol()
        if id_employee != -1:
            process_type = self.maintenance_type()
            if process_type != "":
                id_animal = int(input("ID del animal: "))
                process_date = input("Fecha del proceso: ")
                observations = self.maintenance_observations()
                maintenance = Maintenance(id_employee, process_type, id_animal, process_date, observations)
                self.maintenances.append(maintenance)
            else:
                print("Mantenimiento cancelado, tipo de proceso incorrecto")
        else:
            print("Mantenimiento cancelado, empleado encargado incorrecto")
    
