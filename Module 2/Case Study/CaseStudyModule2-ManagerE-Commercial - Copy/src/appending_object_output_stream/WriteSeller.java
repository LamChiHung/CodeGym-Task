package appending_object_output_stream;

import client_seller.Seller;

import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class WriteSeller {
    private static Map <String, Seller> sellerMap;
    private static WriteSeller writeSeller;

    public static void writeSeller(Map <String, Seller> sellerMap1) {
        if (writeSeller == null) {
            writeSeller = new WriteSeller();
        }
        sellerMap = sellerMap1;
        File file = new File(".\\database\\seller.csv");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            sellerMap.forEach((key, value) -> {
                try {
                    oos.writeObject(value);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (EOFException ignored) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
