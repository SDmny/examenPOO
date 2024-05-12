package tarjetas.utils;

import java.time.LocalDate;
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
        IDS++;

    }
    
    /*
    public void aprobarTarjeta(){
        status="Solicitud Aprobada";
        TarjetaCredito tarjetaCredito=new TarjetaCredito(5579,tipoTarjeta);
        cliente.getTarjetasCredito().add(tarjetaCredito);

    }
    public void rechazarTarjeta(){
        status="Solicitud Rechazada";
    }
    */

    @Override
    public String toString(){
        return String.format("Cliente solicitante: %s; Fecha de solicitud: %s; Tipo de tarjeta: %s", cliente, fechaSolicitud, tipoTarjeta);
    }
    
    public String getStatus() {
        return status;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public TipoTarjetaCredito getTipoTarjeta() {
        return tipoTarjeta;
    }
}