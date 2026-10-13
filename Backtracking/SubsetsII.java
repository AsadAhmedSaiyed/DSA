public class SubsetsII{
    private void helper(int idx, List<List<Integer>> ans, List<Integer> curr, int nums[]){
        if(idx == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        helper(idx+1, ans, curr, nums);
        curr.remove(curr.size()-1);
        while(idx+1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }
        helper(idx+1, ans, curr, nums);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, ans, curr, nums);
        return ans;
    }
}