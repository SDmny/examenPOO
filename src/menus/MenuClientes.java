package menus;

import sistema.Sistema;
import tarjetas.Tarjeta;
import tarjetas.utils.SolicitudTarjetaC;
import tarjetas.utils.TipoTarjetaCredito;
import usuarios.Cliente;
import utils.UsuarioEnSesion;

import java.util.Scanner;

public class MenuClientes {
    static Scanner scanner = new Scanner(System.in);
    public static void menuCliente(){
        String action;
        do {
            // metodo para saber si mostrar o no la opcion de solicitud de tarjeta
            if (verificarOpcionSolicitud()){
                System.out.println("1 - Solicitar tarjeta");
            }
            System.out.println("2 - Depositar");
            System.out.println("3 - Retirar");
            System.out.println("0 - Salir");
            System.out.print("Selección: ");
            action = scanner.next();
            switch (action){
                case "1":
                    if (verificarOpcionSolicitud()){
                        // metodo de solicitar tarjeta
                        verificarTarjetasActuales();
                    }
                    break;
                case "2":
                    depositar(mostrarTarjetas());
                    break;
                case "3":
                    retirar(mostrarTarjetas());
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opcion inexistente");
            }
        } while (!action.equals("0"));
    }
    private static Tarjeta mostrarTarjetas(){
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        Tarjeta tarjeta = cliente.getTarjetaDebito();
        String action="0";
        System.out.println("Elegir tarjeta: \n1 - Debito");
        try{
            if (cliente.getTarjetasCredito().size()>0){
                for (int i = 0; i < cliente.getTarjetasCredito().size(); i++) {
                    System.out.println((i+2) + " - Tarjeta "+cliente.getTarjetasCredito().get(i));
                }
            }
            action = scanner.next();
        } catch (Exception e){

        }
        switch (action){
            case "1": tarjeta = cliente.getTarjetaDebito();
                break;
            case "2": tarjeta = cliente.getTarjetasCredito().get(0);
                break;
            case "3": tarjeta = cliente.getTarjetasCredito().get(1);
                break;
            case "4": tarjeta = cliente.getTarjetasCredito().get(2);
                break;
            default:
        }
        return tarjeta;

    }
    private static void depositar(Tarjeta tarjeta){
        if (tarjeta.getClave() == 1234){
            Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
            cliente.getTarjetaDebito().depositoDebito();
        } else if (tarjeta.getClave() == 5579) {
            Cliente.realizarPagoCredito((Cliente)UsuarioEnSesion.getInstancia().getUsuarioActual());
        }
    }
    private static void retirar(Tarjeta tarjeta){
        if (tarjeta.getClave() == 1234){
            Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
            cliente.getTarjetaDebito().retirarDebito();
        } else if (tarjeta.getClave() == 5579) {
            Cliente.realizarCompraCredito((Cliente)UsuarioEnSesion.getInstancia().getUsuarioActual());
        }
    }
    private static boolean verificarOpcionSolicitud(){
        boolean mostrar = false;
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        if (Cliente.solicitudTarjetaCredito(cliente) && cliente.getTarjetaDebito().getSaldo()>=50000){
            mostrar = true;
        }
        return mostrar;
    }
    private static void solicitarTarjeta(boolean oro, boolean pla, boolean sim){
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        System.out.println("Solicitar tarjeta de credito");
        if (cliente.getTarjetaDebito().getSaldo() >= 200000 && oro){
            // solicitar oro
            System.out.println("O - Oro");

        }
        if (cliente.getTarjetaDebito().getSaldo() >= 100000 && pla) {
            // solicitar platinum
            System.out.println("P - Platinum");

        }
        if (cliente.getTarjetaDebito().getSaldo() >= 50000 && sim){
            // solicitar simplicity
            System.out.println("S - Simplicity");

        }
        SolicitudTarjetaC solicitud;
        System.out.println("Solicitar: ");
        String tarjeta = scanner.next();
        switch (tarjeta){
            case "O":
                if (cliente.getTarjetaDebito().getSaldo() >= 200000 && oro){
                    solicitud = new SolicitudTarjetaC(cliente, TipoTarjetaCredito.ORO);
                    Sistema.solicitudes.add(solicitud);
                    System.out.println("Solicitud realizada");
                }
                break;
            case "P":
                if (cliente.getTarjetaDebito().getSaldo() >= 100000 && pla) {
                    solicitud = new SolicitudTarjetaC(cliente, TipoTarjetaCredito.PLATINO);
                    Sistema.solicitudes.add(solicitud);
                    System.out.println("Solicitud realizada");
                }
                break;
            case "S":
                if (cliente.getTarjetaDebito().getSaldo() >= 50000 && sim){
                    solicitud = new SolicitudTarjetaC(cliente, TipoTarjetaCredito.SIMPLICITY);
                    Sistema.solicitudes.add(solicitud);
                    System.out.println("Solicitud realizada");
                }
                break;
            default:
        }

    }
    private static void verificarTarjetasActuales(){
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        boolean oro=true, pla=true, sim=true;
        for (int i=0; i<cliente.getTarjetasCredito().size(); i++){
            if (cliente.getTarjetasCredito().get(i).getTipoCredito() == TipoTarjetaCredito.ORO){
                oro = false;
            }
            else if (cliente.getTarjetasCredito().get(i).getTipoCredito() == TipoTarjetaCredito.PLATINO){
                pla = false;
            }
            else if (cliente.getTarjetasCredito().get(i).getTipoCredito() == TipoTarjetaCredito.SIMPLICITY){
                sim = false;
            }
        }
        solicitarTarjeta(oro, pla, sim);
    }

}