import java.util.*;

public class SJF {

  public static void main(String[] args) {
    // Create a list of processes.
    List<Process> processes = Arrays.asList(
        new Process(1, 5),
        new Process(2, 3),
        new Process(3, 2)
    );

    // Sort the processes in increasing order of burst time.
    Collections.sort(processes, (p1, p2) -> p1.burst_time - p2.burst_time);

    // Initialize the current time to 0.
    int current_time = 0;

    // While there are still processes to be scheduled, do the following:
    for (Process process : processes) {
      // Increment the current time by the burst time of the process.
      current_time += process.burst_time;

      // Print the process information.
      System.out.println("Process " + process.id + " finished at time " + current_time);
    }
  }
}

class Process {

  int id;
  int burst_time;

  public Process(int id, int burst_time) {
    this.id = id;
    this.burst_time = burst_time;
  }
}
