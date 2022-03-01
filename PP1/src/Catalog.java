/**
 * Abstract class used to create an object that contains details of a publication
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 19, 2021
 * Last Date Modified: Februrary 28, 2021
 */
public abstract class Catalog implements Restorable, Comparable<Catalog>{
    /**
     * Class members
     */
    private String title;
    private String publisher;
    private int year;
    private int copies;
    private String type;
    private String call;

    /**
     * Default constructor
     */
    protected Catalog() {
        title = "none";
        publisher = "none";
        year = 0;
        copies = 0;
        type = "none";
        call = "none";
    }

    /**
     * Constructor with six parameters
     * @param title for the title of a publication
     * @param publisher for the publisher of a publication
     * @param year for the year a publication was published
     * @param copies for the number of copies of a publication
     * @param type for the type of publication
     * @param call for the call number of a publication
     */
    protected Catalog(String title, String publisher, int year,
                      int copies, String type, String call) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.copies = copies;
        this.type = type;
        this.call = call;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public int getCopies() { return copies; }

    public void setCopies(int copies) { this.copies = copies; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getCall() { return call; }

    public void setCall(String call) { this.call = call; }

    /**
     * Static method to print formatted details of publication
     * @param cat for catalog being printed
     */
    public static void printMedia(Catalog cat){

        System.out.printf("%-30s\t%-45s\t%-30s\t%-30d\n", cat.getCall(), cat.getTitle(), cat.getPublisher(), cat.getYear());
    }

    /**
     * Static method that finds a publication with given call number in a given array
     * @param callNumInput for the call number of the publication being searched for
     * @param catalog the array of catalogs being searched
     */
    public static void findMedia(String callNumInput, Catalog[] catalog){
        boolean found = false;
        if(callNumInput.matches("[B-P]-\\d{3}-\\d{3}-\\d{3}")){
            for (Catalog title : catalog) {
                if(title != null) {
                    if (callNumInput.equals(title.getCall())) {
                        found = true;
                        System.out.println("Title Found:");
                        printMedia(title);
                        System.out.println();
                        break;
                    }
                }
            }
            if(!found){
                System.out.println("Call number not found\n");
            }
        }
        else{
            System.out.println("Invalid Call Number. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd\n");
        }
    }

    /**
     * Overloading static method that finds a publication with given year in a given array
     * @param year for the year of the publications being searched for
     * @param catalog the array of catalogs being searched
     */
    public static void findMedia(int year, Catalog[] catalog){
        int num = 0;
        if(year > 1900 && year < 2022){
            System.out.println("Titles Found:");
            for (Catalog title : catalog) {
                if (title != null) {
                    if (year == title.getYear()){
                        num++;
                        printMedia(title);
                    }
                }
            }
            if(num == 0){
                System.out.println("none");
            }
        }
        else{
            System.out.println("Invalid Year. Must be between 1900 and 2022");
        }
    }


    /**
     * Static method that finds a publication with given title in a given array
     * @param titleInput for the title of the publication being searched for
     * @param catalog the array of catalogs being searched
     */
    public static void findByTitle(String titleInput, Catalog[] catalog){
        boolean found = false;
        for (Catalog title : catalog) {
            if(title != null) {
                if (titleInput.equals(title.getTitle())) {
                    found = true;
                    printMedia(title);
                }
            }
        }
        if(!found){
            System.out.println("No title found\n");
        }

    }

    /**
     * Method to add given object of type Catalog to given array
     * @param list for the array being added to
     * @param pub for Catalog being added to array
     */
    public static void add(Catalog[] list, Catalog pub) {
        for (int i = 0; i < list.length; i++) {
            if(list[i] == null){
                list[i] = pub;
                break;
            }
        }
    }

    /**
     * Static method to remove a publication with given call number from an array of catalogs
     * @param list for array of catalogs being searched
     * @param callN for the call number of the publication being searched for in array
     */
    public static void remove(Catalog[] list, String callN){
        if(callN.matches("[B-P]-\\d{3}-\\d{3}-\\d{3}")) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] != null && list[i].getCall().equals(callN)) {
                    for (int j = i; j < list.length; j++) {
                        if (j < 49) {
                            list[j] = list[j + 1];
                        }
                    }
                    break;
                }
            }
            System.out.println("Title not found\n");
        }
        else{
            System.out.println("Invalid Call Number\n");
        }
    }

    /**
     * Inherited method from interface Restorable
     * @return true if the object is older than 20 years
     */
    public boolean isRestorable(){
        return (2022 - this.getYear() > 20);
    }




}
