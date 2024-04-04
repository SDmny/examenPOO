
public class Visitor {
    private String name;
    private String lastName;
    private String birthDate;
    private String CURP;
    private int visitCount;
    private String registrationDate;

    public Visitor(String name, String lastName, String birthDate, String CURP, String registrationDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.CURP = CURP;
        this.visitCount = 0;
        this.registrationDate = registrationDate;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void incrementVisitCount() {
        visitCount++;
    }

    //showData
    public void showData() {
        System.out.println("Nombre: " + name);
        System.out.println("Apellidos: " + lastName);
        System.out.println("Fecha de nacimiento: " + birthDate);
        System.out.println("CURP: " + CURP);
        System.out.println("Numero de visitas: " + visitCount);
        System.out.println("Fecha de registro: " + registrationDate);
    }
}
