package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteSellerStorageData {
    private static WriteSellerStorageData writeSellerStorageData;

    private WriteSellerStorageData() {
    }

    public static WriteSellerStorageData getWriteSellerStorageData() {
        if (writeSellerStorageData == null) {
            writeSellerStorageData = new WriteSellerStorageData();
            return writeSellerStorageData;
        } else {
            return writeSellerStorageData;
        }
    }

    public void writeData() {
        try {
            File file = new File(".\\src\\database\\seller\\storage.csv");
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.storageMap.forEach((key, value) -> {
                String[] line = value.csvFormat().split(",");
                list.add(line);
            });
            csvWriter.writeAll(list);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
