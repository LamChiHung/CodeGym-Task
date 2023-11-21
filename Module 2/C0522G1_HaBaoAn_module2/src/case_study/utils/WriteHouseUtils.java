package case_study.utils;


import case_study.model.House;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class WriteHouseUtils {
    private static void writeFile(String path, String data) {
        File file = new File(path);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeHouseFile(String path, Map<House, Integer> houseIntegerMap) {
        StringBuilder data = new StringBuilder();

        Set<House> houseSet = houseIntegerMap.keySet();

        for (House house : houseSet) {
            data.append(house.getInfo()).append(",").append(houseIntegerMap.get(house)).append("\n");
        }
            writeFile(path, data.substring(0, data.length()));

    }
}
