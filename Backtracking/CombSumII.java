import java.util.*;
import java.Arrays.sort;

public class CombSumII{
   private void helper(int candidates[], int target, List<Integer> curr, List<List<Integer>> ans, int idx){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(candidates[i] > target) break;
            if(i > idx && candidates[i] == candidates[i-1]) continue;

            curr.add(candidates[i]);
            helper(candidates, target-candidates[i], curr, ans, i+1);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        helper(candidates, target, curr, ans, 0);
        return ans;
    }   
}