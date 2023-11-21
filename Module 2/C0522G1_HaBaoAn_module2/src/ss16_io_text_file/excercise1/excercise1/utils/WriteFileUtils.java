package ss16_io_text_file.excercise1.excercise1.utils;

import java.io.*;


public class WriteFileUtils {
    public static void writerFile(String path,String str) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        bufferedWriter.write(str);
        bufferedWriter.close();
    }
}
