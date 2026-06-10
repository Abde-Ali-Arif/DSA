class Solution {

    // Recursive O(2^n)
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     return func(0,1,n,prices);
    // }
    // public int func(int ind,int buy,int n,int[] prices){
    //     if(ind == n)return 0;

    //     if(buy == 2)return func(ind+1,1,n,prices);
    //     if(buy == 1){
    //         return Math.max(-prices[ind]+ func(ind+1,0,n,prices), func(ind+1,1,n,prices));
    //     }
    //     return Math.max(prices[ind]+ func(ind+1,2,n,prices) , func(ind+1,0,n,prices));
    // }

    // Memoization 
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp= new int[3][n];
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);
        Arrays.fill(dp[2],-1);
        return func(0,1,n,prices,dp);
    }
    public int func(int ind,int buy,int n,int[] prices,int[][] dp){
        if(ind == n)return 0;

        if(dp[buy][ind] != -1)return dp[buy][ind];
        if(buy == 2)return dp[buy][ind] = func(ind+1,1,n,prices,dp);
        if(buy == 1){
            return dp[buy][ind] = Math.max(-prices[ind]+ func(ind+1,0,n,prices,dp), func(ind+1,1,n,prices,dp));
        }
        return dp[buy][ind] = Math.max(prices[ind]+ func(ind+1,2,n,prices,dp) , func(ind+1,0,n,prices,dp));

    }
}