import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private int price;
    private String brand;

    public Product() {
    }

    public Product(int id, String name, int price, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
