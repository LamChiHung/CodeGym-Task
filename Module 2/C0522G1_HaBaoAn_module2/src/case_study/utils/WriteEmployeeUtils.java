package case_study.utils;

import case_study.model.person.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteEmployeeUtils {
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

    public static void writeEmployeeFile(String path, List<Employee> list) {
        StringBuilder data = new StringBuilder();
        for (Employee employee : list) {
            data.append(employee.getInfo());
        }
        writeFile(path, data.toString());
    }


}
