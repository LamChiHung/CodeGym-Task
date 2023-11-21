package homework1.utils;

import homework1.model.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileUtils {
    private static void writeFile(String path, String data) {
        try {
            File file = new File(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(data);
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeStudentFile(String path, List<Student> list)  {
        StringBuilder data = new StringBuilder();
        for (Student student : list) {
            data.append(student.getInfo());
        }
        writeFile(path, data.toString());
    }
}
