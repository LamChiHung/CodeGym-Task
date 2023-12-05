package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.cart.Cart;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReadCartData {
    private static ReadCartData readCartData;

    private ReadCartData() {

    }

    public static ReadCartData getReadCartData() {
        if (readCartData == null) {
            readCartData = new ReadCartData();
            return readCartData;
        } else return readCartData;
    }

    public void readData() {
        try {
            File file = new File(".\\src\\database\\client\\cart.csv");
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Cart cart = new Cart(UUID.fromString(line[0]), UUID.fromString(line[1]), LocalDateTime.parse(line[2]), Integer.parseInt(line[3]));
                DataBase.cartMap.put(cart.getCartID(), cart);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
