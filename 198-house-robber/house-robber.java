class Solution {
    // Memoization
    // public int rob(int[] nums) {
    //     int[] dp= new int[nums.length];
    //     Arrays.fill(dp,-1);
    //     return func(nums.length-1,dp,nums);
    // }
    // private int func(int ind,int[] dp,int[] nums){
    //     if(ind == 0)return nums[0];
    //     if(ind < 0)return 0;
    //     if(dp[ind] != -1)return dp[ind];
    //     int pick = func(ind - 2,dp,nums)+nums[ind];
    //     int not_pick = func(ind - 1,dp,nums);
    //     return dp[ind]=Math.max(pick,not_pick);
    // }

    // Tabulation
    // public int rob(int[] nums) {
    //     int[] dp= new int[nums.length];
    //     Arrays.fill(dp,-1);
    //     dp[0]=nums[0];

    //     for(int i=1;i<nums.length;i++){
    //         int pick=nums[i];
    //         if(i > 1)pick+=dp[i-2];
    //         int not_pick=dp[i-1];
    //         dp[i]=Math.max(pick,not_pick);
    //     }
    //     return dp[nums.length-1];
    // }

    // Space Optimization
    public int rob(int[] nums) {
        int prev=nums[0],prev2=0;
        for(int i=1;i<nums.length;i++){
            int pick=nums[i]+prev2;
            int not_pick=prev;
            int curri=Math.max(pick,not_pick);
            prev2=prev;
            prev=curri;
        }
        return prev;
    }
}