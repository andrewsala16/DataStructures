import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Catalog implements Restorable, Comparable<Catalog>{
    //constructors
    private String title;
    private String publisher;
    private int year;
    private int copies;
    private String type;
    private String call;

    protected Catalog() {
        title = "none";
        publisher = "none";
        year = 0;
        copies = 0;
        type = "none";
        call = "none";
    }

    protected Catalog(String title, String publisher, int year,
                      int copies, String type, String call) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.copies = copies;
        this.type = type;
        this.call = call;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", copies=" + copies +
                ", type='" + type + '\'' +
                ", call='" + call + '\'' +
                '}';
    }


    public static void printMedia(Catalog cat){
        System.out.printf("%-30s\t%-45s\t%-30s\t%-30d\n", cat.getCall(), cat.getTitle(), cat.getPublisher(), cat.getYear());
    }

    public static void findMedia(String callNumInput, Catalog[] catalog){
        boolean found = false;
        if(callNumInput.matches("[B-P]-\\d{3}-\\d{3}-\\d{3}")){
            for (Catalog title : catalog) {
                if(title != null) {
                    if (callNumInput.equals(title.getCall())) {
                        found = true;
                        System.out.println("Title Found:");
                        printMedia(title);
                        System.out.println("");
                        break;
                    }
                }
            }
            if(!found){
                System.out.println("Call number not found");
            }
        }
        else{
            System.out.println("Invalid Call Number. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
        }
    }

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
            System.out.println("No titles found");
        }

    }

    public static void findMedia(int year, Catalog[] catalog){
        int num = 0;
        if(year > 1900 && year < 2022){
            System.out.println("Titles Found:");
            for (Catalog title : catalog) {
                if (title != null) {
                    if(year == title.getYear()){
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

    public static int index = 21;
    public static void add(Catalog[] list, Catalog obj) {
        for (int i = 0; i < list.length; i++) {
            if(list[i]==null){
                list[i] = obj;
                break;
            }
        }
    }

    public static void remove(Catalog[] list, String callN){
        if(callN.matches("[B-P]-\\d{3}-\\d{3}-\\d{3}")) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] != null) {
                    if (list[i].getCall().equals(callN)) {
                        for (int j = i; j < list.length; j++) {
                            if (j < 49) {
                                list[j] = list[j + 1];
                            }
                        }
                        break;
                    }
                }
            }
            System.out.println("Title not found\n");
        }
        else{
            System.out.println("Invalid Call Number\n");
        }
    }

    public boolean isRestorable(){
        return (2022 - this.getYear() > 20);
    }




}
