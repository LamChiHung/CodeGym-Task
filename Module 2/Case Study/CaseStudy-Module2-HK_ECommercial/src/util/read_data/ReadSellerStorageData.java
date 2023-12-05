package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.storage.Storage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReadSellerStorageData {
    private static ReadSellerStorageData readSellerStorageData;

    private ReadSellerStorageData() {

    }

    public static ReadSellerStorageData getReadSellerStorageData() {
        if (readSellerStorageData == null) {
            readSellerStorageData = new ReadSellerStorageData();
            return readSellerStorageData;
        } else return readSellerStorageData;
    }

    public void readData() {
        try {
            File file = new File(".\\src\\database\\seller\\storage.csv");
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Storage storage = new Storage(UUID.fromString(line[0]), LocalDateTime.parse(line[1]), UUID.fromString(line[2]));
                DataBase.storageMap.put(storage.getStoreID(), storage);
            }
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
