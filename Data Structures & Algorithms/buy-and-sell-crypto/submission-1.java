class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int mini = nums[0];
        int profit = 0;
        for(int i = 0 ; i < n ; i++){
            int cost = nums[i] - mini;
            profit = Math.max(profit , cost);
            mini = Math.min(mini,nums[i]);
        }
        return profit;
    }
}
