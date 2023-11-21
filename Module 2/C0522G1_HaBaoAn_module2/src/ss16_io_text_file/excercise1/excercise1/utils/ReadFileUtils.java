package ss16_io_text_file.excercise1.excercise1.utils;

import java.io.*;

public class ReadFileUtils {
    public static void readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedReader.close();
    }
}
