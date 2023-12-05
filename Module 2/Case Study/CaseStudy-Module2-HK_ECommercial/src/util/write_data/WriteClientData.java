package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteClientData {
    private static WriteClientData writeClientData;

    private WriteClientData() {

    }

    public static WriteClientData getWriteClientData() {
        if (writeClientData == null) {
            writeClientData = new WriteClientData();
            return writeClientData;
        } else return writeClientData;
    }

    public void writeData() {
        File file = new File(".\\src\\database\\client\\client.csv");
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.clientMap.forEach((key, value) -> {
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
