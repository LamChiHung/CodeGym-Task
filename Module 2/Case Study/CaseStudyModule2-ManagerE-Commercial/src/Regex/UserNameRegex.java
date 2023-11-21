package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserNameRegex {
    public static boolean checkUserNameRegex(String string) {
        Pattern pattern = Pattern.compile("^[a-z]+[a-z1-9]*");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
