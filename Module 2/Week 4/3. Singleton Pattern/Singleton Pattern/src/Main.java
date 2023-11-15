public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Book book = Book.setBook();
        person1.borrowBook(book);
        person2.borrowBook(book);
        person1.readBook();
        person2.readBook();
        person1.returnBook();
        person2.borrowBook(book);
        person2.readBook();

    }
}