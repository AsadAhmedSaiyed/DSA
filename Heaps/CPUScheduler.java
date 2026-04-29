import java.util.*;
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
}