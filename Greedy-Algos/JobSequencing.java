import java.util.*;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void printJobSequence(ArrayList<Job> jobs) {
        // 1. Sort jobs by profit descending: O(N log N)
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // 2. Schedule slots: O(N * D)
        
        char[] result = new char[maxDeadline + 1];
        boolean[] slots = new boolean[maxDeadline + 1];
        int totalProfit = 0;

        for (Job job : jobs) {
            // Find a free slot from the job's deadline back to 1
            for (int i = job.deadline; i > 0; i--) {
                if (!slots[i]) {
                    slots[i] = true;
                    result[i] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Output results
        System.out.print("Job Sequence: ");
        for (char id : result) {
            if (id != '\0') System.out.print(id + " ");
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job('A', 2, 100));
        jobs.add(new Job('B', 1, 19));
        jobs.add(new Job('C', 2, 27));
        jobs.add(new Job('D', 1, 25));
        jobs.add(new Job('E', 3, 15));

        printJobSequence(jobs);
    }
}