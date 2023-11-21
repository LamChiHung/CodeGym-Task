package cart_and_product;

import client_seller.Seller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart implements Serializable {
    public Map <String, Product> productMap;
    public int bill;

    public Cart() {
        productMap = new HashMap <>();
    }

    public void addProduct(Map <String, Seller> sellerMap, String sellerName, String productName, int numbers) {
        if (sellerMap.containsKey(sellerName)) {
            Seller seller = sellerMap.get(sellerName);
            Product productReference;
            if (seller.sellerStorage.getProductMap().containsKey(productName)) {
                productReference = seller.sellerStorage.getProductMap().get(productName);
                if (productReference.getNumbers() - numbers >= 0 | numbers <= 0) {
                    productReference.setNumbers(productReference.getNumbers() - numbers);
                    Product productValue = productReference.clone();
                    if (! productMap.containsKey(productValue.getName())) {
                        productValue.setNumbers(numbers);
                        productMap.put(productValue.getName(), productValue);
                        displayCart();
                    } else {
                        Product productNeedToChangeNumbers = productMap.get(productValue.getName());
                        productNeedToChangeNumbers.setNumbers(productNeedToChangeNumbers.getNumbers() + numbers);
                    }

                } else {
                    System.out.println("Numbers of product is not valid");
                    return;
                }
            } else {
                System.out.println("Product is not valid");
                return;
            }
        } else {
            System.out.println("The store is not valid");
            return;
        }
    }

    public void removeProduct(Map <String, Seller> sellerMap, String sellerName, String productName) {
        if (productMap.containsKey(productName)) {
            Seller seller = sellerMap.get(sellerName);
            seller.sellerStorage.editNumbersFromClient(productName, seller.sellerStorage.getProductMap().get(productName).getNumbers() + productMap.get(productName).getNumbers());
            productMap.remove(productName);
            System.out.println("Remove sucess!");
            displayCart();
        } else {
            System.out.println("Can't find product");
            displayCart();
        }
    }

    public void editProduct(Map <String, Seller> sellerMap, String sellerName, String productName, int numbers) {
        if (productMap.containsKey(productName) | numbers > 0) {
            Seller seller = sellerMap.get(sellerName);
//          Đồng bộ số lượng của giỏ hàng và seller storage khi edit số lượng sản phẩm
            seller.sellerStorage.editNumbersFromClient(productName, seller.sellerStorage.getProductMap().get(productName).getNumbers() - (numbers - productMap.get(sellerName).getNumbers()));
            productMap.get(productName).setNumbers(numbers);
            System.out.println("Edit sucess!");
            displayCart();
        } else {
            System.out.println("Can't find product");
            displayCart();
        }
    }

    public void displayCart() {
        System.out.println("Cart item: ");
        productMap.forEach((key, value) -> {
            System.out.println(value);
        });
        System.out.println("Total bill: " + calculatorBill());
    }

    public int calculatorBill() {
        AtomicInteger bill = new AtomicInteger();
        productMap.forEach((key, value) -> {
            bill.addAndGet(value.getNumbers() * value.getUnitPrice() * ((100 - value.getPromote()) / 100));
        });
        return bill.get();
    }

}
