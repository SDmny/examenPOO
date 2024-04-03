
class Visit:
    def __init__(self, guide_name, visitors, visit_date):
        self.guide_name = guide_name
        self.visitors = visitors
        self.visit_date = visit_date
        self.total_cost = self.calculate_total_cost()
        self.calculate_visitors_age()

    def get_guide_name(self):
        return self.guide_name

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
            base_cost = 50 if visitor.get_birth_date() < "2005" else 100
            discounted_cost = base_cost * 0.8 if visitor.get_visit_count() % 5 == 0 else base_cost
            cost += discounted_cost
        return cost

    def calculate_visitors_age(self):
        self.num_children = 0
        self.num_adults = 0
        for visitor in self.visitors:
            if self.is_valid_birth_date(visitor.get_birth_date()):
                if visitor.get_birth_date() < "2005":
                    self.num_children += 1
                else:
                    self.num_adults += 1

    def is_valid_birth_date(self, birth_date):
        if len(birth_date) != 7 or birth_date[4] != '-':
            return False

        birth_year = int(birth_date[:4])
        return 2024 >= birth_year >= 2024 - 150

    def show_data(self):
        print("Guía:", self.guide_name)
        print("Costo total de la visita: $", self.total_cost)
        print("Cantidad de niños:", self.num_children)
        print("Cantidad de adultos:", self.num_adults)
        print("Visitantes:")
        for visitor in self.visitors:
            print("- " + visitor.get_name() + " " + visitor.get_last_name())
        print("Fecha de la visita:", self.visit_date)