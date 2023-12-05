package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserNameRegex {
    public static boolean userNameRegex(String string) {
        Pattern pattern = Pattern.compile("^[a-z]+[a-z0-9]*");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
