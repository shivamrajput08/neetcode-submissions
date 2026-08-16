class Solution {
    public void solve(int[] nums , int target , List<Integer> curr , List<List<Integer>> result , int idx){
        if(target < 0 ) return;
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return ;
        }
        for(int i = idx ;i<  nums.length ; i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            solve(nums, target - nums[i] , curr , result , i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    public  List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums , target , curr , result , 0);
        return result;
    }
}
