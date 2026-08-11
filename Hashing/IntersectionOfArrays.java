import java.util.HashSet;

public class IntersectionOfArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        
        for(int i=0;i<n;i++){
            s1.add(nums1[i]);
        }
        for(int i=0;i<m;i++){
            if(s1.contains(nums2[i])){
                s2.add(nums2[i]);
            }
        }
        int ans[] = new int[s2.size()];
        int i=0;
        for(int s : s2){
           ans[i] = s;
           i++;
        }
        return ans;
    }
}
