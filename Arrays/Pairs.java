
public class Pairs {

    public static void printPairs(int nums[]){
        int tp= 0;
        //outer - to access each element
        for(int i=0;i<nums.length;i++){
            //inner - to pair it with elements that comes after it
            for(int j=i+1;j<nums.length;j++){
                System.out.print("(" + nums[i] +","+ nums[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total pairs : " + tp);
    }
    public static void main(String[] args) {
        int nums[] = {2,4,6,8,10};
        printPairs(nums);
    }
}
