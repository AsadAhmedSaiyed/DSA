public class Assignment {

    static String arr[] = {"zero","one","two","third","fourth","five","six","seven","eight","nine"};

    public static void find(int arr[],int si, int key){

        if(si == arr.length){
           return;
        }

        if(arr[si] == key){
            System.out.print(si + " ");
        
        }
        find(arr, si+1, key);

    }

    public static void printE(int n){
        if(n == 0){
            return;
        }
        int ld = n % 10;
        printE(n/10);
        System.out.print(arr[ld]+" ");
    }

    public static int check(String s,int i, int j){
      if(i == s.length()){
        return 0;
      }
      if(j == s.length()){
        return check(s, i+1, i+1);
      }
      if(s.charAt(i) == s.charAt(j)){
        return check(s, i, j+1)+1;
      }
      return check(s, i, j+1);
    } 

    public static void main(String[] args) {
        // int arr[] = {3,2,4,5,6,2,7,2,2};
        // find(arr,0,2);
        //printE(0);
        String s = "abcab";
        System.out.println(check(s, 0, 0));
    }
}
