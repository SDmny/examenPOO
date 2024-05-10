package Tarjetas;

import Tarjetas.utils.TipoTarjetaCredito;

public class TarjetaCredito extends Tarjeta {
    private TipoTarjetaCredito tipoCredito;
    private double creditoMaximo;
    private double creditoActual;

    public TarjetaCredito(int clave, double credito) {
        super(clave);
        this.tipoCredito = tipoTarjeta(credito);
        this.creditoMaximo = credito;
        this.creditoActual = credito;
    }

    private TipoTarjetaCredito tipoTarjeta(double credito) {
        TipoTarjetaCredito type = null;
        if (credito == 60000) type = TipoTarjetaCredito.SIMPLICITY;
        if (credito == 150000) type = TipoTarjetaCredito.PLATINO;
        if (credito == 400000) type = TipoTarjetaCredito.ORO;
        return type;
    }

    @Override
    public String toString() {
        String tipoDeTarjeta = "" + tipoCredito;
        return String.format("%s\nCrédito Máximo: %.2f\nTipo de Tarjeta: %s", super.toString(), creditoMaximo, tipoDeTarjeta);
    }

    private void pagarTarjeta(double deposito) {
        this.creditoActual += deposito;
    }

    private void comprar(double monto) {
        this.creditoActual -= monto;
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
}
