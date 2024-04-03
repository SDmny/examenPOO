import random


class Employee:
    name = ""
    lastname = ""
    birthday = ""
    date = ""
    rfc = ""
    curb = ""
    schedule = ""
    rol = ''
    salary = 1
    id = 1

    def __init__(self, name, lastname, birthday, date, rfc, curb, rol, salary, schedule):
        self.name = name.upper()
        self.lastname = lastname.upper()
        self.birthday = birthday
        self.date = date
        self.rfc = rfc.upper()
        self.curb = curb.upper()
        self.salary = salary
        self.rol = rol
        self.id = random.randint(0, 10000)
        self.schedule = schedule

    def showData(self):
        if (self.rol == 'v'):
            self.job="Veterinario"
        elif(self.rol=='g'):
            self.job="Guía"
        elif(self.rol=='a'):
            self.job="Administración"
        elif(self.rol=='m'):
            self.job="Mantenimiento"
        print(
              f"El id del empleado es   {self.id}  y  es {self.name}  {self.lastname} , su labor es {self.job} , su RFC es  {self.rfc} , su curp es  {self.curb} , su salario es  {self.salary} , su fecha de entrada es {self.date} , su fecha de nacimiento es  {self.birthday}")

    # setters y getters
    def setName(self, name):
        self.name = name.upper()

    def getName(self):
        return self.name

    def setLastname(self, lastname):
        self.lastname = lastname.upper()

    def getLastname(self):
        return self.lastname

    def setBirthday(self, birthday):
        self.birthday = birthday

    def getBirthday(self):
        return self.birthday

    def setCurb(self, curb):
        self.curb = curb.upper()

    def getCurb(self):
        return self.curb

    def setDate(self, date):
        self.date = date

    def getDate(self):
        return self.date

    def setRfc(self, rfc):
        self.rfc = rfc.upper()

    def getRfc(self):
        return self.rfc

    def setSalary(self, salary):
        self.salary = salary

    def getSalary(self):
        return self.salary

    def setRol(self, rol):
        self.rol = rol

    def getRol(self):
        return self.rol

    def getSchedule(self):
        return self.schedule

    def setSchedule(self, schedule):
        self.schedule = schedule

    def setId(self, id):
        self.id = id

    def getId(self):
        return self.id

    def changeId(self):
        self.id = random.randint(0, 10000)
