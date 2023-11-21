package homework1.utils;

import homework1.model.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtils {
    private static List<String> readFile(String path) {
        List<String> strings = new ArrayList<>();
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


    public static List<Student> readStudenList(String path) {
        List<String> strings = readFile(path);
        List<Student> studentList = new ArrayList<>();
        String[] info;
        for (String str : strings) {
            info = str.split(",");
            studentList.add(new Student(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4], Double.parseDouble(info[5])));
        }
        return studentList;
    }
}
