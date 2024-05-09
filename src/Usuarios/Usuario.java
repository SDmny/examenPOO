package Usuarios;

import Sistema.DatosComun;
import Usuarios.utils.Sucursal;
import Usuarios.utils.Gente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Usuario {
    Random ran = new Random();
    String nombre, apellido1, apellido2, ciudad, estado, rfc, curb, direccion, homoclave;
    boolean repetida = true;
    LocalDate birth, register;
    Sucursal sucursal;
    Gente rol;
    int id;
    static int cantidadUsuarios;

    //Crear metodo para hacer nulo el segundo apellido sí no tiene (apellido2)
    public Usuario(String nombre, String apellido1, String apellido2, String ciudad, String estado, String curb, String direccion, Sucursal sucursal, Gente rol) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.ciudad = ciudad;
        this.estado = estado;
        this.curb = curb;
        this.direccion = direccion;
        this.sucursal = sucursal;
        this.id = cantidadUsuarios;
        cantidadUsuarios++;
        this.register = LocalDate.now();
        birth = DatosComun.asignarFecha();
        rfc = apellido1.substring(0, 2);
        if (!apellido2.isEmpty()) {
            rfc = rfc + apellido2.charAt(0) + nombre.charAt(0);
        } else {
            rfc = rfc + nombre.substring(0, 2);
        }
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

            hom = ran.nextInt(1, 3);
            if (hom == 1) {
                hom = ran.nextInt(65, 91);
                homo = homo.concat(Character.toString((char) hom));
            } else {
                clave = ran.nextInt(10);
                homo = homo.concat(Integer.toString(clave));
            }


        }
        return homo;
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
        return curb;
    }

    public void setCurb(String curb) {
        this.curb = curb;
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


}
