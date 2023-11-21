package cart_and_product;

import java.io.Serializable;

public class Product implements Serializable, Cloneable {
    private String name;
    private String store;
    private int unitPrice;
    private int numbers;
    private int promote;

    public Product(String name, String store, int unitPrice, int numbers) {
        this.name = name;
        this.store = store;
        this.unitPrice = unitPrice;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public int getPromote() {
        return promote;
    }

    public void setPromote(int promote) {
        this.promote = promote;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", unitPrice=" + unitPrice +
                ", numbers=" + numbers +
                ", promote=" + promote +
                '}';
    }

    @Override
    public Product clone() {
        try {
            Product clone = (Product) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
