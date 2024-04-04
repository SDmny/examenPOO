class Visit {
    private int guideId;
    private Visitor[] visitors;
    private double totalCost;
    private String visitDate;
    private int numChildren;
    private int numAdults;

    public Visit(int guideId, Visitor[] visitors, String visitDate) {
        this.guideId = guideId;
        this.visitors = visitors;
        this.visitDate = visitDate;
        this.totalCost = calculateTotalCost();
        calculateVisitorsAge();
    }

    // Getters
    public int getGuideId() {
        return guideId;
    }

    public Visitor[] getVisitors() {
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
            int birthYear = Integer.parseInt(visitor.getBirthDate().substring(0, 4));
                if (birthYear < 2006) {
                    numChildren++;
                } else {
                    numAdults++;
                }
        }
    }

    public void showData() {
        System.out.println("ID del Guía: " + guideId);
        System.out.println("Costo total de la visita: $" + totalCost);
        System.out.println("Cantidad de niños: " + numChildren);
        System.out.println("Cantidad de adultos: " + numAdults);
        System.out.println("CURP de Visitantes:");
        for (Visitor visitor : visitors) {
            System.out.println("- " + visitor.getName() + " " + visitor.getLastName());
        }
        System.out.println("Fecha de la visita: " + visitDate);
    }
}