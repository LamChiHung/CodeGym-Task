import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Product product1 = new Product(1, "A", 15000, "A");
        Product product2 = new Product(2, "B", 17000, "B");
        Product product3 = new Product(3, "C", 19000, "C");
        File file = new File(".\\products.txt");
        ProductsList productsList = new ProductsList(file);
//        productsList.add(product1);
//        productsList.add(product2);
//        productsList.add(product3);
//        productsList.remove(1);
//        productsList.display();
//        productsList.save();

//        productsList.readFromFile();
    }
}