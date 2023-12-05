package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteCartData {
    private static WriteCartData writeCartData;

    private WriteCartData() {

    }

    public static WriteCartData getWriteCartData() {
        if (writeCartData == null) {
            writeCartData = new WriteCartData();
            return writeCartData;
        } else return writeCartData;
    }

    public void writeData() {
        try {
            File file = new File(".\\src\\database\\client\\cart.csv");
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.cartMap.forEach((key, value) -> {
                list.add(value.csvFormat().split(","));
            });
            csvWriter.writeAll(list);
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
