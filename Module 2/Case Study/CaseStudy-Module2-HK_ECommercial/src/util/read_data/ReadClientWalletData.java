package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.wallet_imp.ClientWallet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class ReadClientWalletData {
    private static ReadClientWalletData readClientWalletData;

    private ReadClientWalletData() {

    }

    public static ReadClientWalletData getReadClientWalletData() {
        if (readClientWalletData == null) {
            readClientWalletData = new ReadClientWalletData();
            return readClientWalletData;
        } else return readClientWalletData;
    }

    public void readData() {
        try {
            File file = new File(".\\src\\database\\wallet\\client_wallet.csv");
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                ClientWallet clientWallet = new ClientWallet(UUID.fromString(line[0]), Integer.parseInt(line[1]));
                DataBase.clientWalletMap.put(clientWallet.getClientWalletID(), clientWallet);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
