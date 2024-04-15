from datetime import date

class Producto:
    def _init_(self, name, precio, stock, no, fecha_importacion, tipo):
        self.name = name
        self.precio = precio
        self.stock = stock if stock >= 0 else 0
        self.no = no
        self.fecha_importacion = fecha_importacion
        self.tipo = tipo
        self.id = 0

    def get_fecha_importacion(self):
        return self.fecha_importacion

    def set_fecha_importacion(self, fecha_importacion):
        self.fecha_importacion = fecha_importacion

    def get_no(self):
        return self.no

    def set_no(self, no):
        self.no = no

    def get_name(self):
        return self.name if self.name != "" else "No hay nombre"

    def set_name(self, name):
        self.name = name

    def get_precio(self):
        return self.precio

    def set_precio(self, precio):
        if precio >= 0:
            self.precio = precio

    def set_stock(self, stock):
        if stock >= 0:
            self.stock = stock

    def get_stock(self):
        return self.stock

    def aumentar_stock(self, stock):
        if stock >= 0:
            self.stock += stock
        else:
            print("No se puede introducir una cantidad negativa")

    def reducir_stock(self, stock):
        if stock <= self.stock:
            self.stock -= stock
            return True
        else:
            print(f"No se puede comprar {self.name} {self.id}, hay menos productos en stock de los que se piden")
            return False

    def get_tipo(self):
        return self.tipo

    def set_tipo(self, tipo):
        self.tipo = tipo

    def get_id(self):
        return self.id

    def set_id(self, id):
        self.id = id

    def _str_(self):
        return f"Producto{{Nombre='{self.name}', Tipo de producto='{self.tipo}', Precio={self.precio}, Stock={self.stock}, Número de serie={self.no}, Fecha de importacion={self.fecha_importacion}, Id={self.id}}}"