class Solution {
    
    // Recursion
    // public int change(int amount, int[] coins) {
    //     int n= coins.length;
    //     return func(coins,amount,n-1);
    // }
    // public int func(int[] coins, int amount, int ind){
    //     if(ind == 0){
    //         if(amount % coins[0] == 0)return 1;
    //         return 0;
    //     }
    //     int notpick = func(coins,amount,ind-1);
    //     int pick =0;
    //     if(amount >= coins[ind]) pick =func(coins,amount-coins[ind],ind);
    //     return pick + notpick;
    // }

    // Memoization
    // public int change(int amount, int[] coins) {
    //     int n= coins.length;
    //     int[][] dp = new int[n][amount+1];
    //     for(int[] row :dp)Arrays.fill(row,-1);
    //     return func(coins,amount,n-1,dp);
    // }
    // public int func(int[] coins, int amount, int ind,int[][] dp){
    //     if(ind == 0){
    //         if(amount % coins[0] == 0)return 1;
    //         return 0;
    //     }
    //     if(dp[ind][amount] != -1)return dp[ind][amount];
    //     int notpick = func(coins,amount,ind-1,dp);
    //     int pick =0;
    //     if(amount >= coins[ind]) pick =func(coins,amount-coins[ind],ind,dp);
    //     return dp[ind][amount] = pick + notpick;
    // }

    // Tabulation
    // public int change(int amount, int[] coins) {
    //     int n= coins.length;
    //     int[][] dp = new int[n][amount+1];
    //     // Base cases
    //     for(int i=0;i<=amount;i++){
    //         if(i%coins[0] == 0)dp[0][i]=1;
    //     }

    //     for(int ind = 1;ind<n;ind++){
    //         for(int amt=0;amt<=amount;amt++){
    //             int notpick = dp[ind-1][amt];
    //             int pick =0;
    //             if(amt >= coins[ind]) pick =dp[ind][amt-coins[ind]];
    //             dp[ind][amt] = pick + notpick;
    //         }
    //     }
    //     return dp[n-1][amount];
    // }

    // Space optimization
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[] prev = new int[amount+1];
        // Base cases
        for(int i=0;i<=amount;i++){
            if(i%coins[0] == 0)prev[i]=1;
        }

        for(int ind = 1;ind<n;ind++){
            int[] curr= new int[amount+1];
            for(int amt=0;amt<=amount;amt++){
                int notpick = prev[amt];
                int pick =0;
                if(amt >= coins[ind]) pick =curr[amt-coins[ind]];
                curr[amt] = pick + notpick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}