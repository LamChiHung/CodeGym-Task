package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.lockedaccount_imp.LockedClient;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReadLockedClientData {
    private static ReadLockedClientData readLockedClientData;

    private ReadLockedClientData() {

    }

    public static ReadLockedClientData getReadLockedClientData() {
        if (readLockedClientData == null) {
            readLockedClientData = new ReadLockedClientData();
            return readLockedClientData;
        } else return readLockedClientData;
    }

    public void readData() {
        try {
            File file = new File(".\\src\\database\\client\\locked_client.csv");
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                LockedClient lockedClient = new LockedClient(UUID.fromString(line[0]), LocalDateTime.parse(line[1]), LocalDateTime.parse(line[2]));
                DataBase.lockedClientMap.put(lockedClient.getClientID(), lockedClient);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
