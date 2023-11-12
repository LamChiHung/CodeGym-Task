import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile <T> {
    private File file;

    public WriteToFile(File file) {
        this.file = file;
    }

    public void write(T value) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(this.file)) {
            pw.println(value);
            pw.flush();
        }

    }
}
