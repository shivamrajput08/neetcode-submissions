// Brute 
// class Solution {
//     public int findDuplicate(int[] nums) {
//        int n = nums.length;
//        Arrays.sort(nums);
//        for(int i = 0 ; i < n ; i++){
//         if(nums[i] == nums[i+1]){
//             return nums[i+1];
//         }
//        } 
//        return -1;
//     }
// }

class Solution {
    public int findDuplicate(int[] nums) {
       int slow = nums[0];
       int fast = nums[0];

       do{
        slow = nums[slow];
        fast = nums[nums[fast]];
       }
       while(slow != fast);
       fast = nums[0];
       while(slow != fast ){
        slow = nums[slow ];
        fast = nums[fast];
       }
       return slow ;
    }
}

