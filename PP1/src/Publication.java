public class Publication extends Catalog {
    private int month;
    private int issue;

    public Publication() {
        super();
        month = 0;
        issue = 0;
    }

    public Publication(String title, String publisher, int year, int copies, String type, String call, int month, int issue) {
        super(title, publisher, year, copies, type, call);
        this.month = month;
        this.issue = issue;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    @Override
    public int compareTo(Catalog o) {
        return this.getYear() - o.getYear();
    }

    @Override
    public boolean isRestorable() {
        return 2022 - this.getYear() > 20;
    }
}
