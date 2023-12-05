package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {
    public static boolean emailRegex(String string) {
        Pattern pattern = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
