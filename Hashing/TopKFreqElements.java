import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
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
    }//TC - O(NlogK) SC - O(N) for hashmap and heap
    public int[] topKFrequent2(int[] nums, int k) {
        int ans[] = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i], m.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
           pq.add(entry);
           if(pq.size()> k){
              pq.remove();
           }
        }
        for(int i=0;i<k;i++){
            ans[i] = pq.remove().getKey();
        }
        return ans;
    }
    //TC - O(N) SC - O(N) for hashmap and buckets
    public int[] topKFrequent3(int[] nums, int k) {
        int ans[] = new int[k];
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i], m.getOrDefault(nums[i],0)+1);
        }
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }
        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
            int bIdx = entry.getValue();
            ArrayList<Integer> bucket = buckets.get(bIdx);
            bucket.add(entry.getKey());
        }
        int pos=0;
        for(int i=buckets.size()-1;i>=0 && pos < k;i--){
           ArrayList<Integer> bucket = buckets.get(i);
           if(bucket.size()>0){
              for(int j=0;j<bucket.size() && pos< k;j++){
                 ans[pos] = bucket.get(j); 
                 pos++;
              }
           }
        }
        return ans;
    }
}