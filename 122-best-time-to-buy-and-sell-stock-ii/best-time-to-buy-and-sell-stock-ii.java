class Solution {

    // Recursive O(2^n)
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     return func(0,1,n,prices);
    // }
    // public int func(int ind,int buy,int n,int[] prices){
    //     if(ind == n)return 0;

    //     if(buy == 1){
    //         return Math.max(-prices[ind]+ func(ind+1,0,n,prices), func(ind+1,1,n,prices));
    //     }
    //     return Math.max(prices[ind]+ func(ind+1,1,n,prices), func(ind+1,0,n,prices));
    // }

    // Memoization O(n*2)
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][] dp= new int[2][n];
    //     Arrays.fill(dp[0],-1);
    //     Arrays.fill(dp[1],-1);
    //     return func(0,1,n,prices,dp);
    // }
    // public int func(int ind,int buy,int n,int[] prices,int[][] dp){
    //     if(ind == n)return 0;

    //     if(dp[buy][ind] != -1)return dp[buy][ind];
    //     if(buy == 1){
    //         return dp[buy][ind] = Math.max(-prices[ind]+ func(ind+1,0,n,prices,dp), func(ind+1,1,n,prices,dp));
    //     }
    //     return dp[buy][ind] = Math.max(prices[ind]+ func(ind+1,1,n,prices,dp), func(ind+1,0,n,prices,dp));
    // }

    // Tabulation O(n*2)
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][] dp= new int[2][n+1];
    //     // Base case
    //     dp[0][n]=dp[1][n]=0;

    //     for(int ind =n-1;ind>=0;ind--){
    //         dp[0][ind] = Math.max(prices[ind]+dp[1][ind+1] , dp[0][ind+1]);
    //         dp[1][ind] = Math.max(-prices[ind]+ dp[0][ind+1], dp[1][ind+1]);
    //     }
    //     return dp[1][0];
    // }

    // Space optimization O(n*2)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead= new int[2];
        // Base case
        ahead[0]=ahead[1]=0;

        for(int ind =n-1;ind>=0;ind--){
            int[] curr= new int[2];
            curr[0] = Math.max(prices[ind]+ahead[1] , ahead[0]);
            curr[1] = Math.max(-prices[ind]+ ahead[0], ahead[1]);
            ahead=curr;
        }
        return ahead[1];
    }
}