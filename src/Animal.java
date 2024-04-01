public class Animal {
    // variables
    int idsAux=1;
    // atributos
    private int idAnimal;
    private String type;
    private String dateAdmission;
    private String birthdate;
    private String[] diseases;
    private double weight;
    private String feeding;
    private String feedingFrequencyHrs;
    private boolean haveVaccines;

    // constructor
    public Animal(String type, String dateAdmission, String birthdate, String[] diseases, double weight, String feeding, String feedingFrequencyHrs, boolean haveVaccines){
        this.type = type;
        this.dateAdmission = dateAdmission;
        this.birthdate = birthdate;
        this.diseases = diseases;
        this.weight = weight;
        this.feeding = feeding;
        this.feedingFrequencyHrs = feedingFrequencyHrs;
        this.haveVaccines = haveVaccines;
        this.idAnimal = idsAux;
        idsAux++;
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
    public String[] getDiseases() {
        return diseases;
    }
    public void setDiseases(String[] diseases) {
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
    public boolean isHaveVaccines() {
        return haveVaccines;
    }
    public void setHaveVaccines(boolean haveVaccines) {
        this.haveVaccines = haveVaccines;
    }

}
