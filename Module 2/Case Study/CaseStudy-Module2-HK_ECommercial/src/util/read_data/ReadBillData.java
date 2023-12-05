package util.read_data;

import com.opencsv.CSVReader;
import entity.bill_imp.Bill;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class ReadBillData {
    private static ReadBillData readBillData;

    private ReadBillData() {

    }

    public static ReadBillData getReadBillData() {
        if (readBillData == null) {
            readBillData = new ReadBillData();
            return readBillData;
        } else return readBillData;
    }

    public void readData() {
        File file = new File(".\\src\\database\\bill\\bill.csv");
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Bill bill = new Bill(UUID.fromString(line[0]), UUID.fromString(line[1]), UUID.fromString(line[2]), line[3], Integer.parseInt(line[4]));
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
