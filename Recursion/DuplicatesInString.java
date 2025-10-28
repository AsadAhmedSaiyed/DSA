public class DuplicatesInString{
    public static void remove(String str,int i,boolean arr[],StringBuilder newStr){
       if(i == str.length()){
         System.out.println(newStr);
         return;         
       }
       char ch = str.charAt(i);
       if(arr[ch-'a'] == true){
          remove(str,i+1,arr,newStr); 
       }else{
         arr[ch-'a'] = true;
         remove(str, i+1, arr, newStr.append(ch));
       }

    }
    public static void main(String[] args) {
        String str = "a";
        boolean arr[] = new boolean[26];
        StringBuilder newStr = new StringBuilder("");
        remove(str, 0, arr, newStr);
    }
}