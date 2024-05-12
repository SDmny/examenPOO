package usuarios;

import sistema.Sistema;
import usuarios.utils.Sucursal;
import tarjetas.TarjetaCredito;
import tarjetas.TarjetaDebito;
import usuarios.utils.Gente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import usuarios.Usuario;
import tarjetas.utils.Generar;
import tarjetas.utils.SolicitudTarjetaC;
import tarjetas.utils.TipoTarjetaCredito;
import usuarios.utils.DatosComun;
import utils.UsuarioEnSesion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Cliente extends Usuario {
    private static int num = 1;
    private int id;
    private LocalDate fechaRegistro;
    private TarjetaDebito tarjetaDebito;
    private int numeroSolicitudesEnProceso;
    private ArrayList<TarjetaCredito> tarjetasCredito=new ArrayList<>();
    //No me aclaro de qué pedir :´)

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, char sexo, Sucursal sucursal, String ciudad, String estado, String curp, String direccion, int anioNacimiento, LocalDate fechaNacimiento, String RFC, String nombreUsuario, String contrasena, LocalDate birth){
            super(nombre, apellidoPaterno, apellidoMaterno, sexo, ciudad, estado, curp, direccion, sucursal, Gente.CLIENTE, nombreUsuario, contrasena, birth);
            fechaRegistro = LocalDate.now();
            id = num;
            num++;
            tarjetaDebito = new TarjetaDebito(1234);
    }
    public ArrayList<TarjetaCredito> getTarjetasCredito() {
        return tarjetasCredito;
    }


