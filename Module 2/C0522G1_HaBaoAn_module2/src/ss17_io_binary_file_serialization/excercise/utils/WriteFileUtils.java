package ss17_io_binary_file_serialization.excercise.utils;

import ss17_io_binary_file_serialization.excercise.model.Product;

import java.io.*;
import java.util.List;

public class WriteFileUtils {
    public static void writeFile(String path, List<Product> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(list);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}
