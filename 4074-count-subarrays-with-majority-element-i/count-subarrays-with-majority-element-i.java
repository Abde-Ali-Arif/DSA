class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        
        // Transform
        for (int i = 0; i < n; i++) {
            if (nums[i] == target)
                prefix[i + 1] = prefix[i] + 1;
            else
                prefix[i + 1] = prefix[i] - 1;
        }

        int count = 0;
        // Count positive subarray sums
        for (int r = 1; r <= n; r++) {
            for (int l = 0; l < r; l++) {
                if (prefix[r] > prefix[l]) count++;
            }
        }
        return count;
    }
}