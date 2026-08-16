class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       List<List<Integer>> list = new ArrayList<>();
       combSum(list , new ArrayList<>() , nums , 0 , target);
       return list; 
    }

    public void combSum(List<List<Integer>> list , List<Integer> temp , int[] nums, int start , int target){
        if(target == 0){
            list.add(new ArrayList<>(temp));
            return ;
        }
        for(int i = start ; i < nums.length ; i++){
            if(target < nums[i])  continue;

            temp.add(nums[i]);
            combSum(list , temp  , nums , i , target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
