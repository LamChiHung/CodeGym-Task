package case_study.utils;

import case_study.model.Room;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class WriteRoomUtils {
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


    public static void writeRoomFile(String path, Map<Room, Integer> houseIntegerMap) {
        StringBuilder data = new StringBuilder();

        Set<Room> rooms = houseIntegerMap.keySet();

        for (Room room : rooms) {
            data.append(room.getInfo()).append(",").append(houseIntegerMap.get(room)).append("\n");
        }
        writeFile(path, data.substring(0, data.length()));

    }
}
