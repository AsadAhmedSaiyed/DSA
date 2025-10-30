import java.util.Stack;

public class NextGreaterElement{
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek() <= arr[i]){
                s.pop();
            }
            int nextGreater;
            if(s.isEmpty()){
                nextGreater=-1;
            }else{
                nextGreater = s.peek();
            }
            s.push(arr[i]);
            ans[i] = nextGreater;
        } 
        for (int i = 0; i < ans.length; i++) {
           System.out.print(ans[i] + " ");   
        }
    }
}