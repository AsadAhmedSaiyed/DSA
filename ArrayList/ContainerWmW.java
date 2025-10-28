import java.util.ArrayList;

public class ContainerWmW {
    public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        //brute force
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int l = Math.min(height.get(i), height.get(j));
                int b = j-i;
                int water = l*b;
                if(water > maxWater){
                    maxWater = water;
                }
            }
        }
        return maxWater;
    }
    //2 pointer - O(n)
     public static int maxArea(ArrayList<Integer> height) {
        int maxWater = 0;
        int rp = height.size()-1;
        int lp = 0;
        while(lp < rp){
            int l = Math.min(height.get(lp),height.get(rp));
            int b = rp-lp;
            int water = l*b;
            if(water > maxWater){
                maxWater = water;
            }
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(maxArea(height));

    }
}
