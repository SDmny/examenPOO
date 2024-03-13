
from Bank import Bank


banco= Bank()
menu=0
while(menu!=8):
    print("Menu:")
    print("1 Agregar empleado\n2 Mostrar empleados\n3 Mostrar a un empleado\n4 Mostrar todas las cuentas\n5 Mostrar una cuenta")
    print("6 Agregar dinero a un cuenta\n7 Retirar dinero de una cuenta\n8 Salir ")
    h=1
    menu = int(input("Ingrese un número para continuar: "))
    if(menu==1):
     usuarios=int(input("Ingrese cantidad de empleados: "))
     for i in range(usuarios):
         banco.add_employee()
       
    elif(menu==2):
        for r in banco.get_employees():
            print(f"\nEmpleado: {h} ")
            r.show_data()
            h=h+1
    elif(menu==3):
        banco.get_employee().show_data()
    elif(menu==4):
     for empleado in banco.get_employees():
         print(f" Empleado {h}: ")
         empleado.show_accounts()
         h=h+1
    elif(menu==5):
        
        banco.show_account()
    elif(menu==6):
        amount=int(input("Ingrese cantidad a agregar: "))
        banco.add_to_account(amount)
    elif(menu==7):
        amount=int(input("Ingrese cantidad a retirar: "))
        banco.minus_account(amount)
   
print("Usted ha salido del programa")