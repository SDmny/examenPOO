import java.util.Random;

public class Employee {
    Random ran = new Random();
    private String name, lastname, birthday, date, rfc, curb, schedule;
    private char rol;
    private double salary;
    private int id;

    public Employee(String name, String lastname, String birthday, String date, String rfc, String curb, char rol, double salary, String schedule) {
        this.name = name.toUpperCase();
        this.lastname = lastname.toUpperCase();
        this.birthday = birthday;
        this.date = date;
        this.rfc = rfc.toUpperCase();
        this.curb = curb.toUpperCase();
        this.salary = salary;
        this.rol = rol;
        this.id = ran.nextInt(100000);
        this.schedule = schedule;
    }

    public void showData() {
        String job = "";
        switch (this.rol){
            case 'v': job = "Veterinario";
                break;
            case 'g': job = "Guía";
                break;
            case 'm': job = "Mantenimiento";
                break;
            case 'a': job = "Administración";
                break;
        }
        System.out.println("El id del empleado es " + this.id + ", y  es " + this.name + " " + this.lastname + ", su labor es " + job + ", su RFC es " + this.rfc + ", su curp es " + this.curb + ", su salario es " + this.salary + ", su fecha de entrada es " + this.date + ", su fecha de nacimiento es " + this.birthday);

    }

    //setters y getters
    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname.toUpperCase();
    }

    public String getLastname() {
        return lastname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setCurb(String curb) {
        this.curb = curb.toUpperCase();
    }

    public String getCurb() {
        return curb;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc.toUpperCase();
    }

    public String getRfc() {
        return rfc;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setRol(char rol) {
        this.rol = rol;
    }

    public char getRol() {
        return rol;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void changeId() {
        this.id = ran.nextInt(100000);
    }
}