package tarjetas;

import java.time.LocalDateTime;

import usuarios.utils.DatosComun;

public class TarjetaDebito extends Tarjeta {
        private double saldo;
    
        public TarjetaDebito(int clave) {
            super(clave);
            this.saldo = 0;
        }
    
        private void depositar(double deposito) {
            this.saldo += deposito;
        }
    
        private void retirar(double retiro) {
            this.saldo -= retiro;
        }
    
        public double getSaldo() {
            return saldo;
        }
    
        private boolean simplicity(double saldo) {
            if (saldo >= 60000) return true;
            return false;
        }
    
        private boolean platino(double saldo) {
            if (saldo >= 150000) return true;
            return false;
        }
    
        private boolean oro(double saldo) {
            if (saldo >= 400000) return true;
            return false;
        }

        public void depositoDebito() {
        boolean flag = true;
        double deposito;
        do {
            System.out.println("\nIngrese el monto a depositar:");
            deposito = DatosComun.pedirValorDouble();
            if (deposito > 0) {
                System.out.println("Realizando depósito...");
                saldo += deposito;
                setFechaHoraUltimoMov(LocalDateTime.now());
                System.out.println("Depósito realizado con éxito.");
                System.out.println("Saldo actual: "+saldo);
                flag = false;
            }
            if (deposito < 0) {
                System.out.println("Error. El monto no puede ser menor a 0");
            }else if(deposito == 0) {
                System.out.println("Cancelando operación...");
                flag = false;
            }
        }while(flag);
    }

    public void retirarDebito() {
        boolean flag = true;
        double retiro;
        do {
            System.out.println("\nSaldo Disponible: "+ saldo);
            System.out.println("Ingresa el monto:");
            retiro = DatosComun.pedirValorDouble();
            if (retiro <= saldo) {
                System.out.println("Realizando retiro...");
                saldo -= retiro;
                setFechaHoraUltimoMov(LocalDateTime.now());
                System.out.println("Retiro realizado con éxito");
                System.out.println("Saldo actual: "+saldo);
                flag = false;
            } else if (retiro > saldo) {
                System.out.println("Error. Fondos insuficientes. Intenta de nuevo");
            } else if (retiro == 0) {
                System.out.println("Cancelando la operación...");
                flag = false;
            }
        }while(flag);
    }
    
}
