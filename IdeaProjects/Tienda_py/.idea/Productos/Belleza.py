from datetime import date

class Producto:
    def _init_(self, nombre, precio, stock, numero, fecha_importacion, tipo):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock
        self.numero = numero
        self.fecha_importacion = fecha_importacion
        self.tipo = tipo

class Belleza(Producto):
    def _init_(self, nombre, precio, stock, numero, fecha_importacion, tipo, duracion_diaria, color):
        super()._init_(nombre, precio, stock, numero, fecha_importacion, tipo)
        self.color = color
        self.duracion_diaria = duracion_diaria

    def get_duracion_diaria(self):
        return self.duracion_diaria

    def set_duracion_diaria(self, duracion_diaria):
        self.duracion_diaria = duracion_diaria

    def get_color(self):
        return self.color

    def set_color(self, color):
        self.color = color
