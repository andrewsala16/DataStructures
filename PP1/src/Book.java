/**
 * Child class to Catalog to be used for Books: a type of Catalog
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 19, 2021
 * Last Date Modified: Februrary 28, 2021
 */
public class Book extends Catalog {
    /**
     * Class members
     */
    private long IBSN;
    private String author;

    /**
     * Default constructor
     */
    public Book() {
        super();
        author = "none";
        IBSN = 0;
    }

    /**
     * Constructor with eight parameters
     * @param title for the title of a book
     * @param publisher for the publisher of a book
     * @param year for the year a book was published
     * @param copies for the number of copies of a book
     * @param type for the type of publication (Book)
     * @param call for the call number of a book
     * @param author for the author of a book
     * @param IBSN for the IBSN of a book
     */
    public Book(String title, String publisher, int year, int copies, String type, String call, String author, long IBSN) {
        super(title, publisher, year, copies, type, call);
        this.author = author;
        this.IBSN = IBSN;
    }

    /**
     * Getter for the IBSN of a book
     * no parameters
     * @return the value of the data member IBSN
     */
    public long getIBSN() { return IBSN; }

    /**
     * Setter for the duration of a movie
     * @param IBSN to set the data member IBSN
     * no return value
     */
    public void setIBSN(long IBSN) { this.IBSN = IBSN; }

    /**
     * Getter for the author of a book
     * no parameters
     * @return the value of the data member author
     */
    public String getAuthor() { return author; }

    /**
     * Setter for the duration of a movie
     * @param author to set the data member author
     * no return value
     */
    public void setAuthor(String author) { this.author = author; }

    /**
     * Inherited method from interface Comparable
     * @param o Catalog being compared to
     * @return the value
     */
    @Override
    public int compareTo(Catalog o) { return this.getYear() - o.getYear(); }

    /**
     * Inherited method from interface Restorable
     * @return true if the object is older than 20 years
     */
    @Override
    public boolean isRestorable() { return 2022 - this.getYear() > 20; }
}
