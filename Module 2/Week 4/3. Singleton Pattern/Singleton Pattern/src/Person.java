public class Person {
    private Book book;
    private boolean haveBook;

    public Person() {
    }

    public void borrowBook(Book book) {
        if (! book.isBorrowed()) {
            this.haveBook = true;
            book.setBorrowed(true);
            this.book = book;
            System.out.println("Borrow: " + haveBook);
        } else {
            System.out.println("Borrow: " + haveBook);
        }
    }

    public void returnBook() {
        if (haveBook) {
            this.book.setBorrowed(false);
            this.haveBook = false;
            this.book = null;
            System.out.println("Return complete");
        } else {
            System.out.println("Don't have book to return");
        }
    }

    public void readBook() {
        if (this.book != null) {
            System.out.println(this.book.getName());
        } else {
            System.out.println("Don't have any book to read");
        }
    }
}
