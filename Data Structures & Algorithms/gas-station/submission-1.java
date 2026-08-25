class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0;
        int totalcost = 0;
        for(int i = 0 ; i < gas.length ; i++) totalgas += gas[i];
        for(int j = 0 ; j < cost.length ; j++) totalcost += cost[j];
        if(totalgas < totalcost) return -1;
        int totalfuel = 0 , startind = 0;
        for(int k = 0 ; k < gas.length ; k++){
            totalfuel += gas[k] - cost[k];
            if(totalfuel < 0){
                startind = k+1;
                totalfuel = 0;
            }
        }
        return startind;
    }
}
