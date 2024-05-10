package usuarios;

import usuarios.utils.DatosComun;
import usuarios.utils.Sucursal;
import usuarios.utils.Gente;

import java.time.LocalDate;
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
    public Usuario(String nombre, String apellido1, String apellido2, char sexo, String ciudad, String estado, String curp, String direccion, Sucursal sucursal, Gente rol, String usuario, String contrasena) {
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
        dateBirth = "" + birth.getMonth();
        rfc = rfc + dateBirth;
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

    }

    //Homoclave para RFC
    private String Homoclave() {
        String homo = "";
        int clave, hom = 65;
        for (int i = 0; i < 2; i++) {

            hom = ran.nextInt(2)+1;
            if (hom == 1) {
                hom = ran.nextInt(26)+65;
                homo = homo.concat(Character.toString((char) hom));
            } else {
                clave = ran.nextInt(10);
                homo = homo.concat(Integer.toString(clave));
            }


        }
        return homo;
    }


    // Metodo para imprimir datos basicos
    @Override
    public String toString(){
        String cadena = String.format("Id: %d; Nombre completo: %s %s %s; Rol: %s; Nombre de usuario: %s", id, nombre, apellido1, apellido2, rol, usuario);
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
