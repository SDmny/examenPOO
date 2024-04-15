from datetime import date
from datetime import datetime
from datetime import datetime
from Cliente import Cliente
from Productos.Producto import Producto
from Productos.Alimento import Alimento
from Productos.Belleza import Belleza
from Productos.Electrodomestico import Electrodomestico
from Productos.Limpieza import Limpieza

class Compra:
    def _init_(self):
        self.productos = []
        self.clientes = []
        self.cantidadP = 0
        self.cantidadC = 0

    def comprar(self, idC, idP, cantidad):
        precio = 0
        for producto in self.productos:
            if idP == producto.get_id():
                if producto.reducir_stock(cantidad):
                    precio = producto.get_precio() * cantidad
                    for cliente in self.clientes:
                        if idC == cliente.get_id():
                            cliente.registrar_producto(producto, cantidad)
                break
        return precio

    def add_producto(self, producto):
        producto.set_id(self.cantidadP)
        self.productos.append(producto)
        self.cantidadP += 1

    def aumentar_stock(self, id, cantidad):
        for producto in self.productos:
            if id == producto.get_id():
                producto.aumentar_stock(cantidad)
                break

    def modificar_producto(self, id):
        opcion = 0
        while opcion != 8:
            for producto in self.productos:
                if id == producto.get_id():
                    print("Ingrese la opción a modificar: ")
                    print("1 Nombre")
                    print("2 Tipo")
                    print("3 Precio")
                    print("4 Stock")
                    print("5 Fecha de importación")
                    print("6 Número de serie")
                    print("7 Otros")
                    print("8 Salir de la modificación")
                    opcion = int(input())
                    if opcion == 1:
                        name = input("Ingrese nuevo valor: ")
                        producto.set_name(name)
                    elif opcion == 2:
                        tipo = input("Ingrese nuevo valor: ")
                        producto.set_tipo(tipo)
                    elif opcion == 3:
                        precio = float(input("Ingrese nuevo valor: "))
                        producto.set_precio(precio)
                    elif opcion == 4:
                        stock = int(input("Ingrese nuevo valor: "))
                        producto.set_stock(stock)
                    elif opcion == 5:
                        fecha_importacion = self.asignar_fecha()
                        producto.set_fecha_importacion(fecha_importacion)
                    elif opcion == 6:
                        no = int(input("Ingrese nuevo valor: "))
                        producto.set_no(no)
                    elif opcion == 7:
                        if isinstance(producto, Alimento):
                            caracter = input("Cambiar fecha de caducidad (ingresar carácter, 0 para no): ")
                            if caracter != "0":
                                caducidad = self.asignar_fecha()
                                producto.set_fecha_importacion(caducidad)
                        elif isinstance(producto, Limpieza):
                            op = 0
                            while op != 3:
                                print("Ingrese la opción a modificar: ")
                                print("1 Aroma")
                                print("2 Recomendado por expertos")
                                print("3 Salir")
                                op = int(input())
                                if op == 1:
                                    aroma = input("Ingresar nuevo aroma: ")
                                    producto.set_aroma(aroma)
                                elif op == 2:
                                    caracter = input("¿El producto es recomendado por al menos 8 de cada 10 expertos? (0 para NO, otro carácter para SÍ): ")
                                    producto.set_recomend(caracter != "0")
                                else:
                                    print("Esa opción no se encuentra")
                        elif isinstance(producto, Electrodomestico):
                            op = 0
                            while op != 3:
                                print("Ingrese la opción a modificar: ")
                                print("1 Color")
                                print("2 Watts")
                                print("3 Descripción del producto")
                                print("4 Salir")
                                op = int(input())
                                if op == 1:
                                    color = input("Ingresar nuevo color: ")
                                    producto.set_color(color)
                                elif op == 2:
                                    watts = float(input("Ingresar watts: "))
                                    producto.set_watts(watts)
                                elif op == 3:
                                    descripcion = input("Ingresar descripción: ")
                                    producto.set_descripcion(descripcion)
                                else:
                                    print("Esa opción no se encuentra")
                        elif isinstance(producto, Belleza):
                            op = 0
                            while op != 3:
                                print("Ingrese la opción a modificar: ")
                                print("1 Color")
                                print("2 Duración diaria")
                                print("3 Salir")
                                op = int(input())
                                if op == 1:
                                    color = input("Ingresar nuevo color: ")
                                    producto.set_color(color)
                                elif op == 2:
                                    duracion = int(input("Ingresar duración diaria en horas enteras: "))
                                    producto.set_duracion_diaria(duracion)
                                else:
                                    print("Esa opción no se encuentra")

    def asignar_fecha(self):
        while True:
            try:
                fecha_str = input("Ingrese la fecha (AAAA-MM-DD): ")
                return datetime.strptime(fecha_str, "%Y-%m-%d").date()
            except ValueError:
                print("Formato de fecha incorrecto. Intente nuevamente.")

    def mostrar_productos():
        i = 0
        while i < 4:
            if i == 0:
                print("Alimentos: ")
            if i == 1:
                print("Limpieza: ")
            if i == 2:
                print("Electrodomesticos: ")
            if i == 3:
                print("Belleza: ")

            for producto in productos:
                if isinstance(producto, Alimento) and i == 0:
                    print(producto.get_name(), producto.get_tipo(), producto.get_id(), producto.get_stock())
                if isinstance(producto, Limpieza) and i == 1:
                    print(producto.get_name(), producto.get_tipo(), producto.get_id(), producto.get_stock())
                if isinstance(producto, Electrodomestico) and i == 2:
                    print(producto.get_name(), producto.get_tipo(), producto.get_id(), producto.get_stock())
                if isinstance(producto, Belleza) and i == 3:
                    print(producto.get_name(), producto.get_tipo(), producto.get_id(), producto.get_stock())

            i += 1

    def mostrar_producto(id):
        for producto in productos:
            if id == producto.get_id():
                print("Producto: " + str(producto))

    def eliminar_producto(id):
        for producto in productos:
            if id == producto.get_id():
                productos.remove(producto)

    def add_cliente(cliente):
        clientes.append(cliente)
        cliente.set_id(cantidadC)
        cantidadC += 1

    def modificar_cliente(id):
        opcion = 0
        while opcion != 3:
            for cliente in clientes:
                if id == cliente.get_id():
                    print("Ingrese la opción a modificar: ")
                    print("1 Nombre")
                    print("2 Edad")
                    print("3 Salir")
                    opcion = int(input())
                    if opcion == 1:
                        nombre = input("Ingrese el nombre: ")
                        cliente.set_nombre(nombre)
                    elif opcion == 2:
                        edad = int(input("Ingrese la edad: "))
                        cliente.set_edad(edad)
                    elif opcion == 3:
                        print("Saliendo del menú")
                    else:
                        print("Esa opción no se encuentra")

        def mostrar_clientes():
            for cliente in clientes:
                print(cliente)

        def mostrar_cliente(id):
            for cliente in clientes:
                if id == cliente.get_id():
                    print(cliente)

        def eliminar_cliente(id):
            for cliente in clientes:
                if id == cliente.get_id():
                    clientes.remove(cliente)