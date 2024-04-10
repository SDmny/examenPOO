package Usuario;

public class Usuario {
    private static int CANTIDAD_USUARIOS=1;
    private Rol rol;
    private int id;
    private String nombre, apellido;

    public Usuario(String nombre, String apellido, Rol rol){
        this.nombre=nombre;
        this.apellido=apellido;
        this.rol=rol;
        id=CANTIDAD_USUARIOS;
        CANTIDAD_USUARIOS++;
    }

    public String toString(){
        return String.format("Su nombre completo es: %s %s , su id es: %d, su rol es %s",nombre,apellido,id,rol);
    }

}
