package tarjetas.utils;

import java.time.LocalDate;
import tarjetas.TarjetaCredito;
import usuarios.Cliente;

import java.time.LocalDate;

public class SolicitudTarjetaC {
    Cliente cliente;
    private LocalDate fechaSolicitud;
    private TipoTarjetaCredito  tipoTarjeta;
    private String status;
    int idCliente;
    public SolicitudTarjetaC(Cliente cliente, TipoTarjetaCredito tipo){
        this.cliente=cliente;
        status= "En espera";
        tipoTarjeta=tipo;
        idCliente=cliente.getId();
    }
    
    public void aprobarTarjeta(){
        status="Solicitud Aprobada";
        TarjetaCredito tarjetaCredito=new TarjetaCredito(5579,tipoTarjeta);
        cliente.getTarjetasCredito().add(tarjetaCredito);

    }
    public void rechazarTarjeta(){
        status="Solicitud Rechazada";
    }

    public String toString(){
        return String.format("Cliente solicitante: %s ,Fecha de solicitud: %s , Tipo de tarjeta: %s",cliente,fechaSolicitud,tipoTarjeta);
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