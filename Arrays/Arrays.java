import java.util.*;

public class Arrays{

    public static void update(int ranks[]){
        for(int i=0;i<ranks.length;i++){
            ranks[i] += 1;
        }
    }
    public static void main(String args[]){
        //creating an array
        int marks[] = new int[100];

        int nums[] = {1,2,3};

        Scanner sc = new Scanner(System.in);
        // marks[0] = sc.nextInt();
        // marks[1] = sc.nextInt();

        // System.out.println("Phy : "+ marks[0]);
        // System.out.println("Maths : "+ marks[1]);

        // marks[1] = 100;
        // System.out.println("Maths : "+ marks[1]);
        // System.out.println(marks.length);

        int ranks[] = {199,98,101};
        update(ranks);

        //printing elements of an array
        for(int i=0;i<ranks.length;i++){
            System.out.print("\t"+ranks[i]);
        }
    }
}