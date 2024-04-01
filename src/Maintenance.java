public class Maintenance {
    // atributos
    private String processType;
    //private Employee employee;
    private int idAnimal;
    private String processDate;
    private String observations;
    // constructores
    public Maintenance(String processType, /*Employee employee, */ int idAnimal, String processDate, String observations){
        this.processType = processType;
        //this.employee = employee;
        this.idAnimal = idAnimal;
        this.processDate = processDate;
        this.observations = observations;
    }
    public Maintenance(String processType, /*Employee employee, */ int idAnimal, String processDate){
        this.processType = processType;
        //this.employee = employee;
        this.idAnimal = idAnimal;
        this.processDate = processDate;
    }

    // getters - setters
    public String getProcessType() {
        return processType;
    }
    public void setProcessType(String processType) {
        this.processType = processType;
    }
    /*public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }*/
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
