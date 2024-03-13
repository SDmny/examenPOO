from BankAccount import BankAccount
class Employee:
  
    name = ""
    age = 0

    def __init__(self, name, age):
        self.name = name
        self.age = age    
        self.accounts=[]  
        
  

    def get_name(self):
        return self.name
    
    def set_name(self, name):
        self.name = name
        
    def show_data(self):
        print(f"Su nombre es: {self.name} y su edad: {self.age}")
        
    def add_account(self, account_number,type):
       if(type=='A'or type=='B'or type=='C' ):
         self.bank=BankAccount(account_number,type)
         self.accounts.append(self.bank)
       else:
            print("La cuenta no se pudo crear")
               
    def show_accounts(self):
     print(f"Nombre: {self.name} :")
     for self.account in self.accounts:
         print(f"Cuenta: {self.account.get_account_number()}")
         print(f"Saldo: {self.account.getAmount()}")
      
    def show_account(self):
        for i in self.accounts:
                print(f"Saldo: {i.getAmount()}")
                print(f"Tipo de cuenta: {i.getType()}")
                
    def account(self,account):
        for i in self.accounts:
            if(account==i.get_account_number()):
                return i.get_account_number()
               
    def agregar_a_cuenta(self,account,amount):
        for i in self.accounts:
            if(account==i.get_account_number()):
                i.agregarDinero(amount)
                
    def retirar_cuenta(self,account,amount):
        for i in self.accounts:
            if(account==i.get_account_number):
                i.retirarDinero(amount)
        
       