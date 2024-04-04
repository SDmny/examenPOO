import java.util.ArrayList;

public class Animal {
    // variables
    static int idsAux=1;
    // atributos
    private int idAnimal;
    private String type;
    private String dateAdmission;
    private String birthdate;
    private double weight;
    private ArrayList<String> diseases = new ArrayList<>();
    private String feeding;
    private String feedingFrequencyHrs;
    private boolean vaccines;

    // constructor
    public Animal(String type, String dateAdmission, String birthdate, double weight, ArrayList<String> diseases, String feeding, String feedingFrequencyHrs, boolean vaccines){
        this.type = type;
        this.dateAdmission = dateAdmission;
        this.birthdate = birthdate;
        this.weight = weight;
        this.diseases = diseases;
        this.feeding = feeding;
        this.feedingFrequencyHrs = feedingFrequencyHrs;
        this.vaccines = vaccines;
        this.idAnimal = idsAux;
    }


    // getters - setters
    public int getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDateAdmission() {
        return dateAdmission;
    }
    public void setDateAdmission(String dateAdmission) {
        this.dateAdmission = dateAdmission;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public ArrayList<String> getDiseases() {
        return diseases;
    }
    public void setDiseases(ArrayList<String> diseases) {
        this.diseases = diseases;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getFeeding() {
        return feeding;
    }
    public void setFeeding(String feeding) {
        this.feeding = feeding;
    }
    public String getFeedingFrequencyHrs() {
        return feedingFrequencyHrs;
    }
    public void setFeedingFrequencyHrs(String feedingFrequencyHrs) {
        this.feedingFrequencyHrs = feedingFrequencyHrs;
    }
    public boolean getVaccines() {
        return vaccines;
    }
    public void setVaccines(boolean vaccines) {
        this.vaccines = vaccines;
    }

    // show data
    public void showData(){
        System.out.print("\nID: "+getIdAnimal()+"; Tipo de animal: "+getType()+"; Fecha de llegada: "+getDateAdmission()+"; Fecha de nacimiento: "+getBirthdate()+"; Peso: "+getWeight()+"; Enfermedades: ");
        for (int i = 0; i < getDiseases().size(); i++) {
            System.out.print(getDiseases().get(i));
            if (i+1 < getDiseases().size()){
                System.out.print(", ");
            }
            else {
                System.out.print("; ");
            }
        }
        System.out.print("Tipo de alimentación: "+getFeeding()+"; Frecuencia de alimentación por horas: "+getFeedingFrequencyHrs()+"; Vacunas: ");
        if (getVaccines() == true){
            System.out.print("Sí.\n");
        }
        else {
            System.out.print("No.\n");
        }
    }
}
