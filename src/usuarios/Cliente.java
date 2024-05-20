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
    private LocalDate fechaRegistro;
    private TarjetaDebito tarjetaDebito;
    private int numeroSolicitudesEnProceso;
    private ArrayList<TarjetaCredito> tarjetasCredito=new ArrayList<>();
    private boolean eliminar=true;

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, char sexo, Sucursal sucursal, String ciudad, String estado, String curp, String direccion, String RFC, String nombreUsuario, String contrasena, LocalDate birth){
            super(nombre, apellidoPaterno, apellidoMaterno, sexo, ciudad, estado, curp, direccion, sucursal, Gente.CLIENTE, nombreUsuario, contrasena, birth);
            fechaRegistro = LocalDate.now();
            tarjetaDebito = new TarjetaDebito(1234);
    }
    public ArrayList<TarjetaCredito> getTarjetasCredito() {
        return tarjetasCredito;
    }

        
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

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
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

    public static boolean solicitudTarjetaCredito(Cliente cliente) {
        boolean permiso = true;
        if (cliente.getTarjetasCredito().size()<3) {
            if(cliente.getNumeroSolicitudesEnProceso()==1){
                permiso = false;
            }
        }
        if (cliente.getTarjetasCredito().size()==3){
            System.out.println("No puedes solicitar más tarjetas. Límite máximo alcanzado.");
            permiso = false;
        }
        return permiso;
    }

    public static void revisarStatusSolicitud(Cliente cliente) {
        System.out.println("Solicitud en curso:");
        boolean solicitudEncontrada = false;
        List<SolicitudTarjetaC> solicitudAEliminar = new ArrayList<>();
        for(SolicitudTarjetaC solicitud : Sistema.solicitudes) {
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
        Sistema.solicitudes.removeAll(solicitudAEliminar);//Una vez consultada y atendida la solicitud, se elimina del Banco.
        if(!solicitudEncontrada) System.out.println("No tienes solicitudes pendientes.");
    }




    public static void realizarCompraCredito(Cliente cliente) {
        int i=1,seleccion,contadorTarjetas=0;//Contador i para las opciones
        boolean select = true;
        if (cliente.getTarjetasCredito()!=null) {
            System.out.println("\tSelecciona la tarjeta a usar");
            System.out.println("\nTarjetas de Crédito Disponibles");
            for(TarjetaCredito tarjetaCredito:cliente.getTarjetasCredito()) {
                if (tarjetaCredito.getCreditoActual() > 0) {
                    System.out.printf("\n%d) Tarjeta %s\n", i, tarjetaCredito.getTipoCredito());
                    System.out.printf("Crédito Máximo: %f\n", tarjetaCredito.getCreditoMaximo());
                    i++;
                }//Este contador permite registrar cuántas tarjetas están sin saldo pendiente.
                if (tarjetaCredito.getCreditoActual() == 0) {
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
                if (tarjetaCredito.getCreditoActual() > 0) {
                    System.out.printf("\n%d) Tarjeta %s\n", k, tarjetaCredito.getTipoCredito());
                    System.out.printf("Saldo pendiente por pagar: %f", tarjetaCredito.getCreditoActual());
                    k++;
                }//Este contador permite registrar cuántas tarjetas están sin saldo pendiente.
                if (tarjetaCredito.getCreditoActual() == 0) {
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
        return String.format("%s Fecha registro %s ", super.toString(), fechaFormateada);
    }
    
    public TarjetaDebito getTarjetaDebito() {
        return tarjetaDebito;
    }


    public void verTodasLasTarjetas() {
        System.out.println("Tarjeta de debito: ");
        System.out.println(tarjetaDebito.toString());
        System.out.println("Tarjetas de credito: ");
        tarjetasCredito.forEach(tarjetaCredito -> System.out.println(tarjetaCredito.toString()));
    }


    //METODOS CLIENTES
    public static void registrarCliente() {
        System.out.println("- - - Registrar Cliente - - -");
        ArrayList<String> datosComun = DatosComun.obtenerDatos();
        String nombre = datosComun.get(0);
        String apellido1 = datosComun.get(1);
        String apellido2 = datosComun.get(2);
        char sexo = datosComun.get(3).charAt(0);
        String ciudad = datosComun.get(4);
        String estado = datosComun.get(5);
        String curp = datosComun.get(6);
        String direccion = datosComun.get(7);
        String usuario = datosComun.get(8);
        String contrasena = datosComun.get(9);
        LocalDate birth = LocalDate.parse(datosComun.get(10));
        Cliente cliente = new Cliente(nombre, apellido1, apellido2, sexo, UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal(), ciudad, estado, curp, direccion, DatosComun.generarRFC(nombre, apellido1, apellido2, birth), usuario, contrasena, birth);
        if (!Sistema.usuarios.containsKey(Gente.CLIENTE)) {
            Sistema.usuarios.put(Gente.CLIENTE, new ArrayList<>());
        }
        Sistema.usuarios.get(Gente.CLIENTE).add(cliente);
        System.out.println("Cliente registrado");
    }

    public static void eliminarClientes(int id) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.CLIENTE)) {
            System.out.println("No hay clientes registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.CLIENTE)) {
                Cliente cliente = (Cliente) usuario;
                if (usuario.getId() == id && cliente.eliminar == true) {
                    existe = true;
                    Sistema.usuarios.get(Gente.CLIENTE).remove(usuario);
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Cliente no existe");
            }
        }

    }

    public static void mostrarCliente(String user) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.CLIENTE)) {
            System.out.println("No hay clientes registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.CLIENTE)) {
                if (usuario.getUsuario().equals(user)) {
                    existe = true;
                    System.out.println(usuario.toString());
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Cliente no existe");
            }
        }
    }

    public static void modificarCliente(int id) {
        boolean existe = false;
        if (!Sistema.usuarios.containsKey(Gente.CLIENTE)) {
            System.out.println("No hay clientes registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.CLIENTE)) {
                if (usuario.getId() == id) {
                    existe = true;
                    usuario.ModificarDato();
                    break;

                }
            }
            if (!existe) {
                System.out.println("El Cliente no existe");
            }
        }
    }

    public static void mostrarClientes() {
        if (!Sistema.usuarios.containsKey(Gente.CLIENTE)) {
            System.out.println("No hay clientes registrados:\n");
        } else {
            for (Usuario usuario : Sistema.usuarios.get(Gente.CLIENTE)) {
                System.out.println(usuario);
            }
        }
    }
}

