import java.util.Arrays;

public class BankersAlgorithm {

    private int[] available;
    private int[][] max;
    private int[][] allocation;
    private int numofProcesses;
    private int numofResources;

    public BankersAlgorithm(int[] available, int[][] max, int[][] allocation) {

    this.available = available.clone(); 
    this.max = max.clone();
    this.allocation = allocation.clone();
    this.numofProcesses = allocation.length;
    this.numofResources = available.length;
    }
   public boolean isSafe() {
        int[] work=available.clone();
        boolean[] finish = new boolean[numofProcesses];
          for (int i = 0; i < numofProcesses; i++) {
          if (finish[i]) continue;

          boolean canAllocate = true;
          for (int j=0; j< numofResources; j++) {
                if (max[i][j] -allocation[i][j]> work[j]){
               canAllocate =false;
               break;
            }
            }
        if(canAllocate){
          for(int j=0;j<numofResources;j++){
            work[j]+=allocation[i][j];
        }
          finish[i]=true;
          break;
        }
    }
    for(boolean f:finish){
          if(!f){
            return false;
        }
    }
        return true;
    }
        public static void main(String[] args) { 
            int[] available = {3, 3, 2};
            int[][] max={{117, 5, 3}, {3, 2, 2}, {9,0,2}, {2,2,2}, {4,3,31}};
            int[][] allocation={{0, 1, 0}, {2, 0, 0}, {3, 4,2}, {2, 4, 1}, {4, 6,2}};
            BankersAlgorithm banker= new BankersAlgorithm(available, max, allocation);
            boolean safe=banker.isSafe();
            System.out.println(safe? "System is in a safe state." : "System is in an unsafe state.");
        }
}