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
    // public int perfectSum(int[] nums, int target) {
    //     int n=nums.length;
    //     int[][] dp= new int[n][target+1];
    //     for(int[] i:dp){
    //         Arrays.fill(i,-1);
    //     }
    //     return func(n-1,nums,target,dp);
    // }
    // public static int func(int ind , int[] arr,int sum,int[][] dp){
    //       if (ind == 0) {
    //       if (sum == 0 && arr[0] == 0) return 2; 
    //       if (sum == 0) return 1;
    //       if (arr[0] == sum) return 1;
    //       return 0;
    //     } 
    //     if(dp[ind][sum] != -1)return dp[ind][sum];
    //     int notpick=func(ind-1,arr,sum,dp);
    //     int pick=0;
    //     if(sum >= arr[ind])pick = func(ind-1,arr,sum-arr[ind],dp);
    //     return dp[ind][sum] = notpick + pick;
    // }
    
    // Tabulation
    // public int perfectSum(int[] nums, int target) {
    //     int n=nums.length;
    //     int[][] dp= new int[n][target+1];
        
    //     // asign all base cases
    //     // if(nums[0] == 0) dp[0][0] = 2;
    //     // else {
    //     //     dp[0][0] = 1;
    //     //     if(nums[0] <= target) dp[0][nums[0]] = 1;
    //     // }
    //     if(target >= nums[0]) dp[0][nums[0]]=1;
    //     if(nums[0] == 0) dp[0][0]=2;
    //     else dp[0][0]=1;
        
    //     for(int ind=1;ind<n;ind++){
    //         for(int sum = 0 ;sum<=target;sum++){
    //             int notpick=dp[ind-1][sum];
    //             int pick=0;
    //             if(sum >= nums[ind])pick = dp[ind-1][sum-nums[ind]];
    //             dp[ind][sum] = notpick + pick;
    //         }
    //     }
    //     return dp[n-1][target];
    // }
    
    // space optimization
    public int perfectSum(int[] nums, int target) {
        int n=nums.length;
        int[] prev= new int[target+1];
        
        // asign all base cases
        if(target >= nums[0]) prev[nums[0]]=1;
        if(nums[0] == 0) prev[0]=2;
        else prev[0]=1;
        
        for(int ind=1;ind<n;ind++){
            int[] curr= new int[target+1];
            for(int sum = 0 ;sum<=target;sum++){
                int notpick=prev[sum];
                int pick=0;
                if(sum >= nums[ind])pick = prev[sum-nums[ind]];
                curr[sum] = notpick + pick;
            }
            prev = curr;
        }
        return prev[target];
    }
    
    
}