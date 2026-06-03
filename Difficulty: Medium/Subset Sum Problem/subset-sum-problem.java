class Solution {
    
    // Recursive O(2^n)
    // static Boolean isSubsetSum(int arr[], int sum) {
    //     int n=arr.length;
    //     return func(n-1,arr,sum);
    // }
    // public static boolean func(int ind , int[] arr,int sum){
    //     if(sum == 0)return true;
    //     if(ind == 0)return arr[0] == sum;
        
    //     boolean notpick=func(ind-1,arr,sum);
    //     boolean pick=false;
    //     if(sum >= arr[ind])pick = func(ind-1,arr,sum-arr[ind]);
    //     return notpick || pick;
    // }
    
    // Memoization O(n*target)
    // static Boolean isSubsetSum(int arr[], int sum) {
    //     int n=arr.length;
    //     int[][] dp= new int[n][sum+1];
    //     for(int[] i:dp){
    //         Arrays.fill(i,-1);
    //     }
    //     return func(n-1,arr,sum,dp);
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
    // static Boolean isSubsetSum(int arr[], int sum) {
    //     int n=arr.length;
    //     boolean[][] dp= new boolean[n][sum+1];
    //     // Base cases
    //     for(int i=0;i<n;i++)dp[i][0]=true;
    //     if(arr[0] <= sum) dp[0][arr[0]] = true;
        
    //     for(int ind=1;ind<n;ind++){
    //         for(int target=1;target<=sum;target++){
    //             boolean notpick=dp[ind-1][target];
    //             boolean pick=false;
    //             if(target >= arr[ind])pick = dp[ind-1][target-arr[ind]];
    //             dp[ind][target] = pick||notpick;
    //         }
    //     }
    //     return dp[n-1][sum];
    // }
    
    // Space optimization
    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        boolean[] prev= new boolean[sum+1];
        // Base cases
        prev[0]=true;
        if(arr[0] <= sum) prev[arr[0]] = true;
        
        for(int ind=1;ind<n;ind++){
            boolean[] curr= new boolean[sum+1];
            curr[0]=true;
            for(int target=1;target<=sum;target++){
                boolean notpick=prev[target];
                boolean pick=false;
                if(target >= arr[ind])pick = prev[target-arr[ind]];
                curr[target] = pick||notpick;
            }
            prev=curr;
        }
        return prev[sum];
    }
    
    
}