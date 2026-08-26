class Solution {
    // public String shortestBeautifulSubstring(String s, int k) {
    //     int n = s.length();
    //     int len=Integer.MAX_VALUE;
    //     String ans ="";

    //     for(int i=0;i<n;i++){
    //         int ones=0;
    //         StringBuilder curr= new StringBuilder();
    //         for(int j=i;j<n;j++){
    //             curr.append(s.charAt(j));
    //             if(s.charAt(j) == '1')ones++;
    //             if(ones > k)break;
    //             if(len > j-i+1 && ones == k){
    //                 len=j-i+1;
    //                 if((ans.length() == 0 )|| Integer.parseInt(ans) > Integer.parseInt(curr.toString())) ans=curr.toString();
    //             }
    //         }
    //     }
    //     return ans;
    // }

    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        String ans = "";
        int onesCount = 0;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                onesCount++;
            }

            // Shrink window while it has exactly k ones or more than k ones
            while (onesCount == k) {
                // If it's shorter, or same length but lexicographically smaller
                int currentLen = right - left + 1;
                String currentStr = s.substring(left, right + 1);

                if (currentLen < minLength) {
                    minLength = currentLen;
                    ans = currentStr;
                } else if (currentLen == minLength) {
                    if (ans.isEmpty() || currentStr.compareTo(ans) < 0) {
                        ans = currentStr;
                    }
                }

                // Try to shrink from the left
                if (s.charAt(left) == '1') {
                    onesCount--;
                }
                left++;
            }
        }

        return ans;
    }
}