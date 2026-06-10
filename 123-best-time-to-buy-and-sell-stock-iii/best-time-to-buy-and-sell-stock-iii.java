class Solution {

    // Recursive O(2^n)
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     return func(0,1,2,n,prices);
    // }
    // public int func(int ind,int buy,int cap,int n,int[] prices){
    //     if(cap == 0)return 0;
    //     if(ind == n)return 0;

    //     if(buy == 1){
    //         return Math.max(-prices[ind]+ func(ind+1,0,cap,n,prices), func(ind+1,1,cap,n,prices));
    //     }
    //     return Math.max(prices[ind]+ func(ind+1,1,cap-1,n,prices), func(ind+1,0,cap,n,prices));
    // }

    // Memoization even transactionid means buying allowed and odd means selling allowed
    // dp[ind][0] -> buy
    // dp[ind][1] -> sell
    // dp[ind][2] -> buy
    // dp[ind][3] -> sell
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][] dp= new int[n][4];
    //     for(int i=0;i<n;i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return func(0,0,n,prices,dp);
    // }
    // public int func(int ind,int tranID,int n,int[] prices,int[][] dp){
    //     if(tranID > 3)return 0;
    //     if(ind == n)return 0;

    //     if(dp[ind][tranID] != -1)return dp[ind][tranID];
    //     if(tranID % 2 == 0){
    //         return dp[ind][tranID] = Math.max(-prices[ind]+ func(ind+1,tranID+1,n,prices,dp), func(ind+1,tranID,n,prices,dp));
    //     }
    //     return dp[ind][tranID] = Math.max(prices[ind]+ func(ind+1,tranID+1,n,prices,dp), func(ind+1,tranID,n,prices,dp));
    // }

    // Tabulation
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][] dp= new int[n+1][5];
    //     // no need for base case because already the dp is initialized with 0

    //     for(int i=n-1;i>=0;i--){
    //         for(int j=3;j>=0;j--){
    //             if(j % 2 == 0){
    //                 dp[i][j] = Math.max(-prices[i]+ dp[i+1][j+1], dp[i+1][j]);
    //             }
    //             else{ 
    //                 dp[i][j] = Math.max(prices[i]+dp[i+1][j+1], dp[i+1][j]);
    //             }
    //         }
    //     }
    //     return dp[0][0];
    // }
    
    // Space Optimization
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead= new int[5];
        // no need for base case because already the dp is initialized with 0

        for(int i=n-1;i>=0;i--){
            int[] curr = new int[5];
            for(int j=3;j>=0;j--){
                if(j % 2 == 0){
                    curr[j] = Math.max(-prices[i]+ ahead[j+1], ahead[j]);
                }
                else{ 
                    curr[j] = Math.max(prices[i]+ahead[j+1], ahead[j]);
                }
            }
            ahead = curr;
        }
        return ahead[0];
    }

}