import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        String htmlSource = "<span class=\"name_song\">Song 1</span> <span class=\"name_song\">Song 2</span> <span class=\"name_song\">Song 3</span>";
        String regex = "name_song\">(.*?)</span>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(htmlSource);

        while (matcher.find()) {
            String matchedText = matcher.group(1);
            System.out.println(matchedText);
        }
    }
}