import java.util.*;
import java.util.Arrays;
// BF 
//TC - O(N) SC - O(1)

class CPUScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> m = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<tasks.length;i++){
            m.put(tasks[i], m.getOrDefault(tasks[i],0)+1);
        }
        for(char ch : m.keySet()){
            pq.add(m.get(ch));
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int cycle = n+1;
            ArrayList<Integer> temp = new ArrayList<>();
            while(cycle>0 && !pq.isEmpty()){
                int currFreq = pq.remove();
                currFreq--;
                if(currFreq>0) temp.add(currFreq);
                cycle--;
                ans++;
            }
            for(int i=0;i<temp.size();i++){
                pq.add(temp.get(i));
            }
            if(!pq.isEmpty()){
                ans += cycle;
            }
        }
        
        return ans;
    }
    
    //O(1) SC and O(N) TC
    public int leastInterval2(char[] tasks, int n) {
        int freq[] = new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        Arrays.sort(freq);
        int chunks = freq[25]-1;
        int idle = chunks*n;
        for(int i=24;i>=0;i--){
            idle -= Math.min(freq[i],chunks);
        }
        return idle < 0 ? tasks.length : tasks.length+idle;
    }
}