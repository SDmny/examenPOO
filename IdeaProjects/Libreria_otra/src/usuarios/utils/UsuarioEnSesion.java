package usuarios.utils;

/*
- MUST Registro de cliente, trabajador y gerente, consulta de ellos
- MUST Consulta individual
- NICE TO HAVE - Tratar de implementar el inicio de sesión con el
    SINGLETON
 */

public class UsuarioEnSesion {
    private static UsuarioEnSesion instancia;
    private Usuario usuarioActual;

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
        this.usuarioActual = usuarioActual;
    }

    public boolean hayUsuarioEnSesion() {
        return usuarioActual != null;
    }

    public void cerrarSesion() {
        instancia = null;
        usuarioActual = null;
    }
}