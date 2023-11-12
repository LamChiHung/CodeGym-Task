import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        
        File filePracticeIOtxt = new File(".\\PracticeIO.txt");
        try {

            if (! filePracticeIOtxt.exists()) {
                System.out.println(filePracticeIOtxt.createNewFile());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try (PrintWriter pw = new PrintWriter(filePracticeIOtxt)) {
            pw.println(1);
            pw.println(3);
            pw.println(6);
            pw.println(1);
            pw.println(8);
            pw.flush();
        }
        try {
            if (! filePracticeIOtxt.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(filePracticeIOtxt));
            int sum = 0;
            String line = "";
            while (((line = br.readLine()) != null)) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}