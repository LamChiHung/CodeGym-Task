package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.storage.StorageItem;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class ReadStorageItemData {
    private static ReadStorageItemData readStorageItemData;

    private ReadStorageItemData() {

    }

    public static ReadStorageItemData getReadStorageItemData() {
        if (readStorageItemData == null) {
            readStorageItemData = new ReadStorageItemData();
            return readStorageItemData;
        } else return readStorageItemData;
    }

    public void readData() {
        File file = new File(".\\src\\database\\seller\\storage_items.csv");
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                StorageItem storageItem = new StorageItem(UUID.fromString(line[0]), UUID.fromString(line[1]), UUID.fromString(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]));
                DataBase.storageItemMap.put(storageItem.getItemID(), storageItem);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
