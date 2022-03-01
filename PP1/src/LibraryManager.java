import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Test class to implement classes
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 19, 2021
 * Last Date Modified: Februrary 28, 2021
 */
public class LibraryManager {
    public static void main(String[] args) {
        Catalog[] catalogList = new Catalog[50];
        File file = new File("titles.txt");

        try{
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()){
                String callNum = readFile.nextLine();
                String title = readFile.nextLine();
                String publisher = readFile.nextLine();
                String yearString = readFile.nextLine();
                int year = Integer.parseInt(yearString);
                String copiesString = readFile.nextLine();
                int copies = Integer.parseInt(copiesString);
                String monthOrAuthor = readFile.nextLine();
                String issueOrIBSN = readFile.nextLine();


                if(callNum.charAt(0) == ('B')){
                    String type = "Book";
                    long IBSN = Long.parseLong(issueOrIBSN);
                    Catalog addition = new Book(title, publisher, year, copies, type, callNum, monthOrAuthor, IBSN);
                    Catalog.add(catalogList, addition);
                }
                else if(callNum.charAt(0) == ('P')){
                    String type = "Periodical";
                    int issue = Integer.parseInt(issueOrIBSN);
                    int month = Integer.parseInt(monthOrAuthor);
                    Catalog addition = new Periodical(title, publisher, year, copies, type, callNum, month, issue);
                    Catalog.add(catalogList, addition);
                }
            }
            readFile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Cannot find file");
        }

