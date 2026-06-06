class Solution {
    // public int coinChange(int[] coins, int amount) {
    //     int n= coins.length;
    //     int ans = func(coins,amount,n-1,0);
    //     return (ans == (int)1e8)?-1:ans;
    // }
    // public int func(int[] coins, int amount, int ind,int cnt){
    //     if(amount == 0)return cnt;
    //     if(ind < 0)return (int)1e8;

    //     int notpick = func(coins,amount,ind-1,cnt);
    //     int pick =(int)1e8;
    //     if(amount >= coins[ind]) pick =func(coins,amount-coins[ind],ind,cnt+1);

    //     return Math.min(pick,notpick);
    // }

    // Memoized
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int[][] dp= new int[n][amount+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        int ans = func(coins,amount,n-1,dp);
        return (ans == (int)1e8)?-1:ans;
    }
    public int func(int[] coins, int amount, int ind,int[][] dp){
        if(amount == 0)return 0;
        if(ind < 0)return (int)1e8;

        if(dp[ind][amount] != -1)return dp[ind][amount];
        int notpick = func(coins,amount,ind-1,dp);
        int pick =(int)1e8;
        if(amount >= coins[ind]) pick =1+func(coins,amount-coins[ind],ind,dp);

        return dp[ind][amount] = Math.min(pick,notpick);
    }
}