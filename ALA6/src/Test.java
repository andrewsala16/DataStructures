import java.util.PriorityQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Job> printerQueue = new PriorityQueue<>();
        readJobs(printerQueue, "jobs.txt");
        long printerSpeed = 10000;
        long totalTime = 0;
        long totalSize = 0;
        while(!printerQueue.isEmpty()){
            Job job = printerQueue.poll();
            String time = calcTime(job.getSize(), printerSpeed);
            System.out.printf("%s\t\t%s\n", job.toString(), time);
            totalSize += job.getSize();
        }
        System.out.println("Total Printing Time: " + calcTime(totalSize, printerSpeed));
    }

    public static String calcTime(long size, long speed){
        long time = size/speed;
        int days = 0, hours = 0, minutes = 0, seconds = 0;
        String out = "";
        if (time > 86400){
            days = (int)(time/84600);
            time = (int)(time%86400);
            if(days < 10){
                out += "0" + days + ":";
            }
            else{
                out += days + ":";
            }
        }
        else{
            out += "00:";
        }

        if (time > 3600){
            hours = (int)(time/3600);
            time = (int)(time%3600);
            if(hours < 10){
                out += "0" + hours + ":";
            }
            else{
                out += hours + ":";
            }
        }
        else{
            out += "00:";
        }

        if (time > 60){
            minutes = (int)(time/60);
            time = (int)(time%60);
            if(minutes < 10){
                out += "0" + minutes + ":";
            }
            else{
                out += minutes + ":";
            }
        }
        else{
            out += "00:";
        }
        seconds = (int)Math.round(time);
        if (seconds < 10){
            out += "0" + seconds;
        }
        else{
            out += seconds;
        }
        return out;
    }

    public static void readJobs(PriorityQueue<Job> pq, String filename){
        File file = new File(filename);
        Scanner readFile = null;
        try{
            readFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        }

        while(readFile.hasNext()){
            int id = readFile.nextInt();
            int group = readFile.nextInt();
            long size = readFile.nextLong();
            Job job = new Job(id, group, size);
            pq.offer(job);
        }
        readFile.close();

    }


}

