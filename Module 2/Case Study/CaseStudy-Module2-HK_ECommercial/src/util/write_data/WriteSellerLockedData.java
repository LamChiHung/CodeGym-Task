package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteSellerLockedData {
    private static WriteSellerLockedData writeSellerLockedData = new WriteSellerLockedData();

    private WriteSellerLockedData() {

    }

    public static WriteSellerLockedData getWriteSellerData() {
        if (writeSellerLockedData == null) {
            writeSellerLockedData = new WriteSellerLockedData();
            return writeSellerLockedData;
        } else return writeSellerLockedData;
    }

    public void writeData() {
        try {
            File file = new File(".\\src\\database\\seller\\locked_seller.csv");
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.lockedSellerMap.forEach((key, value) -> {
                String line = value.csvFormat();
                list.add(line.split(","));
            });
            csvWriter.writeAll(list);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
