import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
/**
 * Class to model airport
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: March 25, 2021
 * Last Date Modified: March 28, 2021
 */
public class AirportSimulation {
    public static void main(String[] args) {
        Queue<Integer> landing = new LinkedList<>();
        Queue<Integer> takeOff = new LinkedList<>();


        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the simulation parameters:");
        System.out.print("Simulation duration (minutes): ");
        int simTime = scan.nextInt();
        System.out.print("Takeoff time (minutes): ");
        int takeOffTime = scan.nextInt();
        System.out.print("Landing time (minutes): ");
        int landingTime = scan.nextInt();
        System.out.print("Takeoff rate (# per hour): ");
        double takeoffRate = scan.nextDouble();
        System.out.print("Landing rate (# per hour): ");
        double landingRate = scan.nextDouble();

        System.out.println("\nSimulation parameters\n" +
                "Simulation time: " + simTime + " minutes\n" +
                "Landing rate: " + (int)landingRate + " airplanes/hour\n" +
                "Landing time: " + landingTime + " minutes\n" +
                "Takeoff rate: " + (int)takeoffRate + " airplanes/hour\n" +
                "Takeoff time: " + takeOffTime + " minutes\n");

        double landingRequests = 0;
        double takeoffRequests = 0;
        double totalLandingTime = 0;
        double totalTakeoffTime = 0;
        double landingQueueSizes = 0;
        double takeoffQueueSizes = 0;

        int runway = 0;
        for (int currentTime = 0; currentTime < simTime; currentTime++) {
            landingQueueSizes += landing.size();
            takeoffQueueSizes += takeOff.size();
            // simulating arrival of landing requests
            Random rand = new Random();
            int landingNum = rand.nextInt(2);
            if (landingNum < (landingRate / 60)) {
                landingRequests++;
                landing.offer(currentTime);
                //add a landing request to the landing queue (add the current time)
            }

            // simulating arrival of takeoff requests
            Random randy = new Random();
            int takeoffNum = randy.nextInt(2);
            if (takeoffNum < (takeoffRate / 60)) {
                takeoffRequests++;
                takeOff.offer(currentTime);
                // add a takeoff request to the takeoff queue (add the current time)
            }

            // simulating the landing/takeoff operations
            if (runway == 0){
                if (!landing.isEmpty()){
                    int waitTime = currentTime - landing.poll();
                    runway += landingTime;
                    totalLandingTime += waitTime;
                }
                if (!takeOff.isEmpty()){
                    int waitTime2 = currentTime - takeOff.poll();
                    runway += takeOffTime;
                    totalTakeoffTime += waitTime2;
                }
            }
            else{
                runway--;
            }
        }



        System.out.println("Simulation Output");
        System.out.println(takeoffRequests);
        System.out.println(landingRequests);
        System.out.println(landingRequests);
        System.out.println(landingQueueSizes);
        System.out.println(takeoffQueueSizes);
        System.out.println(totalLandingTime);
        System.out.println(totalTakeoffTime);
        try {
            System.out.println("Total number of Landing Requests: " + landingRequests +
                    "\nTotal number of Takeoff Requests: " + takeoffRequests + "\n" +
                    "\n" +
                    "Average Waiting Time for Landing Airplanes is " + (totalLandingTime / landingRequests) + " minutes\n" +
                    "Average number of waiting landing requests: " + (landingQueueSizes / simTime) + " landing requests\n" +
                    "\n" +
                    "Average Waiting Time for Taking off Airplanes is " + (totalTakeoffTime / takeoffRequests) + " minutes\n" +
                    "Average number of waiting takeoff requests: " + (takeoffQueueSizes / simTime) + " takeoff requests\n" +
                    "\n" +
                    "\n" +
                    "Number of landing requests remaining in the Queue (never served): " + landing.size() + "\n" +
                    "Number of Takeoff requests remaining in the Queue (never served): " + takeOff.size() + "\n" +
                    "\n");
        }
        catch (ArithmeticException e) {
            System.out.println("P");
        }
    }
}
