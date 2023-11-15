import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://dantri.com.vn/the-gioi.htm");
        InputStreamReader isr = new InputStreamReader(url.openStream());
        Scanner sc = new Scanner(isr);
        sc.useDelimiter("\\Z");
        String content = sc.next();
        content.replaceAll("\\n+", "");
//        System.out.println(content);
        Pattern pattern = Pattern.compile("htm\">(.*?)</a>");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

    }
}