package appending_object_output_stream;

import client_seller.Seller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class ReadSeller {
    private static Map <String, Seller> sellerMap;
    private static ReadSeller readSellers;

    public static Map <String, Seller> readSeller() {
        if (readSellers == null) {
            readSellers = new ReadSeller();
            sellerMap = new HashMap <>();
        }
        File file = new File(".\\database\\seller.csv");
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Seller seller;
            while ((seller = (Seller) ois.readObject()) != null) {
                sellerMap.put(seller.getUsername(), seller);
            }
        } catch (EOFException ignored) {

        } catch (IOException |
                 ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sellerMap;
    }
}
