package case_study.utils;

import case_study.model.Villa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class WriteVillaUtils {
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


    public static void writeVillaFile(String path, Map<Villa, Integer> houseIntegerMap) {
        StringBuilder data = new StringBuilder();

        Set<Villa> houseSet = houseIntegerMap.keySet();

        for (Villa villa : houseSet) {
            data.append(villa.getInfo()).append(",").append(houseIntegerMap.get(villa)).append("\n");
        }
        writeFile(path, data.substring(0, data.length()));

    }
}
