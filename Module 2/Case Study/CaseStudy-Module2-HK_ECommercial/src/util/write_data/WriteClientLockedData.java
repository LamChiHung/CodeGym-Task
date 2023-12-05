package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteClientLockedData {
    private static WriteClientLockedData writeClientLockedData = new WriteClientLockedData();

    private WriteClientLockedData() {

    }

    public static WriteClientLockedData getWriteClientData() {
        if (writeClientLockedData == null) {
            writeClientLockedData = new WriteClientLockedData();
            return writeClientLockedData;
        } else return writeClientLockedData;
    }

    public void writeData() {
        try {
            File file = new File(".\\src\\database\\client\\locked_client.csv");
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.lockedClientMap.forEach((key, value) -> {
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
