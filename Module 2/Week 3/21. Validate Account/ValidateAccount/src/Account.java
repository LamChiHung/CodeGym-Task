import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    public final String regex = "^[_a-z0-9]{6,}$";

    public Account() {

    }

    public boolean checkValidateUserName(String username) {
        Pattern pattern = Pattern.compile(this.regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
