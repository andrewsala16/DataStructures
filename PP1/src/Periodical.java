/**
 * Child class to Catalog to be used for Periodicals: a type of Catalog
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 19, 2021
 * Last Date Modified: Februrary 28, 2021
 */
public class Periodical extends Catalog {
    /**
     * Class members
     */
    private int month;
    private int issue;

    /**
     * Default constructor
     */
    public Periodical() {
        super();
        month = 0;
        issue = 0;
    }

    /**
     * Constructor with eight parameters
     * @param title for the title of a periodical
     * @param publisher for the publisher of a periodical
     * @param year for the year a periodical was published
     * @param copies for the number of copies of a periodical
     * @param type for the type of publication (periodical)
     * @param call for the call number of a periodical
     * @param month for the month a periodical was published
     * @param issue for the issue number of a periodical
     */
    public Periodical(String title, String publisher, int year, int copies, String type, String call, int month, int issue) {
        super(title, publisher, year, copies, type, call);
        this.month = month;
        this.issue = issue;
    }

    /**
     * Getter for the month of a periodical
     * no parameters
     * @return the value of the data member month
     */
    public int getMonth() { return month; }

    /**
     * Setter for the month of a periodical
     * @param month to set the data member month
     * no return value
     */
    public void setMonth(int month) { this.month = month; }

    /**
     * Getter for the issue number of a periodical
     * no parameters
     * @return the value of the data member issue
     */
    public int getIssue() { return issue; }

    /**
     * Setter for the issue of a periodical
     * @param issue to set the data member issue
     * no return value
     */
    public void setIssue(int issue) { this.issue = issue; }

    /**
     * Inherited method from interface Comparable
     * @param o Catalog being compared to
     * @return the value of
     */
    @Override
    public int compareTo(Catalog o) { return this.getYear() - o.getYear(); }

    /**
     * Inherited method from interface Restorable
     * no parameters
     * @return true if the object is older than 20 years
     */
    @Override
    public boolean isRestorable() { return 2022 - this.getYear() > 20; }
}
