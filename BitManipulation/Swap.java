public class Swap{
    public static void main(String[] args) {
        int a = 5;
        int b= 2;
        System.out.println("a = " + a + " and b = " + b);
        b= a^b;
        a = a^b;//a=2
        b=a^b;
        System.out.println("a = " + a + " and b = " + b);
        System.out.println(-(~b));

        for(char ch='A';ch<='Z';ch++){
            System.out.println((char)(ch | (1<<5)));
        }
        
    }
}