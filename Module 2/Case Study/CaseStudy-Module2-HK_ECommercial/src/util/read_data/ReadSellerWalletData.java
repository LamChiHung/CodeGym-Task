package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.wallet_imp.SellerWallet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class ReadSellerWalletData {
    private static ReadSellerWalletData readSellerWalletData;

    private ReadSellerWalletData() {

    }

    public static ReadSellerWalletData getReadSellerWalletData() {
        if (readSellerWalletData == null) {
            readSellerWalletData = new ReadSellerWalletData();
            return readSellerWalletData;
        } else return readSellerWalletData;
    }

    public void readData() {
        File file = new File(".\\src\\database\\wallet\\seller_wallet.csv");
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                SellerWallet wallet = new SellerWallet(UUID.fromString(line[0]), Integer.parseInt(line[1]));
                DataBase.sellerWalletMap.put(wallet.getSellerWalletID(), wallet);
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
