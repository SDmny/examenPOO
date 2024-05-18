package usuarios.utils;

/*
- MUST Registro de cliente, trabajador y gerente, consulta de ellos
- MUST Consulta individual
- NICE TO HAVE - Tratar de implementar el inicio de sesión con el
    SINGLETON
 */

import usuarios.Usuario;

public class UsuarioEnSesion {
    private static UsuarioEnSesion instancia;
    private static Usuario usuarioActual;

    private UsuarioEnSesion() {}

    public static UsuarioEnSesion getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioEnSesion();
        }

        return instancia;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuario(Usuario usuarioActual) {
        UsuarioEnSesion.usuarioActual = usuarioActual;
    }

    public boolean hayUsuarioEnSesion() {
        return usuarioActual != null;
    }

    public static void cerrarSesion() {
        instancia = null;
        usuarioActual = null;
    }
}