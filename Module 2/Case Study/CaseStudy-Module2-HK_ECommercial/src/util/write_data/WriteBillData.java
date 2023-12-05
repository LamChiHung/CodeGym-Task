package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteBillData {
    private static WriteBillData writeBillData;

    private WriteBillData() {

    }

    public static WriteBillData getWriteBillData() {
        if (writeBillData == null) {
            writeBillData = new WriteBillData();
            return writeBillData;
        } else return writeBillData;
    }

    public void writeData() {
        File file = new File(".\\src\\database\\bill\\bill.csv");
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.billMap.forEach((key, value) -> {
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
