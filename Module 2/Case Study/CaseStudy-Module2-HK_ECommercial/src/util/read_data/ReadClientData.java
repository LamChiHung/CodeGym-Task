package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.user_imp.Client;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class ReadClientData {
    private static ReadClientData readClientData;

    private ReadClientData() {

    }

    public static ReadClientData getReadClientData() {
        if (readClientData == null) {
            readClientData = new ReadClientData();
            return readClientData;
        } else return readClientData;
    }

    public void readData() {
        try {
            File file = new File(".\\src\\database\\client\\client.csv");
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Client client = new Client(UUID.fromString(line[0]), line[1], line[2], line[3], line[4], Boolean.parseBoolean(line[5]), UUID.fromString(line[6]), UUID.fromString(line[7]));
                DataBase.clientMap.put(client.getClientID(), client);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
