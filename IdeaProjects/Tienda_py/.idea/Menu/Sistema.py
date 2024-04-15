import sys
from datetime import datetime
from Compra import Compra
from Cliente import Cliente
#no tengo idea de porque no importa las clases
#pero no pude revisar lo demás por ello
from Productos.Producto import Producto
from Productos.Alimento import Alimento
from Productos.Belleza import Belleza
from Productos.Electrodomestico import Electrodomestico
from Productos.Limpieza import Limpieza

class Sistema:
    compra= Compra()
    def sistema(self):
        salir = " "
        while salir != "0":
            print("Ingrese un caracter para continuar, 0 para salir:")
            salir = input()
            if salir != "0":
                if self.password():
                    self.menu()

    def password(self):
        word = "TROYANO"
        password = ""
        while password != "0" and password != word:
            password = input("Ingrese la contraseña, o ingrese 0 para salir: ")
            if password == word:
                print("La contraseña es correcta")
                print("Ingresando......")
            else:
                if password == "0":
                    print("Usted ha salido del menú")
                else:
                    print("La contraseña es incorrecta")
        return password != "0"

    def menu(self):
        opcion = 0
        while opcion != 5:
            print("\t----Bienvenido al menú----")
            print("\tSeleccione una opción para continuar: ")
            print("\t1 Menu de Tienda")
            print("\t2 Menu de Clientes")
            print("\t3 Menu de Productos")
            print("\t4 Cambiar contraseña")
            print("\t5 Salir")
            opcion = int(input())
            if opcion == 1:
                self.menu_tienda()
            elif opcion == 2:
                if self.password():
                    self.menu_cliente()
            elif opcion == 3:
                if self.password():
                    self.menu_producto()
            elif opcion == 4:
                print("Saliendo del menú")
            else:
                print("Esa opción no se encuentra")

    def menu_tienda(self):
        opcion = 0
        while opcion != 3:
            print("\t----Bienvenido a la Tienda----")
            print("\tSeleccione una opción para continuar: ")
            print("\t1 Comprar producto")
            print("\t2 Mostrar todos los productos")
            print("\t3 Salir")
            opcion = int(input())
            if opcion == 1:
                print("Ingrese id del Cliente:")
                id_cliente = int(input())
                print("Ingrese cantidad de tipos de productos a comprar: ")
                cantidad_productos = int(input())
                for _ in range(cantidad_productos):
                    print("Ingrese id del producto:")
                    id_producto = int(input())
                    print("Ingrese cantidad a comprar de este producto: ")
                    cantidad_comprar = int(input())
                    self.compra.comprar(id_cliente, id_producto, cantidad_comprar)
            elif opcion == 2:
                self.compra.mostrar_productos()
            elif opcion == 3:
                print("Usted está saliendo de la tienda")
            else:
                print("Esa opción no se encuentra")

    def menu_cliente(self):
        opcion = 0
        while opcion != 6:
            print("\t----Bienvenido al menú----")
            print("\tSeleccione una opción para continuar: ")
            print("\t1 Registrar cliente(s)")
            print("\t2 Eliminar cliente")
            print("\t3 Modificar cliente")
            print("\t4 Mostrar a todos los clientes")
            print("\t 5 Mostrar a un cliente")
            print("\t6 Salir")
            opcion = int(input())
            if opcion == 1:
                nombre = input("Ingrese el nombre: ")
                edad = int(input("Ingrese la edad: "))
                cliente = Cliente(nombre, edad)
                self.compra.add_cliente(cliente)
            elif opcion == 2:
                id_cliente = int(input("Ingrese el id del cliente: "))


                self.compra.eliminar_cliente(id_cliente)
            elif opcion == 3:
                    id_cliente = int(input("Ingrese el id del cliente: "))
                    self.compra.modificar_cliente(id_cliente)
            elif opcion == 4:
                self.compra.mostrar_clientes()
            elif opcion == 5:
                id_cliente = int(input("Ingrese el id del cliente: "))
                self.compra.mostrar_cliente(id_cliente)
            elif opcion == 6:
                print("Saliendo del menú")
            else:
                print("Esa opción no se encuentra")

    def menu_producto(self):
        opcion = 0
        while opcion != 6:
            print("\t----Bienvenido al Menú de producto----")
            print("\tSeleccione una opción para continuar: ")
            print("\t1 Registrar producto")
            print("\t2 Eliminar producto")
            print("\t3 Modificar producto")
            print("\t4 Mostrar todos los productos")
            print("\t5 Aumentar stock del producto")
            print("\t6 Salir")
            opcion = int(input())
            if opcion == 1:
                print("Ingrese nombre:")
                nombre = input()
                print("Ingrese tipo:")
                tipo = input()
                print("Ingrese precio:")
                precio = float(input())
                print("Ingrese stock:")
                stock = int(input())
                print("Ingresando fecha de importación:")
                fecha_importacion = self.compra.asignar_fecha()
                print("Ingrese número de serie:")
                no_serie = int(input())
                print("Elija el tipo de producto")
                print("1 Alimento")
                print("2 Limpieza")
                print("3 Electrodomestico")
                print("4 Belleza")
                opcion_tipo = int(input())
                if opcion_tipo == 1:
                    print("Escriba fecha de caducidad (AAAA-MM-DD):")
                    fecha_caducidad = self.compra.asignar_fecha()
                    producto = Alimento(nombre, precio, stock, no_serie, fecha_importacion, tipo, fecha_caducidad)
                elif opcion_tipo == 2:
                    print("Ingrese aroma:")
                    aroma = input()
                    print("¿El producto es recomendado? (Sí/No):")
                    recomendado = input().lower() == 'si'
                    producto = Limpieza(nombre, precio, stock, no_serie, fecha_importacion, tipo, aroma, recomendado)
                elif opcion_tipo == 3:
                    print("Ingrese color:")
                    color = input()
                    print("Ingrese watts:")
                    watts = float(input())
                    print("Ingrese descripción:")
                    descripcion = input()
                    producto = Electrodomestico(nombre, precio, stock, no_serie, fecha_importacion, tipo, watts, descripcion, color)
                elif opcion_tipo == 4:
                    print("Ingrese color:")
                    color = input()
                    print("Ingrese duración diaria en horas:")
                    duracion_diaria = int(input())
                    producto = Belleza(nombre, precio, stock, no_serie, fecha_importacion, tipo, duracion_diaria, color)
                else:
                    print("Opción no válida.")
                    continue
                self.compra.add_producto(producto)
            elif opcion == 2:
                print("Ingrese ID del producto a eliminar:")
                id_producto = int(input())
                self.compra.eliminar_producto(id_producto)
            elif opcion == 3:
                print("Ingrese ID del producto a modificar:")
                id_producto = int(input())
                self.compra.modificar_producto(id_producto)
            elif opcion == 4:
                self.compra.mostrar_productos()
            elif opcion == 5:
                print("Ingrese ID del producto:")
                id_producto = int(input())
                print("Ingrese cantidad de stock a aumentar:")
                cantidad = int(input())
                self.compra.aumentar_stock(id_producto, cantidad)
            elif opcion == 6:
                print("Saliendo del menú")
            else:
                print("Esa opción no se encuentra")
