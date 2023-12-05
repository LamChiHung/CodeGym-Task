package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteProductData {
    private static WriteProductData writeProductData;

    private WriteProductData() {

    }

    public static WriteProductData getWriteProductData() {
        if (writeProductData == null) {
            writeProductData = new WriteProductData();
            return writeProductData;
        } else return writeProductData;
    }

    public void writeData() {
        File file = new File(".\\src\\database\\product\\product.csv");
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.producttMap.forEach((key, value) -> {
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
