public class Book extends Catalog {
    private long IBSN;
    private String author;

    public Book() {
        super();
        author = "none";
        IBSN = 0;

    }

    public Book(String title, String publisher, int year, int copies, String type, String call, String author, long IBSN) {
        super(title, publisher, year, copies, type, call);
        this.author = author;
        this.IBSN = IBSN;
    }

    @Override
    public boolean isRestorable() {
        return 2022 - this.getYear() > 20;
    }

    public long getIBSN() {
        return IBSN;
    }

    public void setIBSN(int IBSN) {
        this.IBSN = IBSN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(Catalog o) {
        return this.getYear() - o.getYear();
    }
}
