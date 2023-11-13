import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        while (true) {
            System.out.println("Input char");
            int ch = is.read();
            is.skip(2);
            System.out.println("Char Input: " + (char) ch);

        }
    }
}