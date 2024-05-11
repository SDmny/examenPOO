package usuarios;

import usuarios.utils.Sucursal;
import tarjetas.TarjetaCredito;
import tarjetas.TarjetaDebito;
import usuarios.utils.Gente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cliente extends Usuario {
    private int id;
    private LocalDate fechaRegistro;
    private TarjetaDebito tarjetaDebito;
    private ArrayList<TarjetaCredito> tarjetasCredito;
    public Cliente(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curb, String direccion, Sucursal sucursal, TarjetaDebito tarjeta, Gente rol, String usuario, String contrasena, LocalDate birth) {
        super(nombre, apellido1, apellido2, sexo, ciudad, estado, curb, direccion, sucursal, Gente.CLIENTE, usuario, contrasena,birth);
        this.tarjetaDebito=tarjetaDebito;
    }

    private int generarIdUnico() {
        return 0; 
    }

    @Override
    public String toString() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String fechaFormateada = fechaRegistro.format(pattern);
        return String.format("ID: %d, %s, Fecha de registro: %s", id, super.toString(), fechaFormateada);
    }

    public void solicitarTarjetaCredito(double credito) {
        int clave = generarIdUnico(); 
        TarjetaCredito nuevaTarjeta = new TarjetaCredito(clave, credito);
        tarjetasCredito.add(nuevaTarjeta);
    }
    
    public void verEstatusSolicitud() {
        if (!tarjetasCredito.isEmpty()) {
            TarjetaCredito ultimaTarjeta = tarjetasCredito.get(tarjetasCredito.size() - 1);
            System.out.println("Estado de la solicitud: " + ultimaTarjeta.getTipoCredito());
        } else {
            System.out.println("No hay solicitudes de tarjeta de crédito.");
        }
    }
    
    public void verTarjetas() {
        System.out.println("Tarjeta de Débito:");
        System.out.println(tarjetaDebito);
    
        System.out.println("Tarjetas de Crédito:");
        for (TarjetaCredito tarjeta : tarjetasCredito) {
            System.out.println(tarjeta);
        }
    }
    

    public void realizarCompra(String numeroTarjeta, double monto) {
        for (TarjetaCredito tarjeta : tarjetasCredito) {
            if (tarjeta.getNumeroTarjeta().equals(numeroTarjeta)) {
                tarjeta.comprar(monto);
                System.out.println("Compra realizada con éxito.");
                return;
            }
        }
        System.out.println("No se encontró la tarjeta de crédito especificada.");
    }
    

    public void pagarTarjeta(String numeroTarjeta, double deposito) {
        for (TarjetaCredito tarjeta : tarjetasCredito) {
            if (tarjeta.getNumeroTarjeta().equals(numeroTarjeta)) {
                tarjeta.pagarTarjeta(deposito);
                System.out.println("Pago realizado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró la tarjeta de crédito especificada.");
    }
    

    public static void crearCliente() {
    }
    
    public static void editarCliente() {
    }

    public static void borrarCliente() {
    }
    

    public static void buscarCliente() {
    }
}