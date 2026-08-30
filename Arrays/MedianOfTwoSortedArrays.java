public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = (m+n+1)/2;
        int l = 0;
        int r = m;
        while(l<=r){
           int mid1 = (l+r)/2;
           int mid2 = left-mid1;

           int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
           if(mid1 < m) r1 = nums1[mid1];
           if(mid2 < n) r2 = nums2[mid2];
           if(mid1-1 >= 0) l1 = nums1[mid1-1];
           if(mid2-1 >= 0) l2 = nums2[mid2-1];

           if(l1 <= r2 && l2 <= r1){
               if((m+n) % 2 == 0){
                 return ((double)(Math.max(l1,l2) + Math.min(r1,r2)))/2.0;
               }else{
                 return Math.max(l1,l2);
               }
           }  
           else if(l1 > r2){
             r = mid1-1;
           }else{
            l = mid1+1;
           }
        }
        return  0;
    }
}
