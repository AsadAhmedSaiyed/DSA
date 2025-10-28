import java.util.ArrayList;
import java.util.Collections;

public class Intro{
    public static void swap(int idx1,int idx2,ArrayList<Integer> list){
        int temp = list.get(idx2);
        list.set(idx2, list.get(idx1));
        list.set(idx1, temp);
    }
    public static void main(String[] args) {
        //part of java collection framework
        ArrayList<Integer> list = new ArrayList<>();
        //ArrayList<String> list2 = new ArrayList<>();
        //add
        list.add(1);//O(1)
        list.add(2);
        list.add(3);

        list.add(1,9); //O(n)

        System.out.println(list);
        //get
        int el = list.get(0);
        System.out.println(el);

        //delete
        list.remove(0);
        System.out.println(list);

        //set
        list.set(1,10);
        System.out.println(list);

        //contains
        System.out.println(list.contains(2));
        System.out.println(list.contains(3));


        System.out.println(list.size());  
        //printing arraylist

        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
        //reverse
        for(int i=list.size()-1; i>=0;i--){
            System.out.print(list.get(i)+" ");
        } 
        //max
        System.out.println();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        System.out.println("Maximum element : " + max);
        System.out.println(list);
        swap(0, 2, list);
        System.out.println(list);

        //ascending
        Collections.sort(list);
        System.out.println(list);

        //descending
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);

        //nested AL
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        mainList.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        mainList.add(list2);
        System.out.println(mainList);

        //traversing AL of AL
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList = mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }

        ArrayList<ArrayList<Integer>> main = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4= new ArrayList<>();
        ArrayList<Integer> list5 = new ArrayList<>();

        for(int i=1;i<5;i++){
            list3.add(i*1);
            list4.add(i*2);
            list5.add(i*3);
        }
        main.add(list3);
        main.add(list4);
        main.add(list5);

        System.out.println(main);

        for(int i=0;i<main.size();i++){
            ArrayList<Integer> currList = main.get(i);
            for(int j=0; j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }

    }
}
