package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberRegex {
    public static boolean phoneNumberRegex(String string) {
        Pattern pattern = Pattern.compile("^[0-9]{10,11}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
