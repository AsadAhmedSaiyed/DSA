public class LongestMountain {
    //TC - O(n) SC - O(n)
    public int longestMountain2(int[] nums) {
        int n = nums.length;

        int[] front = new int[n];
        int[] back = new int[n];

        int longestMountain = 0;

        // Increasing sequence
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1])
                front[i] = front[i - 1] + 1;
            else
                front[i] = 0;
        }

        // Decreasing sequence
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                back[i] = back[i + 1] + 1;
            else
                back[i] = 0;
        }

        // Calculate mountain length
        for (int i = 0; i < n; i++) {
            if (front[i] > 0 && back[i] > 0) {
                longestMountain = Math.max(
                    longestMountain,
                    front[i] + back[i] + 1
                );
            }
        }

        return longestMountain;
    }
    //TC - O(n) SC - O(1)
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n < 3){
            return 0;
        }
        int maxLen = 0;
        for(int i=1;i<n-1;i++){
            if(arr[i-1]<arr[i] && arr[i] > arr[i+1]){
                int l = i-1;
                int r = i+1;
                while(l > 0 &&  arr[l-1] < arr[l]){
                   l--;
                }
                while(r < n-1 && arr[r] > arr[r+1]){
                    r++;
                }
                maxLen = Math.max(maxLen, r-l+1);
                i=r;
            }
        }
        return maxLen;
    }
}
