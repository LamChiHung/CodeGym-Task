import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String classname1 = "C0223G";
        Pattern pattern = Pattern.compile("^[CAP]{1}\\d{4}[GHIK]$");
        Matcher matcher = pattern.matcher(classname1);
        System.out.println(matcher.matches());
    }
}