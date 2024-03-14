import random

class Usuario:
    __id = 0
    __nombre = ""
    __edad = 0
    

    def __init__(self, nombre, edad):
        self.__id = random.randint(1, 1000)
        self.__nombre = nombre
        self.__edad = edad
        self.__libros_rentados = []

    def get_nombre(self):
        return self.__nombre
    
    def get_id(self):
        return self.__id
    
    def have_a_book(self):
        if len(self.__libros_rentados)!=0:
            return True
        else:
            return False
        
    def show_books(self):
        if len(self.__libros_rentados)!=0:
            print("Libros: ")
            for i in self.__libros_rentados:
                i.get_data()
    
    
    def rentar_libro(self,libro):
        self.__libros_rentados.append(libro)
        
    def devolver_libro(self,name):
        for  i in self.__libros_rentados:
          if(i.get_nombre()==name):
            h= self.__libros_rentados.index(i)
            self.__libros_rentados.pop(h)
    
    