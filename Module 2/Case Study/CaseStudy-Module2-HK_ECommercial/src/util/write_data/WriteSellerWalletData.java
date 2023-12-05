package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteSellerWalletData {
    private static WriteSellerWalletData writeSellerWalletData;

    private WriteSellerWalletData() {

    }

    public static WriteSellerWalletData getWriteSellerWalletData() {
        if (writeSellerWalletData == null) {
            writeSellerWalletData = new WriteSellerWalletData();
            return writeSellerWalletData;
        } else return writeSellerWalletData;
    }

    public void writeData() {
        File file = new File(".\\src\\database\\wallet\\seller_wallet.csv");
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.sellerWalletMap.forEach((key, value) -> {
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
