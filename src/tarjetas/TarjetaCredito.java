package tarjetas;

import tarjetas.utils.TipoTarjetaCredito;
import usuarios.utils.DatosComun;

public class TarjetaCredito extends Tarjeta {
    private TipoTarjetaCredito tipoCredito;
    private double creditoMaximo;
    private double creditoActual;
    private double saldoPendiente;

    public TarjetaCredito(int clave, double credito) {
        super(clave);
        this.tipoCredito = tipoTarjeta(credito);
        this.creditoMaximo = credito;
        this.creditoActual = credito;
        this.saldoPendiente=0;
    }

    private TipoTarjetaCredito tipoTarjeta(double credito) {
        TipoTarjetaCredito type = null;
        if (credito == 60000) type = TipoTarjetaCredito.SIMPLICITY;
        if (credito == 150000) type = TipoTarjetaCredito.PLATINO;
        if (credito == 400000) type = TipoTarjetaCredito.ORO;
        return type;
    }
    // solo copia de lo perdido en versiones
    public static int asignarCreditoMaximo(TipoTarjetaCredito tipo){
        int cantidad=0;
        if(tipo == TipoTarjetaCredito.SIMPLICITY){
            cantidad=60000;
        }
        if(tipo==TipoTarjetaCredito.PLATINO){
            cantidad=150000;
        }
        else{
            cantidad=400000;
        }
        return cantidad;
    }
    @Override
    public String toString() {
        String tipoDeTarjeta = "" + tipoCredito;
        return String.format("%s\nCrédito Máximo: %.2f\nTipo de Tarjeta: %s", super.toString(), creditoMaximo, tipoDeTarjeta);
    }

    public void pagarTarjeta() {
        boolean flag = true;
        double pago;
        do {
            System.out.println("\nIngrese el depósito de la Tarjeta:");
            System.out.println("Saldo Pendiente: "+saldoPendiente);
            pago = DatosComun.pedirValorDouble();
            if (pago <= saldoPendiente) {
                System.out.println("Realizando pago...");
                saldoPendiente -= pago;
                System.out.println("Actualizando saldo y crédito disponible...");
                creditoActual += pago;
                System.out.println("Pago realizado.");
                flag = false;
            }
            if (pago > saldoPendiente) {
                System.out.println("Error. No puedes ingresar un monto mayor a la deuda actual.");
            }
            if (pago == 0) {
                System.out.println("Cancelando la operación...");
                flag = false;
            }
        } while(flag);
    }

    public void comprarCredito() {
        boolean flag = true;
        double importe;
        do {
            System.out.println("Saldo Disponible: "+creditoActual);
            System.out.println("\nIngrese el monto de la compra a crédito:");
            importe = DatosComun.pedirValorDouble();
            if (importe <= creditoActual) {
                System.out.println("Realizando pago ");
                creditoActual -= importe;
                System.out.println("Actualizando saldo y crédito ");
                saldoPendiente += importe;
                System.out.println("Compra a crédito realizada.");
                flag = false;
            }
            if (importe > creditoActual) {
                System.out.println("No se puede realizar la compra. Límite de crédito alcanzado. Intenta de nuevo.");
            }
            if (importe == 0) {
                System.out.println("Cancelando la compra.");
                flag = false;
            }
        } while(flag);
    }

    public TipoTarjetaCredito getTipoCredito() {
        return tipoCredito;
    }

    public double getCreditoMaximo() {
        return creditoMaximo;
    }

    public double getCreditoActual() {
        return creditoActual;
    }
    public double getSaldoPendiente() {
        return saldoPendiente;
    }
}
