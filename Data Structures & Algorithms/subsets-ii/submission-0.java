class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(nums);
       backtrack(result , new ArrayList<>() , nums , 0);
       return result; 
    }
    private void backtrack(List<List<Integer>> result , List<Integer> tempSet , int[]  nums , int start){
        if(result.contains(tempSet))return ;

        result.add(new ArrayList<>(tempSet));
        for(int i = start ; i < nums.length ; i++){
            tempSet.add(nums[i]);
            backtrack(result , tempSet , nums , i+ 1);
            tempSet.remove(tempSet.size() - 1);
        }
  }
}
