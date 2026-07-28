public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for(int i=0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) return -1;
        int rem = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            rem += (gas[i]-cost[i]);
            if(rem < 0){
                start = i+1;
                rem = 0;
            }    
        }
        return start;
    }
}
