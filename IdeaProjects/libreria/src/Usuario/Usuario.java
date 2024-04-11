package Usuario;
import java.time.LocalDate;

public class Usuario {
    private LocalDate fechaNacimiento;
    private static int CANTIDAD_USUARIOS=1;
    private Rol rol;
    private int id;

    private String nombre, apellido, nombreUsuario, contraseña;

    public Usuario(String nombre, String apellido, Rol rol, String nombreUsuario,String contraseña,LocalDate fechaNacimiento){
        this.nombre=nombre;
        this.apellido=apellido;
        this.rol=rol;
        this.nombreUsuario=nombreUsuario;
        this.contraseña=contraseña;
        id=CANTIDAD_USUARIOS;
        CANTIDAD_USUARIOS++;
        this.fechaNacimiento=fechaNacimiento;
    }
@Override
    public String toString(){
        return String.format("Nombre completo es: %s %s , id: %d, rol: %s, nombreUsuario: %s\n Fecha de nacimiento: %s, fecha de registro: ",nombre,apellido,id,rol,nombreUsuario,fechaNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public Enum<Rol> getRol() {
        return rol;
    }

    public String getContraseña() {
        return contraseña;
    }
}


