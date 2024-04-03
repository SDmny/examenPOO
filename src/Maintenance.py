class Maintenance:
    
    __id_employee = 0
    __process_type = ""
    __id_animal = 0
    __process_date = ""
    __observations = ""
    
    def __init__(self, id_employee, process_type, id_animal, process_date, observations):
        self.__id_employee = id_employee
        self.__process_type = process_type
        self.__id_animal = id_animal
        self.__process_date = process_date
        self.__observations = observations
    
    def showData(self):
        print(f"ID del empleado a cargo: {self.__id_employee}; Proceso realizado: {self.__process_type}; ID del animal: {self.__id_animal}; Fecha del proceso: {self.__process_date}")
        if (self.__observations != ""):
            print(f"; Observaciones: {self.__observations}")
   
    # setters y getters   
    def get_id_employee(self):
        return self.__id_employee
        
    def get_process_type(self):
        return self.__process_type
        
    def get_id_animal(self):
        return self.__id_animal
        
    def get_process_date(self):
        return self.__process_date
        
    def get_observations(self):
        return self.__observations
    
    def set_id_employee(self, value):
        self.__id_employee = value
    
    def set_process_type(self, value):
        self.__process_type = value
    
    def set_id_animal(self, value):
        self.__id_animal = value
    
    def set_process_date(self, value):
        self.__process_date = value
    
    def set_observations(self, value):
        self.__observations = value