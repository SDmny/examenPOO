
class Visitor:
    def __init__(self, name, last_name, birth_date, curp, registration_date):
        self.name = name
        self.last_name = last_name
        self.birth_date = birth_date
        self.curp = curp
        self.visit_count = 0
        self.registration_date = registration_date

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_last_name(self):
        return self.last_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def get_birth_date(self):
        return self.birth_date

    def set_birth_date(self, birth_date):
        self.birth_date = birth_date

    def get_curp(self):
        return self.curp

    def set_curp(self, curp):
        self.curp = curp

    def get_visit_count(self):
        return self.visit_count

    def set_visit_count(self, visit_count):
        self.visit_count = visit_count

    def get_registration_date(self):
        return self.registration_date

    def set_registration_date(self, registration_date):
        self.registration_date = registration_date

    def increment_visit_count(self):
        self.visit_count += 1

    def show_data(self):
        print("Nombre:", self.name)
        print("Apellidos:", self.last_name)
        print("Fecha de nacimiento:", self.birth_date)
        print("CURP:", self.curp)
        print("Número de visitas:", self.visit_count)
        print("Fecha de registro:", self.registration_date)