import java.util.Scanner;

public class SeatReservation {
    public static void main(String[] args) {
        Airplane myAirplane = new Airplane("seatsmap.txt");
        Scanner keyboard = new Scanner(System.in);
        System.out.println(myAirplane);
        int operation = 0;
        String seatNumber;
        do{
            try{
            System.out.println(myAirplane);
            printMenu();
            operation = keyboard.nextInt();
            switch(operation){
                case 1: // reserve a seat
                    System.out.println("Enter the seat number ([1-9][A-H])");
                    seatNumber = keyboard.next();
                    if(myAirplane.reserveSeat(seatNumber)){
                        System.out.println("Seat reserved successfully");
                    }
                    else{
                        System.out.println("Seat already reserved");
                    }
                    break;
                case 2: // free a seat
                    System.out.println("Enter the seat number ([1-9][A-H])");
                    seatNumber = keyboard.next();
                    if(myAirplane.freeSeat(seatNumber)){
                        System.out.println("Seat freed successfully");
                    }
                    else{
                        System.out.println("Seat already free");
                    }
                    break;
                case 3: // exit
                    myAirplane.saveMap("seatsmap.txt");
                    break;
                }
            }
            catch(InvalidSeatException e){
                System.out.println(e.getMessage());
            }
        }
        while(operation != 3);
    }

    public static void printMenu() {
        System.out.println("Select an operation:");
        System.out.println("1: Reserve a seat");
        System.out.println("2: Free a seat");
        System.out.println("3: Exit the program");
    }
}
