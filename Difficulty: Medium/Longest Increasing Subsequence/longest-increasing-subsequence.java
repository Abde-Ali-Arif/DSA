class Solution {
    // Recursive O(2^n)
    // static int lis(int arr[]) {
    //     int n=arr.length;
    //     return func(0,-1,arr);
    // }
    // public static int func(int ind,int prev ,int[] arr){
    //     if(ind == arr.length)return 0;
        
    //     int notpick=func(ind+1,prev,arr);
    //     int pick=0;
    //     if(arr[ind] > prev) pick = 1+func(ind+1,arr[ind],arr);
    //     return Math.max(notpick , pick);
    // }
    
    
    static int lis(int arr[]) {
        int n= arr.length;
        int[][] dp = new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return func(0,-1,arr,dp); 
    }
    public static int func(int ind,int prev ,int[] arr,int[][] dp){
        if(ind == arr.length)return 0;

        if(dp[ind][prev+1] != -1)return dp[ind][prev+1];
        int notpick=func(ind+1,prev,arr,dp);
        int pick=0;
        if(prev == -1)pick = 1+func(ind+1,ind,arr,dp);
        else if(arr[ind] > arr[prev]) pick = 1+func(ind+1,ind,arr,dp);
        
        return dp[ind][prev+1] = Math.max(notpick , pick);
    }
}