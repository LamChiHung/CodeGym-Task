package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordRegex {
    public static boolean checkPasswordRegex(String string) {
        Pattern pattern = Pattern.compile("^[a-z1-9]{6}");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
