package tarjetas.utils;

import sistema.Sistema;
import tarjetas.TarjetaCredito;
import usuarios.Cliente;

import java.time.LocalDate;

public class SolicitudTarjetaC {

    private Cliente cliente;
    private LocalDate fechaSolicitud;
    private TipoTarjetaCredito  tipoTarjeta;
    private String status;
    private int idCliente;
    private int id;
    private static int IDS=1;

    public SolicitudTarjetaC(Cliente cliente, TipoTarjetaCredito tipo){
        this.cliente = cliente;
        this.status= "En espera";
        this.tipoTarjeta = tipo;
        this.idCliente = cliente.getId();
        this.id = IDS;
        this.fechaSolicitud = LocalDate.now();
        IDS++;

    }

    public static void aprobarTarjeta(int id){
        int credito=0;
        for (SolicitudTarjetaC solicitudTarjetaC : Sistema.solicitudes) {
            if (solicitudTarjetaC.getId() == id){
                solicitudTarjetaC.setStatus("Solicitud Aprobada");
                if (solicitudTarjetaC.getTipoTarjeta() == TipoTarjetaCredito.ORO){
                    credito = 400000;
                } else if (solicitudTarjetaC.getTipoTarjeta() == TipoTarjetaCredito.PLATINO) {
                    credito = 150000;
                } else if (solicitudTarjetaC.getTipoTarjeta() == TipoTarjetaCredito.SIMPLICITY) {
                    credito = 60000;
                }
                TarjetaCredito tarjeta = new TarjetaCredito(5579, credito);
            }
        }
    }
    public static void rechazarTarjeta(int id){
        for (SolicitudTarjetaC solicitudTarjetaC : Sistema.solicitudes) {
            if (solicitudTarjetaC.getId() == id){
                solicitudTarjetaC.setStatus("Solicitud Rechazada");
            }
        }
    }
    @Override
    public String toString(){
        return String.format("Cliente solicitante: %s; Fecha de solicitud: %s; Tipo de tarjeta: %s", cliente, fechaSolicitud, tipoTarjeta);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public TipoTarjetaCredito getTipoTarjeta() {
        return tipoTarjeta;
    }

    public String getStatus() {
        return status;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
