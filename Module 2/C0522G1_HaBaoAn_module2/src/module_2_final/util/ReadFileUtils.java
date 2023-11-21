package module_2_final.util;

import case_study.model.person.Customer;
import module_2_final.model.Cars;
import module_2_final.model.License;
import module_2_final.model.Trucks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadFileUtils {
    private static List<String> readFile(String path) {
        List<String> strings = new LinkedList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings;
    }

    public static List<License> readLicenseList(String path) {
        List<String> strings = readFile(path);
        List<License> customerList = new LinkedList<>();
        String[] info;
        for (String str : strings) {
            info = str.split(",");
            customerList.add(new License(Integer.parseInt(info[0]),
                    info[1],
                    info[2]));
        }
        return customerList;
    }

    public static List<Trucks> readTruckList(String path) {
        List<String> strings = readFile(path);
        List<Trucks> trucksList = new LinkedList<>();
        String[] info;
        for (String str : strings) {
            info = str.split(",");
            trucksList.add(new Trucks(info[0],
                    info[1],
                    info[2],
                    Integer.parseInt(info[3]),
                    Integer.parseInt(info[4]),
                    Integer.parseInt(info[5]),
                    Long.parseLong(info[6])));
        }
        return trucksList;
    }
}
