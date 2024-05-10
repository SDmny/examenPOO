package tarjetas;

import tarjetas.utils.Generar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Tarjeta {
    private String numeroTarjeta;
    private String cvv;
    private LocalDate fechaCreacion;
    private String clabeInterbancaria;
    private LocalDate fechaVencimiento;
    private LocalDateTime fechaHoraUltimoMov;

    public Tarjeta(int clave) {
        this.numeroTarjeta = generarTarjeta(clave);
        this.cvv = generarCvv();
        this.fechaCreacion = LocalDate.now();
        this.clabeInterbancaria = generarClabe();
        LocalDate fecha = LocalDate.now();
        int anio = fecha.getYear() + 5; 
        this.fechaVencimiento = LocalDate.of(anio, fecha.getMonth(), fecha.getDayOfMonth());
        this.fechaHoraUltimoMov = null;
    }

    private String generarTarjeta(int clave) {
        this.numeroTarjeta = Generar.generarTarjeta(clave);
        return numeroTarjeta;
    }

    private String generarCvv() {
        Random r = new Random();
        this.cvv = Integer.toString(r.nextInt(900)+100);
        return cvv;
    }

    private String generarClabe() {
        Random r = new Random();
        String campo1 = Integer.toString(r.nextInt(900)+100);
        String campo2 = Integer.toString(r.nextInt(900));
        String campo3 = Integer.toString(r.nextInt(900)+100);
        String campo4 = Integer.toString(r.nextInt(900)+100);
        String campo5 = Integer.toString(r.nextInt(900)+100);
        String campo6 = Integer.toString(r.nextInt(900)+100);
        this.clabeInterbancaria = campo1 + " " + campo2 + " " + campo3 + " " + campo4 + " " + campo5 + " " + campo6;
        return clabeInterbancaria;
    }

    private LocalDateTime getFechaHoraUltimoMov() {
        return fechaHoraUltimoMov;
    }

    public void setFechaHoraUltimoMov(LocalDateTime fechaHoraUltimoMov) {
        this.fechaHoraUltimoMov = fechaHoraUltimoMov;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getClabeInterbancaria() {
        return clabeInterbancaria;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoFechaVen = DateTimeFormatter.ofPattern("MM/YY");
        DateTimeFormatter formatoFechaCreacion = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String fechaC = formatoFechaCreacion.format(fechaCreacion);
        String fechaVen = formatoFechaVen.format(fechaVencimiento);
        return String.format("Núm.Tarjeta: %s\nFecha de Creación: %s\nFecha de Vencimiento: %s",numeroTarjeta,fechaC,fechaVen);
    }

    public String fechaUltimoMov() {
        DateTimeFormatter formatoFechaM = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        String fechaM = formatoFechaM.format(fechaHoraUltimoMov);
        return String.format("Último movimiento: %s",fechaM);
    }
}