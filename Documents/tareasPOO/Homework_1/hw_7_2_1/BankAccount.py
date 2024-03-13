class BankAccount :
     accountNumber=""
     amount=0
     type=''

     def __init__(self, accountNumber , type):
        self.accountNumber=accountNumber
        self.type=type
        
     def get_account_number(self) :
        return self.accountNumber
    

     def getType(self) :
        return self.type
    

     def getAmount(self) :
        return self.amount
    

     def agregarDinero(self,  amount) :
        if (self.type == 'A'):  
         self.agregarDineroA(amount)
        elif (self.type == 'B'):
            self.agregarDineroB(amount)
        elif(self.type== 'C'):
            self.amount=self.amount+amount
            
     def retirarDinero(self,amount):
         if (self.type == 'A'):  
            self.retirarDineroA(amount)
         elif (self.type == 'B'):
            self.retirarDineroB(amount)
         elif(self.type== 'C'):
            self.retirarDineroC(amount)
            
     def retirarDineroA(self,amount):
         if(amount<1000 or self.amount<amount):
             print("No se puede retirar el dinero")
         else:
            self.amount=self.amount+amount
            
     def retirarDineroB(self,amount):
         if(amount<5000 or self.amount<amount):
             print("No se puede retirar el dinero")
         else:
            self.amount=self.amount+amount
            
     def retirarDineroC(self,amount):
         if(amount<10000 or self.amount<amount):
             print("No se puede retirar el dinero")
         else:
            self.amount=self.amount+amount
          
    

     def agregarDineroA(self, amount) :
        if (self.amount + amount <= 50000):
            print("Se agregó")
            self.amount += amount
        else:
            print("No puede tener más de 50,000 cuenta A")
          
     def agregarDineroB(self, amount) :
        if (self.amount + amount <= 100000):
            self.amount += amount
        else:
            print("No puede tener más de 100,000 cuenta B")
            
     
        