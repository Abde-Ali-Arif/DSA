class Solution {
    // Function to calculate the number of subsets with a given sum
    // Recursion
    // public int perfectSum(int[] nums, int target) {
    //     int n=nums.length;
    //     return func(n-1,nums,target);
    // }
    // public static int func(int ind , int[] arr,int sum){
    //       if (ind == 0) {
    //       if (sum == 0 && arr[0] == 0) return 2; 
    //       if (sum == 0) return 1;
    //       if (arr[0] == sum) return 1;
    //       return 0;
    //     } 
    //     int notpick=func(ind-1,arr,sum);
    //     int pick=0;
    //     if(sum >= arr[ind])pick = func(ind-1,arr,sum-arr[ind]);
    //     return notpick + pick;
    // }
    
    // Memoization
    public int perfectSum(int[] nums, int target) {
        int n=nums.length;
        int[][] dp= new int[n][target+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return func(n-1,nums,target,dp);
    }
    public static int func(int ind , int[] arr,int sum,int[][] dp){
          if (ind == 0) {
          if (sum == 0 && arr[0] == 0) return 2; 
          if (sum == 0) return 1;
          if (arr[0] == sum) return 1;
          return 0;
        } 
        if(dp[ind][sum] != -1)return dp[ind][sum];
        int notpick=func(ind-1,arr,sum,dp);
        int pick=0;
        if(sum >= arr[ind])pick = func(ind-1,arr,sum-arr[ind],dp);
        return dp[ind][sum] = notpick + pick;
    }
}