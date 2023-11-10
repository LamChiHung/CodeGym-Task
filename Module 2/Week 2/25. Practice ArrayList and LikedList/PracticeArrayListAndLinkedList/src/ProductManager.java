import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProductManager {
    private ArrayList <Product> products = new ArrayList <>();

    public ProductManager() {
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public Product delete(String name) {
        Product deleteProduct = null;
        for (Product product : products) {
            if (product.getName().equals(name)) {
                deleteProduct = product;
                this.products.remove(product);
                return deleteProduct;
            }
        }
        throw new NoSuchElementException();
    }

    public void edit(int index, String name) {
        this.products.get(index).setName(name);
    }

    public void sort() {
        ProductComparator productComparator = new ProductComparator();
        products.sort(productComparator);
    }

    public void display() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public boolean search(String name) {
        boolean isExist = false;
        int index = 0;
        int targetIndex = - 1;
        for (Product product : products) {
            if (name.equals(product.getName())) {
                isExist = true;
                targetIndex = index;
            }
            index++;
        }
        if (isExist) {
            System.out.println(products.get(targetIndex).toString());
        } else {
            System.out.println("Product don't exist");
        }
        return isExist;
    }
}
