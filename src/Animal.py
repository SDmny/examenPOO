class Animal:
    
    ids_aux = 1
    __id_animal = 0
    __type = ""
    __date_admission = ""
    __birthdate = ""
    __weight = 0
    __diseases = []
    __feeding = ""
    __feeding_frequency = ""
    __vaccines = False
    
    def __init__(self, type, date_admission, birthdate, weight, diseases, feeding, feeding_frequency, vaccines):
        self.__type = type
        self.__date_admission = date_admission
        self.__birthdate = birthdate
        self.__weight = weight
        self.__diseases = diseases
        self.__feeding = feeding
        self.__feeding_frequency = feeding_frequency
        self.__vaccines = vaccines
        self.__id_animal = ids_aux
        ids_aux = ids_aux + 1
    
    def showData(self):
        print(f"ID: {self.__id_animal}; Tipo de animal: {self.__type}; Fecha de llegada: {self.__date_admission}; Fecha de nacimiento: {self.__birthdate}; Peso:  {self.__weight}; Enfermedades: ")
        for x in self.__diseases:
            print(x)
        print(f"; Tipo de alimentación: {self.__feeding}; Frecuencia de alimentación: {self.__feeding_frequency}; Vacunas: ")
        if (self.__vaccines == True):
            print("Sí")
        else:
            print("No")
            
    # setters y getters   
    def get_id_animal(self):
        return self.__id_animal
    
    def get_type(self):
        return self.__type
    
    def get_date_admission(self):
        return self.__date_admission
    
    def get_birthdate(self):
        return self.__birthdate
    
    def get_weight(self):
        return self.__weight
    
    def get_diseases(self):
        return self.__diseases
    
    def get_feeding(self):
        return self.__feeding
    
    def get_feeding_frequency(self):
        return self.__feeding_frequency
    
    def get_vaccines(self):
        return self.__vaccines
    
    def set_type(self, value):
        self.__type = value
    
    def set_date_admission(self, value):
        self.__date_admission = value
    
    def set_birthdate(self, value):
        self.__birthdate = value
    
    def set_weight(self, value):
        self.__weight = value
    
    def set_diseases(self, value):
        self.__diseases = value
    
    def set_feeding(self, value):
        self.__feeding = value
    
    def set_feeding_frequency(self, value):
        self.__feeding_frequency = value
    
    def set_vaccines(self, value):
        self.__vaccines = value
    
    
    