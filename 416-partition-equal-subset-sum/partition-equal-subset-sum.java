class Solution {

    // Recursive
    // public boolean canPartition(int[] nums) {
    //     int n=nums.length;
    //     int totalSum=0;
    //     for(int it:nums){
    //         totalSum += it;
    //     }
    //     if(totalSum%2 != 0)return false;

    //     // if one subset has sum half of total then other will surely have half of it
    //     int sum = totalSum/2;
    //     return func(n-1,nums,sum);
    // }
    // public boolean func(int ind , int[] arr,int sum){
    //     if(sum == 0)return true;
    //     if(ind == 0)return arr[0] == sum;
        
    //     boolean notpick=func(ind-1,arr,sum);
    //     boolean pick=false;
    //     if(sum >= arr[ind])pick = func(ind-1,arr,sum-arr[ind]);
    //     return notpick || pick;
    // }
    

    // Memoization
    // public boolean canPartition(int[] nums) {
    //     int n=nums.length;
    //     int totalSum=0;
    //     for(int it:nums){
    //         totalSum += it;
    //     }
    //     if(totalSum%2 != 0)return false;

    //     // if one subset has sum half of total then other will surely have half of it
    //     int sum = totalSum/2;
    
    //     int[][] dp= new int[n][sum+1];
    //     for(int[] i:dp){
    //         Arrays.fill(i,-1);
    //     }
    //     return func(n-1,nums,sum,dp);
    // }
    // public static boolean func(int ind , int[] arr,int sum,int[][] dp){
    //     if(sum == 0)return true;
    //     if(ind == 0)return arr[0] == sum;
    //     if(dp[ind][sum] != -1)return dp[ind][sum] == 1;
        
    //     boolean notpick=func(ind-1,arr,sum,dp);
    //     boolean pick=false;
    //     if(sum >= arr[ind])pick = func(ind-1,arr,sum-arr[ind],dp);
    //     dp[ind][sum] =  (notpick || pick) ? 1 : 0;
    //     return notpick || pick;
    // }

    // Tabulation
    // public boolean canPartition(int[] nums) {
    //     int n=nums.length;
    //     int totalSum=0;
    //     for(int it:nums){
    //         totalSum += it;
    //     }
    //     if(totalSum%2 != 0)return false;

    //     // if one subset has sum half of total then other will surely have half of it
    //     int sum = totalSum/2;
    //     boolean[][] dp= new boolean[n][sum+1];
    //     // Base cases
    //     for(int i=0;i<n;i++)dp[i][0]=true;
    //     if(nums[0] <= sum) dp[0][nums[0]] = true;
        
    //     for(int ind=1;ind<n;ind++){
    //         for(int target=1;target<=sum;target++){
    //             boolean notpick=dp[ind-1][target];
    //             boolean pick=false;
    //             if(target >= nums[ind])pick = dp[ind-1][target-nums[ind]];
    //             dp[ind][target] = pick||notpick;
    //         }
    //     }
    //     return dp[n-1][sum];
    // }
    
    // Space optimization
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int it:nums){
            totalSum += it;
        }
        if(totalSum%2 != 0)return false;

        // if one subset has sum half of total then other will surely have half of it
        int sum = totalSum/2;
        boolean[] prev= new boolean[sum+1];
        // Base cases
        prev[0]=true;
        if(nums[0] <= sum) prev[nums[0]] = true;
        
        for(int ind=1;ind<n;ind++){
            boolean[] curr= new boolean[sum+1];
            curr[0]=true;
            for(int target=1;target<=sum;target++){
                boolean notpick=prev[target];
                boolean pick=false;
                if(target >= nums[ind])pick = prev[target-nums[ind]];
                curr[target] = pick||notpick;
            }
            prev=curr;
        }
        return prev[sum];
    }
    
}