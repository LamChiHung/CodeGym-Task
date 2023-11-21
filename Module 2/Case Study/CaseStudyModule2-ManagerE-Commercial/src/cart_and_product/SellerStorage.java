package cart_and_product;

import client_seller.Seller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SellerStorage implements Serializable {
    private Map <String, Product> productMap;
    private Seller seller;

    public SellerStorage(Seller seller) {
        productMap = new HashMap <>();
        this.seller = seller;
    }

    public Map <String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map <String, Product> productMap) {
        this.productMap = productMap;
    }

    public void add(String name, int unitPrice, int numbers) {
        if (unitPrice > 0 && numbers > 0) {
            if (productMap.containsKey(name)) {
                System.out.println("The product is already in storage!");
                return;
            }
            Product product = new Product(name, seller.getUsername(), unitPrice, numbers);
            productMap.put(product.getName(), product);
            System.out.println("Add product sucess!");
        } else {
            System.out.println("The input does not valid please try again");
        }

    }

    public void delete(String name) {
        if (productMap.containsKey(name)) {
            System.out.println("Delete " + productMap.get(name).getName() + " sucess");
            productMap.remove(name);
        } else {
            System.out.println("Can't find the product for deleting");
        }
    }

    public void editNumbers(String name, int numbers) {
        if (numbers > 0) {
            if (productMap.containsKey(name)) {
                productMap.get(name).setNumbers(numbers);
                System.out.println("Edit sucess!: " + productMap.get(name));
            } else {
                System.out.println("Can't find the product for editing numbers");
            }
        } else {
            System.out.println("The numbers does not valid!");
        }
    }

    public void editNumbersFromClient(String name, int numbers) {
        if (numbers > 0) {
            if (productMap.containsKey(name)) {
                productMap.get(name).setNumbers(numbers);
            } else {
                System.out.println("Can't find the product for editing numbers");
            }
        } else {
            System.out.println("The numbers does not valid!");
        }
    }

    public void editType(String name, String type) {
        if (productMap.containsKey(name)) {
            productMap.get(name).setStore(type);
            System.out.println("Edit sucess!: " + productMap.get(name));
        } else {
            System.out.println("Can't find the product for editing type");
        }
    }

    public void editUnitPrice(String name, int unitPrice) {
        if (unitPrice > 0) {
            if (productMap.containsKey(name)) {
                productMap.get(name).setUnitPrice(unitPrice);
                System.out.println("Edit sucess!: " + productMap.get(name));
            } else {
                System.out.println("Can't find the product for editing unit price");
            }
        } else {
            System.out.println("The price does not valid!");
        }
    }

    public void editPromote(String name, int promote) {
        if (promote > 0) {
            if (productMap.containsKey(name)) {
                productMap.get(name).setPromote(promote);
                System.out.println("Edit sucess!: " + productMap.get(name));
            } else {
                System.out.println("Can't find the product for editing promote");
            }
        } else {
            System.out.println("The promote does not valid!");
        }
    }

    @Override
    public String toString() {
        return "SellerStorage{" +
                "productMap=" + productMap +
                '}';
    }
}
