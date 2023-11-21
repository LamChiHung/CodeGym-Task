package Comparator;

import cart_and_product.Product;

import java.util.Comparator;

public class ComparatorPriceProduct implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Product product1 = (Product) o1;
        Product product2 = (Product) o2;
        return Integer.compare(product1.getUnitPrice(), product2.getUnitPrice());
    }
}
