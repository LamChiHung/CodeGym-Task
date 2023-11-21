package Stores;

import Comparator.ComparatorPriceProduct;
import appending_object_output_stream.ReadSeller;
import cart_and_product.Product;
import client_seller.Seller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Stores {
    public static Map <String, Seller> sellerMap;
    private static Stores stores;

    private Stores() {

    }

    public static Stores accessStores() {
        if (stores == null) {
            stores = new Stores();
            sellerMap = new HashMap <>();
        }
        sellerMap = ReadSeller.readSeller();
        return stores;
    }


    public void getStoresView() {
        sellerMap.forEach((key, value) -> {
            System.out.println("Store " + value.getUsername() + ": ");
            value.sellerStorageInformation();
        });
    }

    public void searchProductView(String productName) {
        AtomicBoolean hasItem = new AtomicBoolean(false);
        sellerMap.forEach((key, value) -> {
            Map <String, Product> productMapReference = value.sellerStorage.getProductMap();
            if (productMapReference.containsKey(productName)) {
                hasItem.set(true);
                System.out.println(productMapReference.get(productName));
            }
        });
        if (! hasItem.get()) {
            System.out.println("The product is not exist!");
        }
    }

    public void sortProductView(String productName) {
        List <Product> list = new ArrayList <>();
        AtomicBoolean hasItem = new AtomicBoolean(false);
        sellerMap.forEach((key, value) -> {
            Map <String, Product> productMapReference = value.sellerStorage.getProductMap();
            if (productMapReference.containsKey(productName)) {
                hasItem.set(true);
                list.add(productMapReference.get(productName));
            }
        });
        if (! hasItem.get()) {
            System.out.println("The product is not exist!");
        }
        ComparatorPriceProduct comparatorPriceProduct = new ComparatorPriceProduct();
        list.sort(comparatorPriceProduct);
        list.forEach(System.out :: println);
    }
}
