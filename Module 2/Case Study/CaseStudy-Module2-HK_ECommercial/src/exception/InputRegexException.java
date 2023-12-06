package exception;

public class InputRegexException extends Exception {
    public static int test = 1;

    public InputRegexException() {
        super("The input is not match Regex, please try again!");
    }

}
