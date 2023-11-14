public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        System.out.println(account.checkValidateUserName("lamchihung"));
        System.out.println(account.checkValidateUserName("lamchihung123"));
        System.out.println(account.checkValidateUserName("Lamchihung"));
        System.out.println(account.checkValidateUserName("a"));
        System.out.println(account.checkValidateUserName("123456"));
    }
}