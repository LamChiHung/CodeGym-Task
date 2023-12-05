package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordRegex {
    public static boolean passWordRegex(String string) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
