import java.util.*;
class MedianFinder {
    private PriorityQueue<Integer> l;
    private PriorityQueue<Integer> h;
    public MedianFinder() {
        l = new PriorityQueue<>((a,b)->b-a);
        h = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(l.isEmpty() || num <= l.peek()){
            l.add(num);
        }else{
            h.add(num);
        }

        if(l.size() + 2 == h.size()){
            l.add(h.remove());
        }
        if(h.size() + 2 == l.size()){
            h.add(l.remove());
        }
    }
    
    public double findMedian() {
       if(l.size() == h.size()){
         return ((double)l.peek() + h.peek())/2;
       }else{
         return l.size() > h.size() ? l.peek() : h.peek();
       }
    }
}

