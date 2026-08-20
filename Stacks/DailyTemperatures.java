import java.util.*;

public class DailyTemperatures{
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                s.push(i);
            }else{
                while(!s.isEmpty() && temperatures[s.peek()]<temperatures[i]){
                    int prev = s.pop();
                   ans[prev] = i-prev;
                }
                s.push(i);
            }
        }
        return ans;
    }
}