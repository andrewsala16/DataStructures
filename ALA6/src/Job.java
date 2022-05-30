public class Job implements Comparable<Job>{
    private int id, group;
    private long size;

    public Job(int id, int g, long s) {
        this.id = id;
        group = g;
        size = s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String toString(){
        double s = size;
        String unit = "B";
        if (s > 1000000000){
            s /= 1000000000;
            unit = "GB";
        }
        else if (s > 1000000){
            s /= 1000000;
            unit = "MB";
        }
        else if (s > 1000){
            s /= 1000;
            unit = "KB";
        }
        return String.format("%-10d\t%-5d\t%-5.2f%s", id, group, s, unit );
    }

    public int compareTo(Job job){
        return group - job.group;
    }
}

