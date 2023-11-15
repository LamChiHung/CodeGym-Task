import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String phoneNumber = "84-0978489648";
        Pattern pattern = Pattern.compile("(^[0-9]{2})-(0[0-9]{9})");
        Matcher matcher = pattern.matcher(phoneNumber);
        System.out.println(matcher.matches());
        String x = "abc";
        x.concat(y);
        System.out.print(x);
    }
}