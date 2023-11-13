import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileSource = new File(".\\source.txt");
        File fileDes = new File(".\\des.txt");
        if (! fileSource.exists()) {
            System.out.println(fileSource.createNewFile());
        }
        if (! fileDes.exists()) {
            System.out.println(fileDes.createNewFile());
        }
        try (FileOutputStream fos = new FileOutputStream(fileSource)) {
            fos.write(1);
            fos.write(2);
            fos.write(3);

        }
        try (FileInputStream fis = new FileInputStream(fileSource);
             FileOutputStream fos = new FileOutputStream(fileDes)) {
            int readValue = 0;
            while ((readValue = fis.read()) != - 1) {
                fos.write(readValue);
            }
        }
        try (FileInputStream fis = new FileInputStream(fileDes)) {
            int readValue = 0;
            while ((readValue = fis.read()) != - 1) {
                System.out.println(readValue);
            }
        }
    }
}