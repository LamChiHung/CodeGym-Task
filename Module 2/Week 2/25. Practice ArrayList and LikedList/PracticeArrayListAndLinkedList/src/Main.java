public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Milk");
        Product product2 = new Product(2, "Fish");
        Product product3 = new Product(3, "Rice");
        Product product4 = new Product(4, "Noodle");
        ProductManager productManager = new ProductManager();
        productManager.add(product1);
        productManager.add(product2);
        productManager.add(product3);
        productManager.add(product4);
        productManager.display();
        System.out.println("-------------------------------");
        productManager.sort();
        productManager.display();
        System.out.println("-------------------------------");
        productManager.search("Fish");
        System.out.println("--------------------------------");
        productManager.delete("Fish");
        productManager.display();
        System.out.println("--------------------------------");
        productManager.edit(1, "Fish");
        productManager.display();
        
    }
}