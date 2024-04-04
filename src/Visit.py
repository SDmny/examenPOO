
class Visit:
    def __init__(self, guide_id, visitors, visit_date):
        self.guide_id = guide_id
        self.visitors = visitors
        self.visit_date = visit_date
        self.total_cost = self.calculate_total_cost()
        self.calculate_visitors_age()

    def get_guide_id(self):
        return self.guide_id

    def get_visitors(self):
        return self.visitors

    def get_total_cost(self):
        return self.total_cost

    def get_visit_date(self):
        return self.visit_date

    def get_num_children(self):
        return self.num_children

    def get_num_adults(self):
        return self.num_adults

    def calculate_total_cost(self):
        cost = 0
        for visitor in self.visitors:
            base_cost = 50 if int(visitor.get_birth_date().split('-')[0]) < 2005 else 100
            discounted_cost = base_cost * 0.8 if visitor.get_visit_count() % 5 == 0 else base_cost
            cost += discounted_cost
        return cost

    def calculate_visitors_age(self):
        self.num_children = sum(1 for visitor in self.visitors if int(visitor.get_birth_date().split('-')[0]) < 2006)
        self.num_adults = len(self.visitors) - self.num_children

    def show_data(self):
        print("ID del Guía:", self.guide_id)
        print("Costo total de la visita: $", self.total_cost)
        print("Cantidad de niños:", self.num_children)
        print("Cantidad de adultos:", self.num_adults)
        print("CURP de Visitantes:")
        for visitor in self.visitors:
            print("- " + visitor.get_name() + " " + visitor.get_last_name())
        print("Fecha de la visita:", self.visit_date)