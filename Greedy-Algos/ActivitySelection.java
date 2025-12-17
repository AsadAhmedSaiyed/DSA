import java.util.*;

public class ActivitySelection{
    public static void main(String[] args) {
        int start[] = {1,3,2,5};
        int end[] =  {2,4,3,6};

        //if end is not sorted
        int activities[][] = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lamda fxn -> shortform of comparators
        //comparators define interface for sorting objects
        Arrays.sort(activities,Comparator.comparingInt(o->o[2]));

        int maxAct =0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxAct=1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>= lastEnd){
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max Activities : " + maxAct);
        System.out.println(ans);

    }
}