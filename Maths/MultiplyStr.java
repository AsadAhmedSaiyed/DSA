public class MultiplyStr {
    public String multiply(String nums1, String nums2) {

        if(nums1.equals("0") || nums2.equals("0")){
            return "0";
        }

        int m = nums1.length();
        int n = nums2.length();

        int result[] = new int[m+n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int d1 = nums1.charAt(i)-'0';
                int d2 = nums2.charAt(j)-'0';

                int prod = d1*d2;
                int digit = i+j+1;
                int carry = i+j;
                int sum = prod + result[digit];
                result[digit] = sum % 10;
                result[carry] += sum /10;
            }
        }   
        StringBuilder ans = new StringBuilder("");
        int i=0;
        while(i < result.length && result[i] == 0){
            i++;
        }

        while(i < result.length){
            ans.append(result[i]);
            i++;
        }
        return ans.toString();
    }
}
