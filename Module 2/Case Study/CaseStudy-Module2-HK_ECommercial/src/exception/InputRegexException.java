package exception;

public class InputRegexException extends Exception {
    public InputRegexException() {
        super("The input is not match Regex, please try again!");
    }

}
