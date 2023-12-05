package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteSellerData {
    private static WriteSellerData writeSellerData;

    private WriteSellerData() {

    }

    public static WriteSellerData getWriteSellerData() {
        if (writeSellerData == null) {
            writeSellerData = new WriteSellerData();
            return writeSellerData;
        } else {
            return writeSellerData;
        }
    }

    public void writeData() {
        try {
            File file = new File(".\\src\\database\\seller\\seller.csv");
            CSVWriter csvWriter = new CSVWriter(new PrintWriter(file));
            List <String[]> sellerList = new ArrayList <>();
            DataBase.sellerMap.forEach((key, value) -> {
                String line = value.toCSVFormat();
                String[] lineSplitToArray = line.split(",");
                sellerList.add(lineSplitToArray);
            });
            csvWriter.writeAll(sellerList);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
