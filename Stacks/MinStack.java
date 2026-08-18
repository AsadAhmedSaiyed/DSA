import java.util.ArrayList;

public class MinStack {
    
    private ArrayList<Integer> st;
    private ArrayList<Integer> min;

    public MinStack() {
        st = new ArrayList<>();
        min = new ArrayList<>();
    }
    
    public void push(int value) {
        st.add(value);
        if(min.isEmpty()){
          min.add(value);
        }else{
          int last = min.get(min.size()-1);
          if(value<last){
            min.add(value);
          }else{
            min.add(last);
          }
        }
    }
    
    public void pop() {
        if(!(st.isEmpty())){
            st.remove(st.size()-1);
            min.remove(min.size()-1);
        }
    }
    
    public int top() {
        return st.isEmpty() ? -1 : st.get(st.size()-1);
    }
    
    public int getMin() {
        return min.isEmpty() ? -1 : min.get(min.size()-1);
    }
}
