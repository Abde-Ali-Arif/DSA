class Solution {
    // Recursion
    // public int knapSack(int val[], int wt[], int capacity) {
    //     int n=val.length;
    //     return func(n-1,capacity,val,wt);
    // }
    // public int func(int ind,int capacity,int[] val,int[] wt){
    //     if(ind == 0){
    //         // not able to pick it up
    //         if(capacity < wt[0])return 0;
    //         else{
    //             int times = capacity/wt[0];
    //             return times*val[0];
    //         }
    //     }
    //     // greedy won't work so explore all paths
    //     int notpick = func(ind-1,capacity,val,wt);
    //     int pick = -(int)1e8;
    //     if(capacity >= wt[ind]) pick = val[ind] + func(ind , capacity-wt[ind],val,wt);
    //     // Return most optimal choice
    //     return Math.max(notpick,pick);
    // }
    
    // Memoization
    public int knapSack(int val[], int wt[], int capacity) {
        int n=val.length;
        int[][] dp= new int[n][capacity+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return func(n-1,capacity,val,wt,dp);
    }
    public int func(int ind,int capacity,int[] val,int[] wt,int[][] dp){
        if(ind == 0){
            // not able to pick it up
            if(capacity < wt[0])return 0;
            else{
                int times = capacity/wt[0];
                return times*val[0];
            }
        }
        
        if(dp[ind][capacity] != -1)return dp[ind][capacity];
        // greedy won't work so explore all paths
        int notpick = func(ind-1,capacity,val,wt,dp);
        int pick = -(int)1e8;
        if(capacity >= wt[ind]) pick = val[ind] + func(ind , capacity-wt[ind],val,wt,dp);
        // Return most optimal choice
        return dp[ind][capacity] = Math.max(notpick,pick);
    }
}