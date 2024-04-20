package usuarios.utils;

import java.time.LocalDate;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private LocalDate fechaNacimiento;
    private String numeroTelefono;
    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombre, String apellido, Rol rol, String numeroTelefono, String nombreUsuario, String contrasena, LocalDate fechaNacimiento) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.numeroTelefono = numeroTelefono;
        CANTIDAD_USUARIOS++;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Nombre completo: %s %s, rol: %s, numero teléfono: %s", id, nombre, apellido, rol, numeroTelefono);
    }

    public Rol getRol() {
        return rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }
}