public class Producto {
    String name;
    double precio;
    int stock;

    public Producto(String name, double precio, int stock) {
        this.name = name;
        this.precio = precio;
        this.stock = stock;

    }

    public Producto(String name, double precio) {
        this.name = name;
        this.precio = precio;
        stock = 0;

    }

    public String getName() {
        if (name == "") {
            return "No hay nombre";
        } else {
            return name;
        }
    }

    public void setName(String name) {
        if (name != "") {
            this.name = name;
        } else {
            System.out.println("No se puede ingresar nombre");
        }
    }

    public double getPrecio() {
        return this.precio;
    }

    public double setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
        return this.precio;
    }

    public int setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
        return this.stock;
    }

    public int getStock() {
        return this.stock;
    }

    public void aumentarStock(int stock) {
        if (stock >= 0) {
            this.stock = this.stock + stock;
        } else {
            System.out.println("No se puede");
        }
    }

    public void reducirStock(int stock) {
        if (stock <= this.stock) {
            this.stock = this.stock - stock;
        } else {
            System.out.println("No se puede");
        }
    }
}