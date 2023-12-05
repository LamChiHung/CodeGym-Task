package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteStorageItemData {
    private static WriteStorageItemData writeStorageItemData;

    private WriteStorageItemData() {

    }

    public static WriteStorageItemData getWriteStorageItemData() {
        if (writeStorageItemData == null) {
            writeStorageItemData = new WriteStorageItemData();
            return writeStorageItemData;
        } else return writeStorageItemData;
    }

    public void writeData() {
        File file = new File(".\\src\\database\\seller\\storage_items.csv");
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.storageItemMap.forEach((key, value) -> {
                list.add(value.csvFormat().split(","));
            });
            csvWriter.writeAll(list);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
