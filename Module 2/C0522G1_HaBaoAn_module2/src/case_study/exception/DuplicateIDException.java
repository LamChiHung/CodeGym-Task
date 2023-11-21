package case_study.exception;

public class DuplicateIDException extends Exception {
    public DuplicateIDException(String message) {
        super(message);
    }
}
