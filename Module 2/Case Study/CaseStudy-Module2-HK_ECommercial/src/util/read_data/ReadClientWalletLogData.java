package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.wallet_imp.ClientWalletLog;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReadClientWalletLogData {
    private static ReadClientWalletLogData readClientWalletLogData;

    private ReadClientWalletLogData() {

    }

    public static ReadClientWalletLogData getReadClientWalletLogData() {
        if (readClientWalletLogData == null) {
            readClientWalletLogData = new ReadClientWalletLogData();
            return readClientWalletLogData;
        } else return readClientWalletLogData;
    }

    public void readData() {
        File file = new File(".\\src\\database\\wallet\\client_wallet_log.csv");
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                ClientWalletLog clientWalletLog = new ClientWalletLog(UUID.fromString(line[0]), UUID.fromString(line[1]), UUID.fromString(line[2]), LocalDateTime.parse(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]));
                DataBase.clientWalletLogMap.put(clientWalletLog.getClientWalletLogID(), clientWalletLog);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
