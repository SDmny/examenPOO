from Employee import Employee
class Bank:
    cantidad_empleados=0
    empleados=[]
   
     
    def add_employee(self):
        name=((input("Ingrese nombre y apellidos: ")))
        age=( (input("Ingrese edad: ")))
        self.empleados.append(Employee(name,age))
        quantity= int(input("Ingrese la cantidad de cuentas a crear (sí no desea crear cuentas ingrese 0): "))
        for i in range(quantity):
            type= input("Ingrese tipo de cuenta: ")
            accountNumber=input("Ingrese el número de cuenta: ")
            self.empleados[self.cantidad_empleados].add_account(accountNumber,type)
            
        self.cantidad_empleados=self.cantidad_empleados+1
    
    def get_employees(self):
        return self.empleados
    
    def get_employee(self):
        self.num=int(input("Ingrese número de empleado: "))
        self.num=self.num-1
        return self.empleados[self.num]
    
    def show_account(self):
        account=(input("Ingrese el número de cuenta del empleado: "))
        for i in self.empleados:
         if(account==i.account(account)):
             i.show_account()
        
        
    def minus_account(self,amount):
        account=(input("Ingrese el número de cuenta del empleado: "))
        for i in self.empleados:
         if(account==i.account(account)):
             i.retirar_cuenta(account,amount)
             
    def add_to_account(self,amount):
        account=(input("Ingrese el número de cuenta del empleado: "))
        for i in self.empleados:
            if(account==i.account(account)):
              i.agregar_a_cuenta(account,amount)
                 

                
            