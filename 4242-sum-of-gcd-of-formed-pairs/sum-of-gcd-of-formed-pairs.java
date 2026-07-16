class Solution {
    
    // Helper function to calculate GCD using Euclidean algorithm
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        long[] prefixGcd = new long[n];
        
        long mxi = 0;
        // Step 1 & 2: Construct prefixGcd array
        for (int i = 0; i < n; i++) {
            mxi = Math.max(mxi, nums[i]);
            prefixGcd[i] = gcd(nums[i], mxi);
        }
        
        // Step 3: Sort prefixGcd in non-decreasing order
        Arrays.sort(prefixGcd);
        
        long totalSum = 0;
        int left = 0;
        int right = n - 1;
        
        // Step 4: Two-pointer pairing from ends
        while (left < right) {
            totalSum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        
        return totalSum;
    }
}