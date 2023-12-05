package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.wallet_imp.SellerWalletLog;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReadSellerWalletLogData {
    private static ReadSellerWalletLogData readSellerWalletLogData;

    private ReadSellerWalletLogData() {

    }

    public static ReadSellerWalletLogData getReadSellerWalletLogData() {
        if (readSellerWalletLogData == null) {
            readSellerWalletLogData = new ReadSellerWalletLogData();
            return readSellerWalletLogData;
        } else return readSellerWalletLogData;
    }

    public void readData() {
        File file = new File(".\\src\\database\\wallet\\seller_wallet_log.csv");
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                SellerWalletLog sellerWalletLog = new SellerWalletLog(UUID.fromString(line[0]), UUID.fromString(line[1]), UUID.fromString(line[2]), LocalDateTime.parse(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]));
                DataBase.sellerWalletLogMap.put(sellerWalletLog.getSellerWalletLogID(), sellerWalletLog);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
