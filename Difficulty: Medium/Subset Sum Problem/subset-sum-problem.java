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
    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        int[][] dp= new int[n][sum+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return func(n-1,arr,sum,dp);
    }
    public static boolean func(int ind , int[] arr,int sum,int[][] dp){
        if(sum == 0)return true;
        if(ind == 0)return arr[0] == sum;
        if(dp[ind][sum] != -1)return dp[ind][sum] == 1;
        
        boolean notpick=func(ind-1,arr,sum,dp);
        boolean pick=false;
        if(sum >= arr[ind])pick = func(ind-1,arr,sum-arr[ind],dp);
        dp[ind][sum] =  (notpick || pick) ? 1 : 0;
        return notpick || pick;
    }
    
    
}