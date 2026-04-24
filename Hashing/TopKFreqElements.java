import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//BF TC - O(NlogN) SC - O(N) for hashmap and arraylist
// 2 approaches - using heap and quick select or bucket sort
class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i], m.getOrDefault(nums[i],0)+1);
        }
        ArrayList<int []> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
            arr.add(new int[]{entry.getKey(),entry.getValue()});
        }
        arr.sort((a,b)-> Integer.compare(b[1],a[1]));
        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i] = arr.get(i)[0];
        }
        return res;
    }
}