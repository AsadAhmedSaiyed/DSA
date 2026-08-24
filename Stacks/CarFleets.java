public class CarFleets{
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> s = new Stack<>();
        int n = speed.length;
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
          arr[i][0] = position[i];
          arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (x,y)->Integer.compare(y[0],x[0]));
        for(int i[] : arr){
            double t = (double)(target-i[0])/i[1];
            if(s.isEmpty() || t >s.peek()){
                s.push(t);
            }
        }
        return s.size();
    }
}