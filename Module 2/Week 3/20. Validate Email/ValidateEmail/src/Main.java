public class Main {
    public static void main(String[] args) {
        Email email = new Email();
        System.out.println(email.validate("lamchihung241@gmail.com"));
        System.out.println(email.validate("lamchihung241gmail.com"));
        System.out.println(email.validate("lamchihung241@gmailcom"));
    }
}