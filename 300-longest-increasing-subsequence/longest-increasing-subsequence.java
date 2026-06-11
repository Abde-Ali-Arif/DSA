class Solution {
    // // Recursive O(2^n)
    // public int lengthOfLIS(int[] nums) {
    //     int n= nums.length;
    //     return func(0,-(int)1e8,nums); 
    // }
    // public static int func(int ind,int prev ,int[] arr){
    //     if(ind == arr.length)return 0;
        
    //     int notpick=func(ind+1,prev,arr);
    //     int pick=0;
    //     if(arr[ind] > prev) pick = 1+func(ind+1,arr[ind],arr);
    //     return Math.max(notpick , pick);
    // }

    // Memoization O(n*n)
    // public int lengthOfLIS(int[] nums) {
    //     int n= nums.length;
    //     int[][] dp = new int[n][n+1];
    //     for(int[] row:dp){
    //         Arrays.fill(row,-1);
    //     }
    //     return func(0,-1,nums,dp); 
    // }
    // public static int func(int ind,int prev ,int[] arr,int[][] dp){
    //     if(ind == arr.length)return 0;

    //     if(dp[ind][prev+1] != -1)return dp[ind][prev+1];
    //     int notpick=func(ind+1,prev,arr,dp);
    //     int pick=0;
    //     if(prev == -1 || arr[ind] > arr[prev])pick = 1+func(ind+1,ind,arr,dp);

    //     return dp[ind][prev+1] = Math.max(notpick , pick);
    // }

    // Tabulation O(n*n)
    // public int lengthOfLIS(int[] nums) {
    //     int n= nums.length;
    //     int[][] dp = new int[n+1][n+1];
        
    //     for(int i=n-1;i>=0;i--){
    //         for(int j=n-1; j>=-1; j--){
    //             int notpick=dp[i+1][j+1];
    //             int pick=0;
    //             if(j == -1 || nums[i] > nums[j])pick = 1+dp[i+1][i+1];
    //             dp[i][j+1] = Math.max(notpick , pick);
    //         }
    //     }
    //     return dp[0][0]; 
    // }

    // Space optimization O(n*n)
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[] prev = new int[n+1];
        
        for(int i=n-1;i>=0;i--){
            int[] curr= new int[n+1];
            for(int j=n-1; j>=-1; j--){
                int notpick=prev[j+1];
                int pick=0;
                if(j == -1 || nums[i] > nums[j])pick = 1+prev[i+1];
                curr[j+1] = Math.max(notpick , pick);
            }
            prev= curr;
        }
        return prev[0]; 
    }
}