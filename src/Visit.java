import java.util.*;
public class Visitors {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
    
        // Registro de usuario
        System.out.println("----REGISTRO DE VISITANTES----");
        System.out.print("Introduzca su nombre: ");
        String name = read.nextLine();
        System.out.print("Introduzca su apellido: ");
        String surnames = read.nextLine();
        String birthDate;
        do {
            System.out.print("Introduza su fecha de nacimiento (dia-mes-año): ");
            birthDate = read.nextLine();
        } while (!fechaEsValida(birthDate));
        System.out.print("Introduzca su CURP: ");
        String curp = read.nextLine();
        String registrationDate = read.nextLine();
    
        Visitors visitor = new Visitors(name, surnames, birthDate, curp, registrationDate);
        System.out.println("Se ha registrado exitosamente");
    }
    // Método para validar si una fecha es válida
    private static boolean fechaEsValida(String fecha) {

        String[] partsDate = fecha.split("-");
        int day = Integer.parseInt(partsDate[0]);
        int month = Integer.parseInt(partsDate[1]);
        int year = Integer.parseInt(partsDate[2]);
        boolean band=true;

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1700 || year > 2024) {
            band=false;
        }
        // Comprobar febrero
        if (month == 2) {
            if (day > 29) {
                band=false;
            }
            if (day == 29 && !((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                band=false;
            }
        }
        // Comprobar meses con 30 días
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                band=false;
            }
        }
        if (band=false){
        System.out.println("La fecha introducida no es válida. Intente de nuevo.");
        return false;
    } else {
        return true;
    }
    }

    private String name;
    private String surnames;
    private String birthDate;
    private String curp;
    private int numVisits;
    private String registrationDate;

    // Constructor
    public Visitors(String name, String surnames, String birthDate, String curp, String registrationDate) {
        this.name = name;
        this.surnames = surnames;
        this.birthDate = birthDate;
        this.curp = curp;
        this.numVisits = 0;
        this.registrationDate = registrationDate;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getNumVisits() {
        return numVisits;
    }

    public void setNumVisits(int numVisits) {
        this.numVisits = numVisits;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    // Incrementar el número de visitas
    public void increaseVisits() {
        this.numVisits++;
    }

    // Método para determinar si el visitante es adulto
    public boolean isAdult() {
        return Integer.parseInt(registrationDate.split("-")[0]) - Integer.parseInt(birthDate.split("-")[0]) >= 18;
    }
}



