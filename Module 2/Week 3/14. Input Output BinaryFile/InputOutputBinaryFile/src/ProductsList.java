import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductsList {
    private ArrayList <Product> products = new ArrayList <>();
    private File file;

    public ProductsList(File file) throws IOException {
        this.file = file;
        if (! this.file.exists()) {
            file.createNewFile();
        }
        try {
            this.readFromFile();
        } catch (EOFException ignored) {

        }
    }

    public void add(Product product) {
        products.add(product);
    }

    public void readFromFile() throws IOException {
        try (FileInputStream fis = new FileInputStream(this.file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                Object object = ois.readObject();
                if (object == null) {
                    break;
                }
                products.add((Product) object);
            }

        } catch (EOFException ignored) {
            System.out.println(products.toString());
        } catch (ClassNotFoundException |
                 IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(this.file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Product product : products) {
                oos.writeObject(product);
            }
        }
        products.clear();
    }

    public void display() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void remove(int index) {
        products.remove(index);
    }
}
