import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MaxValueFromFile {
    private File file;

    MaxValueFromFile(File file) {
        this.file = file;
    }

    public int findMaxValueFromFile() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(this.file));
        String line = "";
        ArrayList <Integer> list = new ArrayList <>();
        int max = 0;
        try {
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
            for (int value : list) {
                if (max < value) {
                    max = value;
                }
            }
            return max;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
