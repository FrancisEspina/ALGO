
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
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
    ArrayList<Integer> pids = new ArrayList<>();

    
    public sjf(int[] arrivalTime, int[] burstTime, int numProcesses) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.numProcesses = numProcesses;
        this.turnaroundTimes = new int[numProcesses];
        this.waitingTimes = new int[numProcesses];
        this.remainingTimes = new int[numProcesses];
        this.completionTimes = new int[numProcesses];
        this.startTimes = new int[numProcesses];
        
        this.processIds = IntStream.range(0,arrivalTime.length).boxed()
        .sorted(Comparator.comparing(i->this.arrivalTime[i]))
        .mapToInt(Integer::intValue)
        .toArray();

        for(int i : processIds){
            pids.add(i);
        }

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
        ArrayList<Integer> firstExecs = new ArrayList<>();

        while (completedCount < numProcesses) {
            int minRemainingTime = Integer.MAX_VALUE;
            int nextProcess = -1;
            int minArrival = Integer.MAX_VALUE;
            // find the process with shortest burst time which arrived already and not completed
            for (int i = 0; i < numProcesses; i++) {
                if (arrivalTime[i] <= currentTime && completed[i] == 0 && remainingTimes[i] <= minRemainingTime) {
                        // get the least arrival time
                        if(minRemainingTime == remainingTimes[i]){
                            if(arrivalTime[i] < minArrival){
                                minArrival = arrivalTime[i];
                                minRemainingTime = remainingTimes[i];
                                nextProcess = i;
                            }
                        }else{
                            minArrival = arrivalTime[i];
                            minRemainingTime = remainingTimes[i];
                            nextProcess = i;
                        }
                }
            }
            // if there is none at one time instance, system is idle
            if (nextProcess == -1) {
                sb.append("-");
                // let time pass
                currentTime++;
            } else {
                // save the first runtime of a process
                if(remainingTimes[nextProcess] == burstTime[nextProcess]){
                    firstExecs.add(currentTime);
                }
                // run the process with shortest burst time till completion
                sortedPids.add(nextProcess);
                sb.append("P" + nextProcess);
                currentTime += remainingTimes[nextProcess];
                completionTimes[nextProcess] = currentTime;
                remainingTimes[nextProcess] = 0;
                completed[nextProcess] = 1;
                completedCount++;
            }
        }
        startTimes = firstExecs.stream().mapToInt(Integer::intValue).toArray();
        return sb.toString();
    }
    
    public void calculate() {
        int[] turnaroundTime = new int[numProcesses];
        int[] waitingTime = new int[numProcesses];

        for (int i = 0; i < numProcesses; i++) {
            turnaroundTime[i] = completionTimes[i] - arrivalTime[i];
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
        }
        this.turnaroundTimes = turnaroundTime;
        this.waitingTimes = waitingTime;
        
        completionTimes = IntStream.range(0,completionTimes.length).boxed()
        .sorted(Comparator.comparing(i->arrivalTime[i]))
        .mapToInt(i -> completionTimes[i])
        .toArray();
        waitingTimes = IntStream.range(0,completionTimes.length).boxed()
        .sorted(Comparator.comparing(i->arrivalTime[i]))
        .mapToInt(i -> waitingTimes[i])
        .toArray();
        turnaroundTimes = IntStream.range(0,completionTimes.length).boxed()
        .sorted(Comparator.comparing(i->arrivalTime[i]))
        .mapToInt(i -> turnaroundTimes[i])
        .toArray();
        burstTime = IntStream.range(0,completionTimes.length).boxed()
        .sorted(Comparator.comparing(i->arrivalTime[i]))
        .mapToInt(i -> burstTime[i])
        .toArray();
        arrivalTime = IntStream.range(0,completionTimes.length).boxed()
        .sorted(Comparator.comparing(i->arrivalTime[i]))
        .mapToInt(i -> arrivalTime[i])
        .toArray();

        averageWaitingTime = IntStream.range(0,waitingTimes.length).boxed()
            .mapToInt(i -> waitingTimes[i]).average().orElse(0.0);
        averageTurnaroundTime = IntStream.range(0,turnaroundTimes.length).boxed()
            .mapToInt(i -> turnaroundTimes[i]).average().orElse(0.0); 
    }

    public static void main(String[] args){
        int[] bursts = {2,3,1,2,4};
        int[] arrivals = {1,3,2,4,5};
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
