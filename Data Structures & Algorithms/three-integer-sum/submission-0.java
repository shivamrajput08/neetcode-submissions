class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       int n = nums.length;

       if(n < 3) return result ;

       Arrays.sort(nums);

       for(int i = 0 ; i < n ; i++){
        if(i > 0 && nums[i] == nums[i-1] ) continue;

        int n1 = nums[i];
        int target = -n1;

        twoSum(nums, i+1 , n-1 , target , n1 , result);
       } 
       return result;
    }
    private void twoSum(int[] nums , int left , int right , int target , int n1, List<List<Integer>> result ){

       while(left < right){
        int sum = nums[left] + nums[right];

        if(sum < target){
            left++;
        }else if(sum > target){
            right--;
        }
        else{
            result.add(Arrays.asList(n1,nums[left],nums[right]));

            left++;
            right--;

            while(left < right && nums[left] == nums[left-1]) left++;
            while(left < right && nums[right] == nums[right+1]) right--;
        }
       } 
    }
}