//        public static void realizarCompra () {
//
//        }
//        public static void pagarTarjeta () {
//
//        }
        //Método para objetos precargados del sistema.
        /*public void realizarDeposito(double monto){
            tarjetaDebito.depositar(monto);
        }*/
        //Método para depósitos ingresados por el Usuario en Sesión.
        /*public void depositarDebito() {
            tarjetaDebito.depositoDebito();
        }*/

        /*public void retirarDebito(TarjetaDebito tarjeta) {
            tarjetaDebito.retirar(tarjeta);
        }*/

        
    public static void buscarCliente(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el ID del cliente");
        int id = DatosComun.pedirNumeroInt();
        boolean existe=false;
        if (!Sistema.usuarios.containsKey(Gente.INVERSIONISTA)) {
            System.out.println("No hay inversionistas registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.INVERSIONISTA)) {
                if (usuario.getId() == id) {
                    Cliente cliente = (Cliente) usuario;
                    System.out.println(cliente.toString());
                    existe = true;
                }
            }
            if (!existe) {
                System.out.println("No se encontro este Cliente");
            }
        }
    }
    public int getId() {
        return id;
    }

    public int getNumeroSolicitudesEnProceso() {
        return numeroSolicitudesEnProceso;
    }

    public void setNumeroSolicitudesEnProceso(int numeroSolicitudesEnProceso) {
        this.numeroSolicitudesEnProceso = numeroSolicitudesEnProceso;
    }

    public static void consultarCuentaDebito(TarjetaDebito tarjetaDebito) {
        System.out.println("Saldo de la cuenta: " + tarjetaDebito.getSaldo());
        System.out.println(tarjetaDebito.toString());//Obtener el resto de los datos de la tarjeta
    }

    public static void consultarCuentasCredito(Cliente cliente) {
        int card = 1;
        if(cliente.getTarjetasCredito()!=null) {
            for(TarjetaCredito tarjetaCredito: cliente.getTarjetasCredito()){
                System.out.printf("\n%d) %s\n", card, tarjetaCredito.toString());
                card++;
            }
        }
        if(cliente.getTarjetasCredito()==null) System.out.println("No tienes tarjetas de crédito.");
    }

    public static void solicitudTarjetaCredito(Cliente cliente) {
        System.out.println("\tBienvenido\n");
        if (cliente.getTarjetasCredito().size()<3) {//Validación de la cantidad de tarjetas del cliente antes de realizar solicitud.
            if(cliente.getNumeroSolicitudesEnProceso()==0) Cliente.solicitarTarjetaCredito(cliente);
            if(cliente.getNumeroSolicitudesEnProceso()==1) System.out.println("Ya tienes una solicitud en curso. Debes esperar a que termine el proceso para poder hacer una nueva solicitud.");
        }
        if (cliente.getTarjetasCredito().size()==3) System.out.println("No puedes solicitar más tarjetas. Límite máximo alcanzado.");
    }

    public static void revisarStatusSolicitud(Cliente cliente) {
        System.out.println("Solicitud en curso:");
        boolean solicitudEncontrada = false;
        List<SolicitudTarjetaC> solicitudAEliminar = new ArrayList<>();
        for(SolicitudTarjetaC solicitud : Banco.solicitudes) {
            if (solicitud.getCliente() == cliente){
                solicitudEncontrada = true;
                System.out.println("Tarjeta solicitada: "+ solicitud.getTipoTarjeta());
                System.out.println("Status: "+solicitud.getStatus());
                if(solicitud.getStatus().equals("Solicitud Aprobada")||solicitud.getStatus().equals("Solicitud Rechazada")){//Revisión del status
                    System.out.println("Eliminando solicitud del historial...");
                    cliente.setNumeroSolicitudesEnProceso(0);//Una vez que el cliente consulte el estatus, si la solicitud ya fue atendida, su contador pasa a 0.
                    solicitudAEliminar.add(solicitud);//Añade la solicitud para luego eliminarla de la lista del Banco.
                }
            }
        }
        Banco.solicitudes.removeAll(solicitudAEliminar);//Una vez consultada y atendida la solicitud, se elimina del Banco.
        if(!solicitudEncontrada) System.out.println("No tienes solicitudes pendientes.");
    }

    public static void realizarCompraCredito(Cliente cliente) {
        int i=1,seleccion,contadorTarjetas=0;//Contador i para las opciones
        boolean select = true;
        if (cliente.getTarjetasCredito()!=null) {
            System.out.println("\tSelecciona la tarjeta a usar");
            System.out.println("\nTarjetas de Crédito Disponibles");
            for(TarjetaCredito tarjetaCredito:cliente.getTarjetasCredito()) {
                if (tarjetaCredito.getSaldoPendiente() > 0) {
                    System.out.printf("\n%d) Tarjeta %s\n", i, tarjetaCredito.getTipoCredito());
                    System.out.printf("Crédito Máximo: %f\n", tarjetaCredito.getCreditoMaximo());
                    i++;
                }//Este contador permite registrar cuántas tarjetas están sin saldo pendiente.
                if (tarjetaCredito.getSaldoPendiente() == 0) {
                    contadorTarjetas++;
                }
            }
            if (contadorTarjetas<cliente.getTarjetasCredito().size()) {
                do {
                    seleccion = DatosComun.pedirNumeroInt();
                    if (seleccion<1||seleccion>i) {
                        System.out.println("Error. Selecciona una opción válida");
                    }else {
                        seleccion-=1;
                        TarjetaCredito tarjeta = cliente.getTarjetasCredito().get(seleccion);
                        tarjeta.comprarCredito();
                        select = false;
                    }
                } while (select);
            }
            if (contadorTarjetas==cliente.getTarjetasCredito().size()) {
                System.out.println("\nNo tienes tarjetas de crédito disponibles");
            }
        }
        if (cliente.getTarjetasCredito()==null) System.out.println("\nNo tienes tarjetas de crédito");
    }

    public static void realizarPagoCredito(Cliente cliente) {
        int k=1,opcionPago,contadorTc=0;//Contador i para las opciones
        boolean pagoValido = true;
        if (cliente.getTarjetasCredito()!=null) {
            System.out.println("\tSelecciona la tarjeta a pagar");
            System.out.println("\nTarjetas de Crédito");
            for(TarjetaCredito tarjetaCredito:cliente.getTarjetasCredito()) {
                if (tarjetaCredito.getSaldoPendiente() > 0) {
                    System.out.printf("\n%d) Tarjeta %s\n", k, tarjetaCredito.getTipoCredito());
                    System.out.printf("Saldo pendiente por pagar: %f", tarjetaCredito.getSaldoPendiente());
                    k++;
                }//Este contador permite registrar cuántas tarjetas están sin saldo pendiente.
                if (tarjetaCredito.getSaldoPendiente() == 0) {
                    contadorTc++;
                }
            }
            if (contadorTc<cliente.getTarjetasCredito().size()) {
                do {
                    opcionPago = DatosComun.pedirNumeroInt();
                    if (opcionPago<1||opcionPago>k) {
                        System.out.println("Error. Selecciona una opción válida");
                    }else {
                        opcionPago-=1;
                        TarjetaCredito tarjeta = cliente.getTarjetasCredito().get(opcionPago);
                        tarjeta.pagarTarjeta();
                        pagoValido = false;
                    }
                } while (pagoValido);
            }//Si no hay tarjetas pendientes de pago, se arroja el siguiente mensaje
            if (contadorTc==cliente.getTarjetasCredito().size()) {
                System.out.println("\nNo tienes tarjetas pendientes de pago");
            }
        }
        if (cliente.getTarjetasCredito()==null) System.out.println("\nNo tienes tarjetas de crédito");
    }
    @Override
    public String toString () {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String fechaFormateada = fechaRegistro.format(pattern);
        return String.format("ID: %d, %s Fecha registro %s ", id, super.toString(), fechaFormateada);
    }
    //json no depende del lenguaje
    public TarjetaDebito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public static void solicitarTarjetaCredito (Cliente cliente) {
        int opciones=0,opcion;
        boolean band = true;
        SolicitudTarjetaC solicitud;
        TarjetaDebito tarjetaDebito = cliente.getTarjetaDebito();
        if(tarjetaDebito.simplicity(tarjetaDebito.getSaldo())) {
            opciones=1;
            if(tarjetaDebito.platino(tarjetaDebito.getSaldo())) {
                opciones=2;
                if(tarjetaDebito.oro(tarjetaDebito.getSaldo())) {
                    opciones=3;
                }
            }
        }
        switch(opciones) {
            case 1:
                do{
                    System.out.println("Puedes seleccionar el tipo Simplicity");
                    System.out.println("1.Solicitar\n2. Salir");
                    opcion=DatosComun.pedirNumeroInt();
                    if(opcion==1) {
                        solicitud = new SolicitudTarjetaC(cliente, TipoTarjetaCredito.SIMPLICITY);
                        solicitudes.add(solicitud);
                        cliente.setNumeroSolicitudesEnProceso(1);
                        System.out.println("Solicitud de tarjeta Simplicity realizada");
                        band=false;
                    }else System.out.println("Opción no válida");
                } while(band);
                break;
            case 2:
                do{
                    System.out.println("Seleccione el tipo de tarjeta: ");
                    System.out.println("1. Simplicity\n2. Platino");
                    opcion = DatosComun.pedirNumeroInt();
                    switch (opcion) {
                        case 1:
                            solicitud = new SolicitudTarjetaC(cliente, TipoTarjetaCredito.SIMPLICITY);
                            solicitudes.add(solicitud);
                            cliente.setNumeroSolicitudesEnProceso(1);
                            System.out.println("Solicitud de tarjeta Simplicity realizada");
                            band=false;
                            break;
                        case 2:
                            solicitud = new SolicitudTarjetaC(cliente, TipoTarjetaCredito.PLATINO);
                                solicitudes.add(solicitud);
                            cliente.setNumeroSolicitudesEnProceso(1);
                            System.out.println("Solicitud de tarjeta Platino realizada");
                            band=false;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                } while(band);
                break;
            case 3:
                do{
                    System.out.println("Seleccione el tipo de tarjeta: ");
                    System.out.println("1. Simplicity\n2. Platino\n3. Oro");
                    opcion = DatosComun.pedirNumeroInt();
                    switch (opcion) {
                        case 1:
                            solicitud = new SolicitudTarjetaC(cliente, TipoTarjetaCredito.SIMPLICITY);
                                    solicitudes.add(solicitud);
                            cliente.setNumeroSolicitudesEnProceso(1);
                            System.out.println("Solicitud de tarjeta Simplicity realizada");
                            band=false;
                            break;
                        case 2:
                            solicitud = new SolicitudTarjetaC(cliente, TipoTarjetaCredito.PLATINO);
                                    solicitudes.add(solicitud);
                            cliente.setNumeroSolicitudesEnProceso(1);
                            System.out.println("Solicitud de tarjeta Platino realizada");
                            band=false;
                            break;
                        case 3:
                            solicitud = new SolicitudTarjetaC(cliente, TipoTarjetaCredito.ORO);
                                    solicitudes.add(solicitud);
                            cliente.setNumeroSolicitudesEnProceso(1);
                            System.out.println("Solicitud de tarjeta Oro realizada");
                            band=false;
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                } while(band);
                break;
            default:
                System.out.println("No tienes ofertas disponibles.");
                break;
        }
    }
    public void verTodasLasTarjetas() {
        System.out.println("Tarjeta de debito: ");
        System.out.println(tarjetaDebito.toString());
        System.out.println("Tarjetas de credito: ");
        tarjetasCredito.forEach(tarjetaCredito -> System.out.println(tarjetaCredito.toString()));
    }
}