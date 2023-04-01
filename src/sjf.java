
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

public class sjf {
    private int[] processIds;
    private int[] arrivalTime;
    private int[] burstTime;
    private int numProcesses;
    private int[] turnaroundTimes;
    private int[] waitingTimes;
    private int[] remainingTimes;
    private int[] completionTimes;
    private int[] startTimes;
    private double averageTurnaroundTime;
    private double averageWaitingTime;
    ArrayList<Integer> sortedPids = new ArrayList<>();

    
    public sjf(int[] arrivalTime, int[] burstTime, int numProcesses) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.numProcesses = numProcesses;
        this.turnaroundTimes = new int[numProcesses];
        this.waitingTimes = new int[numProcesses];
        this.remainingTimes = new int[numProcesses];
        this.completionTimes = new int[numProcesses];
        this.startTimes = new int[numProcesses];
        for (int i = 0; i < numProcesses; i++) {
            this.remainingTimes[i] = burstTime[i];
        }
        String res = getGanttChart();
        calculate();
    }
    
    public int[] getArrivalTimes() {
        return arrivalTime;
    }
    
    public int[] getBurstTimes() {
        return burstTime;
    }
    
    public int[] getTurnaroundTimes() {
        return turnaroundTimes;
    }
    
    public int[] getWaitingTimes() {
        return waitingTimes;
    }

    public int[] getCompletionTimes() {
        return completionTimes;
    }

    public int[] getStartTimes() {
        return startTimes;
    }

    public int[] getProcessIds() {
        return processIds;
    }

    public double getAverageTurnaroundTime() {
        return averageTurnaroundTime;
    }

    public double getAverageWaitingTime() {
        return averageWaitingTime;
    }
    
    public String getGanttChart() {
        StringBuilder sb = new StringBuilder();
        int currentTime = 0;
        int[] completed = new int[numProcesses];
        int completedCount = 0;

        while (completedCount < numProcesses) {
            int minRemainingTime = Integer.MAX_VALUE;
            int nextProcess = -1;
            // find the process with shortest burst time which arrived already
            for (int i = 0; i < numProcesses; i++) {
                if (arrivalTime[i] <= currentTime && completed[i] == 0 && remainingTimes[i] < minRemainingTime) {
                    minRemainingTime = remainingTimes[i];
                    nextProcess = i;
                }
            }
            // if there is none at one time instance, system is idle
            if (nextProcess == -1) {
                sb.append("-");
                // let time pass
                currentTime++;
            } else {
                // run the process with shortest burst time till completion
                sortedPids.add(nextProcess);
                sb.append("P" + (nextProcess+1));
                currentTime += remainingTimes[nextProcess];
                completionTimes[nextProcess] = currentTime;
                remainingTimes[nextProcess] = 0;
                completed[nextProcess] = 1;
                completedCount++;
            }
        }
        return sb.toString();
    }
    
    public void calculate() {
        int[] turnaroundTime = new int[numProcesses];
        int[] waitingTime = new int[numProcesses];
        int[] startTime = new int[numProcesses];
        int[] pids = new int[numProcesses];
        pids = sortedPids.stream().mapToInt(Integer::intValue).toArray();
        int index = numProcesses;
        for (int i = 0; i < numProcesses; i++) {
            turnaroundTime[index-i-1] = completionTimes[i] - arrivalTime[i];
            waitingTime[index-i-1] = turnaroundTime[index-i-1] - burstTime[i];
            startTimes[i] = arrivalTime[i];
        }
        this.turnaroundTimes = turnaroundTime;
        this.waitingTimes = waitingTime;
        this.startTimes = startTime;
        this.processIds = pids;
        completionTimes = IntStream.range(0,completionTimes.length).boxed()
        .sorted(Comparator.comparing(i->arrivalTime[i]))
        .mapToInt(i -> completionTimes[i])
        .toArray();
        averageWaitingTime = IntStream.range(0,waitingTimes.length).boxed()
            .mapToInt(i -> waitingTimes[i]).average().orElse(0.0);
        averageTurnaroundTime = IntStream.range(0,turnaroundTimes.length).boxed()
            .mapToInt(i -> turnaroundTimes[i]).average().orElse(0.0); 
    }

    public static void main(String[] args){
        int[] bursts = {1,2,3,4};
        int[] arrivals = {4,3,2,1};
        sjf test_sjf = new sjf(arrivals, bursts, bursts.length);
        //System.out.println(test_sjf.getGanttChart());
        System.out.println("Processes");
        
        int[] arrs = test_sjf.getProcessIds();
        for(int i = 0; i < arrs.length; i++){
            System.out.print(arrs[i] + " ");
        }
        System.out.println("\nArrivals");
        arrs = test_sjf.getArrivalTimes();
        for(int i = 0; i < arrs.length; i++){
            System.out.print(arrs[i] + " ");
        }
        System.out.println("\nBurst Times");
        arrs = test_sjf.getBurstTimes();
        for(int i = 0; i < arrs.length; i++){
            System.out.print(arrs[i] + " ");
        }
        System.out.println("\nStart Times");
        arrs = test_sjf.getStartTimes();
        for(int i = 0; i < arrs.length; i++){
            System.out.print(arrs[i] + " ");
        }
        System.out.println("\nCompletion Times");
        arrs = test_sjf.getCompletionTimes();
        for(int i = 0; i < arrs.length; i++){
            System.out.print(arrs[i] + " ");
        }
        System.out.println("\nWaiting Times");
        arrs = test_sjf.getWaitingTimes();
        for(int i = 0; i < arrs.length; i++){
            System.out.print(arrs[i] + " ");
        }
        System.out.println("\nTurnaround Times");
        arrs = test_sjf.getTurnaroundTimes();
        for(int i = 0; i < arrs.length; i++){
            System.out.print(arrs[i] + " ");
        }
        System.out.println("\nAverage Waiting Time: "+test_sjf.getAverageWaitingTime());
        System.out.println("Average Turnaround Time: "+test_sjf.getAverageTurnaroundTime());
    }
}
