package util.write_data;

import com.opencsv.CSVWriter;
import database.DataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteClientWalletLogData {
    private static WriteClientWalletLogData writeClientWalletLogData;

    private WriteClientWalletLogData() {

    }

    public static WriteClientWalletLogData getWriteClientWalletLogData() {
        if (writeClientWalletLogData == null) {
            writeClientWalletLogData = new WriteClientWalletLogData();
            return writeClientWalletLogData;
        } else return writeClientWalletLogData;
    }

    public void writeData() {
        File file = new File(".\\src\\database\\wallet\\client_wallet_log.csv");
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            List <String[]> list = new ArrayList <>();
            DataBase.clientWalletLogMap.forEach((key, value) -> {
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