        boolean running = true;
        while(running){
            System.out.println("Select an operation:\n" +
                    "1: View all titles\n" +
                    "2: Search by call number\n" +
                    "3: Search by title\n" +
                    "4: Search by year\n" +
                    "5: Add new title\n" +
                    "6: Remove title\n" +
                    "7: Sort titles by year\n" +
                    "8: View Titles due for restoration\n" +
                    "9: Exit and save changes\n");

            Scanner scnr = new Scanner(System.in);
            int choice = scnr.nextInt();
            switch (choice) {
                // view all titles
                case 1:
                    System.out.printf("%-30s\t%-45s\t%-30s\t%-30s\n","Call Number", "Title", "Publisher", "Year");
                    for (Catalog catalog : catalogList) {
                        if (catalog != null) {
                            Catalog.printMedia(catalog);
                        }
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Enter a call number:");
                    Scanner scanNum = new Scanner(System.in);
                    String callNumInput = scanNum.next();
                    Catalog.findMedia(callNumInput, catalogList);
                    break;
                    // title dont work
                case 3:
                    System.out.println("Enter a title:");
                    Scanner scanTitle = new Scanner(System.in);
                    String titleInput = scanTitle.nextLine();
                    Catalog.findByTitle(titleInput, catalogList);
                    break;
                case 4:
                    System.out.println("Enter a year:");
                    Scanner scanYear = new Scanner(System.in);
                    int yearInput = scanYear.nextInt();
                    Catalog.findMedia(yearInput, catalogList);
                    break;
                case 5:
                    System.out.println("Enter the title");
                    Scanner title = new Scanner(System.in);
                    String titleAdded = title.nextLine();

                    System.out.println("Enter the publisher");
                    Scanner pub = new Scanner(System.in);
                    String pubAdded = pub.nextLine();

                    int yearAdded = 0;
                    try {
                        System.out.println("Enter the year of publication");
                        Scanner year = new Scanner(System.in);
                        int yearIn = year.nextInt();
                        if (yearIn < 1900 || yearIn > 2022) {
                            throw new InvalidInputException();
                        }
                        else{
                            yearAdded = yearIn;
                        }
                    }
                    catch(InvalidInputException e){
                        System.out.println("Invalid year: must be between 1900 and 2022\n");
                        break;
                    }

                    System.out.println("Enter the number of copies");
                    Scanner num = new Scanner(System.in);
                    int numCopAdded = num.nextInt();

                    String typeAdded = "";
                    try {
                        System.out.println("Enter the type of title (Book/Periodical)");
                        Scanner type = new Scanner(System.in);
                        String typeOf = type.next();
                        if (!typeOf.matches("(?i)Book|Periodical")) {
                            throw new InvalidInputException();
                        }
                        else{
                            typeAdded = typeOf;
                        }
                    }
                    catch(InvalidInputException e){
                        System.out.println("Invalid type: must be Book or Periodical\n");
                        break;
                    }

                    if(typeAdded.equals("Book")){
                        String callNumber = "";
                        try {
                            System.out.println("Enter the call number (B-ddd-ddd-ddd):");
                            Scanner call = new Scanner(System.in);
                            String callNumb = call.next();
                            if (!callNumb.matches("[B]-\\d{3}-\\d{3}-\\d{3}")) {
                                throw new InvalidInputException();
                            }
                            else{
                                callNumber = callNumb;
                            }
                        }
                        catch(InvalidInputException e){
                            System.out.println("Invalid call number must be (B-ddd-ddd-ddd)\n");
                            break;
                        }

                        System.out.println("Enter the author");
                        Scanner author = new Scanner(System.in);
                        String authorfind = author.nextLine();

                        long IBSN = 0;
                        try {
                            System.out.println("Enter the IBSN (10 digits)");
                            Scanner ibsn = new Scanner(System.in);
                            String ibsnInput = ibsn.next();
                            if (!ibsnInput.matches("\\d{10}")) {
                                throw new InvalidInputException();
                            }
                            else{
                                IBSN = Long.parseLong(ibsnInput);
                            }
                        }
                        catch(InvalidInputException e){
                            System.out.println("Invalid entry: must be ten digits\n");
                            break;
                        }

                        Catalog welit = new Book(titleAdded, pubAdded, yearAdded, numCopAdded, typeAdded, callNumber, authorfind, IBSN);
                        Catalog.add(catalogList, welit);
                        System.out.println("Book Added Successfully");
                    }
                    else if(typeAdded.equals("Periodical")) {
                        String callNumber = "";
                        try {
                            System.out.println("Enter the call number (P-ddd-ddd-ddd):");
                            Scanner call = new Scanner(System.in);
                            String callNumb = call.next();
                            if (!callNumb.matches("[P]-\\d{3}-\\d{3}-\\d{3}"))
                                throw new InvalidInputException();
                            else{
                                callNumber = callNumb;
                            }
                        }
                        catch(InvalidInputException e){
                            System.out.println("Invalid call number must be (P-ddd-ddd-ddd)\n");
                            break;
                        }

                        int monthAdded = 0;
                        try {
                            System.out.println("Enter the month");
                            Scanner month = new Scanner(System.in);
                            String monthInput = month.next();
                            if (!monthInput.matches("^[1-9][0-9]?$|^12$")) {
                                throw new InvalidInputException();
                            }
                            else{
                                monthAdded = Integer.parseInt(monthInput);
                            }
                        }
                        catch(InvalidInputException e){
                            System.out.println("Invalid month: must be between 1 and 12\n");
                            break;
                        }

                        System.out.println("Enter the issue");
                        Scanner issue = new Scanner(System.in);
                        int issueAdded = issue.nextInt();


                        Catalog welit = new Periodical(titleAdded, pubAdded, yearAdded, numCopAdded, typeAdded, callNumber, monthAdded, issueAdded);
                        Catalog.add(catalogList, welit);
                        System.out.println("Periodical Added Successfully");
                    }
                    break;
                case 6:
                    System.out.println("Enter a call number:");
                    Scanner callNummy = new Scanner(System.in);
                    String callNummyinput = callNummy.next();
                    Catalog.remove(catalogList, callNummyinput);
                    break;
                case 7:
                    int nums = 0;
                    for (Catalog catalog : catalogList) {
                        if (catalog != null) {
                            nums++;
                        }
                    }
                    Catalog[] newCat = new Catalog[nums];
                    for (int i = 0; i < newCat.length; i++) {
                        newCat[i] = catalogList[i];
                    }
                    Arrays.sort(newCat);
                    for (int i = 0; i < newCat.length; i++) {
                        catalogList[i] = newCat[i];
                    }
                    break;
                case 8:
                    for (Catalog catalog : catalogList) {
                        if (catalog != null) {
                            if (catalog.isRestorable()) {
                                Catalog.printMedia(catalog);
                            }
                        }
                    }
                    break;
                case 9:
                    System.out.println("Changes saved to title.txt");

                    try{
                        PrintWriter printit = new PrintWriter(file);
                        for (Catalog catalog : catalogList) {
                            if (catalog != null) {
                                printit.println(catalog.getCall());
                                printit.println(catalog.getTitle());
                                printit.println(catalog.getPublisher());
                                printit.println(catalog.getYear());
                                printit.println(catalog.getCopies());

                                if (catalog.getType().equalsIgnoreCase("Book")) {
                                    Book it = (Book) catalog;
                                    printit.println(it.getAuthor());
                                    printit.println(it.getIBSN());
                                }
                                else if (catalog.getType().equalsIgnoreCase("Periodical")) {
                                    Periodical it = (Periodical) catalog;
                                    printit.println(it.getMonth());
                                    printit.println(it.getIssue());
                                }
                            }
                        }
                        printit.close();
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("Cannot find file");
                    }

                    running = false;
                    break;
                default:
                    System.out.println("Invalid operation. Try Again");
            }
        }
    }
}
