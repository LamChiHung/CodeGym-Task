package entity.product;

import java.util.UUID;

public class Product {
    private UUID productID;
    private String name;
    private String type;

    public Product(String name, String type) {
        this.productID = UUID.randomUUID();
        this.name = name;
        this.type = type;
    }

    public Product(UUID productID, String name, String type) {
        this.productID = productID;
        this.name = name;
        this.type = type;
    }

    public UUID getProductID() {
        return productID;
    }

    public void setProductID(UUID productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product: " +
                "name='" + name + '\'' +
                ", type='" + type + '\'';
    }

    public String csvFormat() {
        String csvFormat = "%s,%s,%s";
        return String.format(csvFormat, productID.toString(), name, type);
    }
}
