package usuarios;

import usuarios.utils.DatosComun;
import usuarios.utils.Sucursal;
import usuarios.utils.Gente;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public abstract class Usuario {
    Random ran = new Random();
    String nombre, apellido1, apellido2, ciudad, estado, rfc, curp, direccion, homoclave, usuario, contrasena, dateBirth;
    char sexo;
    boolean repetida = true;
    LocalDate birth, register;
    Sucursal sucursal;
    Gente rol;
    int id;
    static int cantidadUsuarios;

    //Crear metodo para hacer nulo el segundo apellido sí no tiene (apellido2)
    public Usuario(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curp, String direccion, Sucursal sucursal, Gente rol, String usuario, String contrasena, LocalDate birth) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.estado = estado;
        this.curp = curp;
        this.direccion = direccion;
        this.sucursal = sucursal;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.id = cantidadUsuarios;
        this.birth = birth;
        cantidadUsuarios++;
        this.register = LocalDate.now();
        rfc = apellido1.substring(0, 2);
        if (!apellido2.isEmpty()) {
            rfc = rfc + apellido2.charAt(0) + nombre.charAt(0);
        } else {
            rfc = rfc + nombre.substring(0, 2);
        }

        dateBirth = "" + birth.getYear();
        rfc = rfc + dateBirth.substring(2, 4);
        if (birth.getMonthValue() < 10) {
            rfc = rfc + 0;
        }
        dateBirth = "" + birth.getMonthValue();
        rfc = rfc + dateBirth;
        if (birth.getDayOfMonth() < 10) {
            rfc = rfc + 0;
        }
        dateBirth = "" + birth.getDayOfMonth();
        rfc = rfc + dateBirth;
        homoclave = Homoclave();

        while (repetida) {
            repetida = DatosComun.rfcRepetida(rfc, homoclave);
            if (repetida) {
                homoclave = Homoclave();
            }
        }
        rfc = rfc + homoclave;
        rfc = rfc.toUpperCase();

    }

    //Homoclave para RFC
    private String Homoclave() {
        String homo = "";
        int clave, hom = 65;
        for (int i = 0; i < 2; i++) {

            hom = ran.nextInt(2) + 1;
            if (hom == 1) {
                hom = ran.nextInt(26) + 65;
                homo = homo.concat(Character.toString((char) hom));
            } else {
                clave = ran.nextInt(10);
                homo = homo.concat(String.valueOf(clave));
            }


        }
        return homo;
    }

    public void ModificarDato() {
        String opc = null;
        do {
            String dato = DatosComun.ModificarDatoUsuario();
            int op;
            if (!dato.equals("0")) {
                op = Integer.parseInt(dato.substring(dato.length() - 1));
                dato = dato.substring(0, dato.length() - 1);
            } else {
                op = 0;
            }
            switch (op) {
                case 1:
                    nombre = dato;
                    break;
                case 2:
                    apellido1 = dato;
                    break;
                case 3:
                    apellido2 = dato;
                    break;
                case 4:
                    sexo = dato.charAt(0);
                    break;
                case 5:
                    ciudad = dato;
                    break;
                case 6:
                    estado = dato;
                    break;
                case 7:
                    direccion = dato;
                    break;
                case 8:
                    usuario = dato;
                    break;
                case 9:
                    contrasena = dato;
                    break;
                case 10:
                    birth = LocalDate.parse(dato);
                    break;
                case 0:
                    break;
            }
            System.out.println("Ingrese 0 para dejar de modificar");
            try {
                opc = DatosComun.scanner.nextLine();
            } catch (Exception ew) {
                opc = "4";
                DatosComun.scanner.next();

            }
        }
        while (!Objects.equals(opc, "0"));
        curp = DatosComun.generarCURP(nombre, apellido1, apellido2, birth, sexo, estado);
//Poner el metodo para cambiar RFC*******
    }


    // Metodo para imprimir datos basicos
    @Override
    public String toString() {
        String cadena = String.format("Id: %d; Nombre completo: %s %s %s; Rol: %s; Nombre de usuario: %s,\nCURP: %s, RFC: %s,\n Dirección: %s ", id, nombre, apellido1, apellido2, rol, usuario,curp,rfc,direccion);
        return cadena;
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getHomoclave() {
        return homoclave;
    }

    public void setHomoclave(String homoclave) {
        this.homoclave = homoclave;
    }

    public String getCurb() {
        return curp;
    }

    public void setCurb(String curb) {
        this.curp = curp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Gente getRol() {
        return rol;
    }

    public String getContrasena() {
        return contrasena;
    }
}
