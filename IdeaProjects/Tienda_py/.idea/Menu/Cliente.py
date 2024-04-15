from datetime import date
from datetime import datetime

class Cliente:
    def _init_(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
        self.id = 0
        self.comprado = []
        self.cantidad = []
        self.fecha = []

    def registrar_producto(self, producto, cantidad):
        self.fecha_actual = date.today()
        self.fecha.append(self.fecha_actual)
        self.comprado.append(producto)
        self.cantidad.append(cantidad)

    def mostrar_productos(self):
        i = 0
        fecha_anterior = date(1996, 1, 1)
        for producto in self.comprado:
            if self.fecha[i] != fecha_anterior:
                print("\nFecha de compra(s):", self.fecha[i], "\n")
            fecha_anterior = self.fecha[i]
            print("Nombre:", producto.nombre)
            print("id:", producto.id)
            print("Número de serie:", producto.numero_serie)
            print("Fecha de importación:", producto.fecha_importacion)
            print("Precio:", producto.precio)
            print("Clase:", producto._class.name_)
            print("Cantidad comprada:", self.cantidad[i])
            print("Precio total:", producto.precio * self.cantidad[i])
            i += 1

    def _str_(self):
        return f"Nombre='{self.nombre}', Edad={self.edad}, Id={self.id}"


