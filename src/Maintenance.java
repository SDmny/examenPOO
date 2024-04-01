public class Maintenance {
    // atributos
    private int idEmployee;
    private String processType;
    private int idAnimal;
    private String processDate;
    private String observations;
    // constructores
    public Maintenance(int idEmployee, String processType, int idAnimal, String processDate, String observations){
        this.idEmployee = idEmployee;
        this.processType = processType;
        this.idAnimal = idAnimal;
        this.processDate = processDate;
        this.observations = observations;
    }
    public Maintenance(int idEmployee, String processType, int idAnimal, String processDate){
        this.idEmployee = idEmployee;
        this.processType = processType;
        this.idAnimal = idAnimal;
        this.processDate = processDate;
    }

    // getters - setters
    public int getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    public String getProcessType() {
        return processType;
    }
    public void setProcessType(String processType) {
        this.processType = processType;
    }
    public int getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
    public String getProcessDate() {
        return processDate;
    }
    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }
    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }

}
