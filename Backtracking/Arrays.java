public class Arrays {
    public static void back(int arr[],int i){
       if(i == arr.length){
         return;
       } 
       arr[i] = i+1;
       back(arr,i+1);
       arr[i] = arr[i]-2; 
    }
   public static void main(String[] args) {
     int arr[] = new int[5];
     back(arr,0);
     for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
     }
   }    
}
