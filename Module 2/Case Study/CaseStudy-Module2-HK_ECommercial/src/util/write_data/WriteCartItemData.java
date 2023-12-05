package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteCartItemData {
    private static WriteCartItemData writeCartItemData;

    private WriteCartItemData() {

    }

    public static WriteCartItemData getWriteCartItemData() {
        if (writeCartItemData == null) {
            writeCartItemData = new WriteCartItemData();
            return writeCartItemData;
        } else return writeCartItemData;
    }

    public void writeData() {
        File file = new File(".\\src\\database\\client\\cart_items.csv");
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.cartItemMap.forEach((key, value) -> {
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
