// class Solution {
//     public boolean hasDuplicate(int[] nums) {
        
//         int n = nums.length;
//         for(int i = 0 ; i < n ; i++){
//             for(int j = i + 1 ; j <  n ; j++){
//                 if(nums[i] == nums[j]){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }
// class Solution {
//     public boolean hasDuplicate(int[] nums) {
        
//         Arrays.sort(nums);
//         int n = nums.length;
//         for(int i = 1 ; i < n ; i++){
//             if(nums[i] == nums[i - 1]){
//                 return true;
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean hasDuplicate(int[] nums) {
        
    Set<Integer> intSet = new HashSet<>();
    for(int num : nums){
      if(intSet.contains(num)){
        return true;
      }
      intSet.add(num);
     
    }
    return false;
    }
}