package model.utils.read_write_file;

import main.StoreMain;
import model.models.imp.Seller;

import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteSeller {
    public static void writeSeller() {
        File file = new File(".\\src\\database\\Seller.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(StoreMain.currentSellerMap);
        } catch (EOFException ignored) {

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeSeller(Seller seller) {
        StoreMain.currentSellerMap.put(seller.getUsername(), seller);
        writeSeller();
    }
}
