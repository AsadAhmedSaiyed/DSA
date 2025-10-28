public class Permutations {

    public static void findp(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char cr = str.charAt(i);
            String nStr = str.substring(0,i) + str.substring(i+1);
            findp(nStr, ans+cr);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        findp(str, "");
    }
}
