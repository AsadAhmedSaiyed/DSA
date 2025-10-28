public class Main {
    public static void main(String[] args) {
        //initialize with empty string
        StringBuilder sb = new StringBuilder("");
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
        }
        System.out.print(sb.length());
    }
}
