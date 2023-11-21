package case_study.utils;

import case_study.model.person.Customer;
import case_study.model.person.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteCustomerUtils {
    private static void writeFile(String path, String data) {
        try {
            File file = new File(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCustomerFile(String path, List<Customer> list) {
        StringBuilder data = new StringBuilder();
        for (Customer customer : list) {
            data.append(customer.getInfo());
        }
        writeFile(path, data.toString());
    }
}
