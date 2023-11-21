package ss17_io_binary_file_serialization.excercise.utils;

import ss17_io_binary_file_serialization.excercise.model.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtils {
    public static List<Product> readFIle(String path) {
        List<Product> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            list = (List<Product>) objectInputStream.readObject();

            fileInputStream.close();
            objectInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return  list;
    }
}
