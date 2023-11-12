import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File fileRead = new File(".\\PracticeIO.txt");
        File fileWrite = new File(".\\MaxValueFromFile.txt");
        try {
            if (! fileWrite.exists()) {
                System.out.println(fileWrite.createNewFile());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (fileRead.exists()) {
            MaxValueFromFile maxValueFromFile = new MaxValueFromFile(fileRead);
            try {
                int maxValue = maxValueFromFile.findMaxValueFromFile();
                WriteToFile <Integer> wtf = new WriteToFile <>(fileWrite);
                wtf.write(maxValue);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}