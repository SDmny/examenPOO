import java.util.ArrayList;
class Visit {
    private String guideName;
    private ArrayList<Visitor> visitors;
    private double totalCost;
    private String visitDate;
    private int numChildren;
    private int numAdults;

    public Visit(String guideName, ArrayList<Visitor> visitors, String visitDate) {
        this.guideName = guideName;
        this.visitors = visitors;
        this.visitDate = visitDate;
        this.totalCost = calculateTotalCost();
        calculateVisitorsAge();
    }

    // getters y setters
    public String getGuideName() {
        return guideName;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public int getNumAdults() {
        return numAdults;
    }

    private double calculateTotalCost() {
        double cost = 0;
        for (Visitor visitor : visitors) {
            double baseCost = (visitor.getBirthDate().compareTo("2005") < 0) ? 50 : 100; 
            double discountedCost = (visitor.getVisitCount() % 5 == 0) ? baseCost * 0.8 : baseCost; 
            cost += discountedCost;
        }
        return cost;
    }

    private void calculateVisitorsAge() {
        numChildren = 0;
        numAdults = 0;
        for (Visitor visitor : visitors) {
            if (isValidBirthDate(visitor.getBirthDate())) {
                if (visitor.getBirthDate().compareTo("2005") < 0) {
                    numChildren++;
                } else {
                    numAdults++;
                }
            }
        }
    }

    private boolean isValidBirthDate(String birthDate) {
        if (birthDate.length() != 7 || birthDate.charAt(4) != '-') {
            return false;
        }
    
        // Obtener el año actual
        int currentYear = java.time.LocalDate.now().getYear();
    
        int birthYear;
        String birthYearString = birthDate.substring(0, 4);
        if (birthYearString.matches("\\d{4}")) { 
            birthYear = Integer.parseInt(birthYearString);
        } else {
            return false;
        }
    
        return birthYear <= currentYear && birthYear >= currentYear - 150;
    }

    public void showData() {
        System.out.println("Guía: " + guideName);
        System.out.println("Costo total de la visita: $" + totalCost);
        System.out.println("Cantidad de niños: " + numChildren);
        System.out.println("Cantidad de adultos: " + numAdults);
        System.out.println("Visitantes:");
        for (Visitor visitor : visitors) {
            System.out.println("- " + visitor.getName() + " " + visitor.getLastName());
        }
        System.out.println("Fecha de la visita: " + visitDate);
    }
}
