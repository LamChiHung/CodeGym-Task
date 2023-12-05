package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.product.Product;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class ReadProductData {
    private static ReadProductData readProductData;

    private ReadProductData() {

    }

    public static ReadProductData getReadProductData() {
        if (readProductData == null) {
            readProductData = new ReadProductData();
            return readProductData;
        } else return readProductData;
    }

    public void readData() {
        File file = new File(".\\src\\database\\product\\product.csv");
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Product product = new Product(UUID.fromString(line[0]), line[1], line[2]);
                DataBase.producttMap.put(product.getProductID(), product);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
