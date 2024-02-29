public class Hw_6 {
    public static void main(String[] args) throws Exception {
        System.out.println("Programa sobre getters y setters: ");
//Revisión constructores
        Producto shampoo = new Producto("Pantene", 39.5,50);
        Producto refresco = new Producto("Coca", 40);
//Métodos get

System.out.println("Metodos de get:");
        System.out.println(shampoo.getName());
        System.out.println(shampoo.getPrecio());
        System.out.println(shampoo.getStock());
        


        //Métodos set:
        //Name
        System.out.println("Metodos de set");
        System.out.println("Name");
        System.out.println();
        shampoo.setName("Savile");
        System.out.println(shampoo.getName());
        shampoo.setName("");
        System.out.println(shampoo.getName());

        System.out.println("Precio");
//Precio
shampoo.setPrecio(54);
System.out.println(shampoo.getPrecio());
shampoo.setPrecio(-4);
System.out.println(shampoo.getPrecio());

System.out.println("Stock");
//Stock
shampoo.setStock(7);
System.out.println(shampoo.getStock());
shampoo.setStock(-45);
System.out.println(shampoo.getStock());



System.out.println("Metodos de stock:");
System.out.println("Aumentar stock:");
        //Aumentar stock
        shampoo.aumentarStock(5);
        System.out.println(shampoo.getStock());
        shampoo.aumentarStock(-5);
        System.out.println(shampoo.getStock());


    System.out.println("Disminuir stock: ");
    shampoo.reducirStock(2);
    System.out.println(shampoo.getStock());
    shampoo.reducirStock(11);
    System.out.println(shampoo.getStock());
    }

}
