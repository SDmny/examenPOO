from datetime import date

class Producto:
    def _init_(self, nombre, precio, stock, numero, fecha_importacion, tipo):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock
        self.numero = numero
        self.fecha_importacion = fecha_importacion
        self.tipo = tipo

class Electrodomestico(Producto):
    def _init_(self, nombre, precio, stock, numero, fecha_importacion, tipo, watts, color, descripcion):
        super()._init_(nombre, precio, stock, numero, fecha_importacion, tipo)
        self.watts = watts
        self.color = color
        self.descripcion = descripcion

    def get_descripcion(self):
        return self.descripcion

    def set_descripcion(self, descripcion):
        self.descripcion = descripcion

    def get_color(self):
        return self.color

    def set_color(self, color):
        self.color = color

    def get_watts(self):
        return self.watts

    def set_watts(self, watts):
        self.watts = watts
