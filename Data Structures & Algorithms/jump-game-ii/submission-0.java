class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jump = 0;
        int maxind = 0;
        int currend = 0 ;
        for(int i = 0 ; i < n-1 ; i++){
            maxind = Math.max(maxind , i + nums[i]);
            if(i == currend){
                jump++;
                currend = maxind;
            }
        }
        return jump;
    }
}
