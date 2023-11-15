public class Book {
    private static Book book;
    private String name;
    private boolean isBorrowed;

    private Book() {
        this.name = "A";
        this.isBorrowed = false;
    }

    public static Book setBook() {
        if (book == null) {
            book = new Book();
        }
        return book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}

