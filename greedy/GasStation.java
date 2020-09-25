package leetcode.greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalGas = 0;
        int totalCost = 0;
        int netCost = 0;
        int[] gasToBeCollected = new int[cost.length];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            netCost += gas[i]-cost[i];
            min = Math.min(min, netCost);
            
        }
        
        for(int i = gas.length-1; i>+0; i--){
            if(i== gas.length-1){
                
                gasToBeCollected[i] = gas[i] - cost[i];
            }
            else{
                gasToBeCollected[i] = gasToBeCollected[i+1] + gas[i] - cost[i] ;
            }
        }
        
        if(totalCost>totalGas){
            return -1;
        }
        
        
        for(int i=cost.length-1; i>=0; i--){
            if(-min<=gasToBeCollected[i]){
                return i;
            }
        }
        
        return -1;
        
    }

    public static void main(String[] args) {
        int[]gas = {1,2,3,4,5};
        int[]cost = {3,4,5,1,2};

        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
}
