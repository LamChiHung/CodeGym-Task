package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.user_imp.Seller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class ReadSellerData {
    private static ReadSellerData readSellerData;

    private ReadSellerData() {

    }

    public static ReadSellerData getReadSellerData() {
        if (readSellerData == null) {
            readSellerData = new ReadSellerData();
            return readSellerData;
        } else return readSellerData;
    }

    public void readData() {
        try {
            File file = new File(".\\src\\database\\seller\\seller.csv");
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] line;
            while ((
                    line = reader.readNext()) != null) {
                Seller seller = new Seller(UUID.fromString(line[0]), line[1], line[2], line[3], line[4], Boolean.parseBoolean(line[5]), Double.parseDouble(line[6]), Integer.parseInt(line[7]), UUID.fromString(line[8]), UUID.fromString(line[9]));
                DataBase.sellerMap.put(seller.getSellerID(), seller);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
