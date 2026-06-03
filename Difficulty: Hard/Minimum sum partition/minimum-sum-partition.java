class Solution {
    // public int minDifference(int nums[]) {
    //     int n=nums.length;
    //     int totalSum=0;
    //     for(int it:nums){
    //         totalSum += it;
    //     }
    //     // if one subset has sum half of total then other will surely have half of it
    //     int sum = totalSum/2;
    //     return func(n-1,nums,0,totalSum);
    // }
    // public int func(int ind , int[] arr,int sum,int totalSum){
    //     if(ind < 0){
    //         int otherSum=totalSum - sum;
    //         return Math.abs(sum - otherSum);
    //     }
        
    //     int notpick=func(ind-1,arr,sum,totalSum);
    //     int pick = func(ind-1,arr,sum+arr[ind],totalSum);
    //     return Math.min(pick,notpick);
    // }
    
    // Memoization
    public int minDifference(int nums[]) {
        int n = nums.length;

        int totalSum = 0;
        for (int it : nums) {
            totalSum += it;
        }

        int[][] dp = new int[n][totalSum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(n - 1, nums, 0, totalSum, dp);
    }

    public int func(int ind, int[] arr, int sum, int totalSum, int[][] dp) {

        if (ind < 0) {
            int otherSum = totalSum - sum;
            return Math.abs(sum - otherSum);
        }

        if (dp[ind][sum] != -1) {
            return dp[ind][sum];
        }

        int notPick = func(ind - 1, arr, sum, totalSum, dp);

        int pick = func(ind - 1, arr, sum + arr[ind], totalSum, dp);

        return dp[ind][sum] = Math.min(notPick, pick);
    }
}
