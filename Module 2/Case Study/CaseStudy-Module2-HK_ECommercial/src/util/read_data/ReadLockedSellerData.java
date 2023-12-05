package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.lockedaccount_imp.LockedSeller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReadLockedSellerData {
    private static ReadLockedSellerData readLockedSellerData;

    private ReadLockedSellerData() {

    }

    public static ReadLockedSellerData getReadLockedSellerData() {
        if (readLockedSellerData == null) {
            readLockedSellerData = new ReadLockedSellerData();
            return readLockedSellerData;
        } else return readLockedSellerData;
    }

    public void readData() {
        try {
            File file = new File(".\\src\\database\\seller\\locked_seller.csv");
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                LockedSeller lockedSeller = new LockedSeller(UUID.fromString(line[0]), LocalDateTime.parse(line[1]), LocalDateTime.parse(line[2]));
                DataBase.lockedSellerMap.put(lockedSeller.getSellerID(), lockedSeller);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
