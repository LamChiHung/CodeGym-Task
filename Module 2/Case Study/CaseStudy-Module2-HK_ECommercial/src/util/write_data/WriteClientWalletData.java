package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteClientWalletData {
    private static WriteClientWalletData writeClientWalletData;

    private WriteClientWalletData() {

    }

    public static WriteClientWalletData getWriteClientWalletData() {
        if (writeClientWalletData == null) {
            writeClientWalletData = new WriteClientWalletData();
            return writeClientWalletData;
        } else return writeClientWalletData;
    }

    public void writeData() {
        try {
            File file = new File(".\\src\\database\\wallet\\client_wallet.csv");
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.clientWalletMap.forEach((key, value) -> {
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
