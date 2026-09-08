import java.util.HashSet;

public class HappyNum{
     public boolean isHappy(int n) {
        HashSet<Integer> s = new HashSet<>();
        int sum = 0;
        while(n != 1){
           int x = n; 
           while(x > 0){
              sum += (x%10)*(x%10);
              x = x / 10;
           }
           
           if(s.contains(sum)){
             return false;
           }
           s.add(sum);
           n = sum;
           sum = 0;
        }
        return true;
    }

    private int getNextNum(int n){
        int sum = 0;
        while(n > 0){
          sum += (n%10)*(n%10);
          n = n / 10;
        }
        return sum;
    }

    public boolean isHappy2(int n) {
        int slow = getNextNum(n);
        int fast = getNextNum(getNextNum(n));
        while(slow != fast){
            if(fast == 1) return true;
            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));
        }
        return slow == 1;
    }
}