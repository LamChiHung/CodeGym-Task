import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        File fileSource = new File(".\\fileSource.txt");
        File fileTarget = new File(".\\fileTarget.txt");
        File fileCopy = new File(".\\fileCopy.txt");
        if (! fileSource.exists()) {
            System.out.println("File chưa tồn tại, khởi tạo file mới");
            try (PrintWriter pw = new PrintWriter(fileSource)) {
                pw.println("ABCD");
                pw.println("EFGH");
                pw.println(123);
                pw.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try (PrintWriter pw = new PrintWriter(fileTarget)) {
            try (FileReader fr = new FileReader(fileSource)) {
                BufferedReader br = new BufferedReader(fr);
                String string = "";
                while ((string = br.readLine()) != null) {
                    pw.println(string);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}
