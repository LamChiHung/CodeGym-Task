package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.cart.CartItem;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class ReadCartItemData {
    private static ReadCartItemData readCartItemData;

    private ReadCartItemData() {

    }

    public static ReadCartItemData getReadCartItemData() {
        if (readCartItemData == null) {
            readCartItemData = new ReadCartItemData();
            return readCartItemData;
        } else return readCartItemData;
    }

    public void readData() {
        File file = new File(".\\src\\database\\client\\cart_items.csv");
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                CartItem cartItem = new CartItem(UUID.fromString(line[0]), UUID.fromString(line[1]), UUID.fromString(line[2]), UUID.fromString(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]));
                DataBase.cartItemMap.put(cartItem.getItemID(), cartItem);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
