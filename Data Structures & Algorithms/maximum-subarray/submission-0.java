class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int curr = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            curr += nums[i];
            maxi = Math.max(curr,maxi);
            if(curr < 0){
                curr = 0;
            }
        }
        return maxi;
    }
}
