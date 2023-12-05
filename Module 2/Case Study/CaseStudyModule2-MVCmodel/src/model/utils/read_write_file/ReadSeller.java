package model.utils.read_write_file;

import main.StoreMain;
import model.models.imp.Seller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class ReadSeller {
    public static Map <String, Seller> readSeller() {
        File file = new File(".\\src\\database\\Seller.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            StoreMain.currentSellerMap = (Map <String, Seller>) ois.readObject();

        } catch (EOFException ignored) {

        } catch (IOException |
                 ClassNotFoundException e) {
            e.printStackTrace();
        }
        return StoreMain.currentSellerMap;
    }

    public static void readSeller(String username) {
        File file = new File(".\\scr\\database\\Seller.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            StoreMain.currentSellerMap = (Map <String, Seller>) ois.readObject();

        } catch (EOFException ignored) {

        } catch (IOException |
                 ClassNotFoundException e) {
            e.printStackTrace();
        }
        StoreMain.currentSeller = StoreMain.currentSellerMap.get(username);
    }
}
