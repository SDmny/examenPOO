package tarjetas.utils;

import java.time.LocalDate;

public class SolicitudTarjetaC {

    private LocalDate fechaSolicitud;
    private String  tipoTarjeta;
    private String status;
    int idCliente;

    public void aprobarTarjeta(){
        status="Solicitud Aprobada";
        Generar.generarTarjeta(5579);
    }
    public void rechazarTarjeta(){
        status="Solicitud Rechazada";
    }
    public String toString(){
        return String.format("Cliente: ,Fecha de solicitud: %s , Tipo de tarjeta: %s",fechaSolicitud,tipoTarjeta);
    }
}
