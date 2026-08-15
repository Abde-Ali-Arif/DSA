class Solution {

    // Wrong because i was checking only subarrays but question is different
    // O(n^2) Checking all subsequences
    // public int longestSubsequence(int[] nums) {
    //     int n=nums.length;
    //     int ans=0;
        
    //     for(int i=0;i<n;i++){
    //         int xor=0;
    //         for(int j=i;j<n;j++){
    //             xor ^=nums[j];
    //             if(xor != 0){
    //                 ans=Math.max(ans,j-i+1);
    //             }
    //         }
    //     }
    //     return ans;
    // }

    // O(n)
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            xor ^= num;
            if (num != 0) {
                hasNonZero = true;
            }
        }

        // Entire array has non-zero XOR
        if (xor != 0) {
            return n;
        }

        // All elements are zero so no chance for the elements to have xor to be non-zero
        if (!hasNonZero) {
            return 0;
        }

        // Remove one non-zero element
        return n - 1;
    }
}