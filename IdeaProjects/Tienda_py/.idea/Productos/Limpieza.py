from datetime import date

class Producto:
    def _init_(self, nombre, precio, stock, numero, fecha_importacion, tipo):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock
        self.numero = numero
        self.fecha_importacion = fecha_importacion
        self.tipo = tipo

class Alimento(Producto):
    def _init_(self, nombre, precio, stock, numero, fecha_importacion, tipo, caducidad):
        super()._init_(nombre, precio, stock, numero, fecha_importacion, tipo)
        self.caducidad = caducidad
        self.fecha_actual = date.today()
        self.caduco = False
        if self.fecha_actual > caducidad:
            print("Este producto está caduco")
            self.caduco = True

    def get_caducidad(self):
        return self.caducidad

    def set_caducidad(self, caducidad):
        self.caducidad = caducidad
        if self.fecha_actual > caducidad:
            print("Este producto está caduco")
            self.caduco = True

