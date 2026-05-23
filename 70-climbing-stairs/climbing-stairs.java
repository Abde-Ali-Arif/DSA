class Solution {
    // O(2^n)
    // public int climbStairs(int n) {
    //     if(n <= 1)return 1;
    //     return climbStairs(n-1)+climbStairs(n-2);
    // }

    // Memoization Solution
    // public int climbStairs(int n) {
    //     if(n <= 1)return 1;
    //     int[] dp=new int[n+1];        
    //     return dp(n,dp);
    // }
    // private int dp(int n,int[] dp){
    //     if(n <= 1)return 1;
    //     // you can take -1 initially in dp array for more simplicity
    //     if(dp[n] != 0)return dp[n];
    //     return dp[n]=dp(n-1,dp)+dp(n-2,dp);
    // }

    // Tabulation solution
    // public int climbStairs(int n) {
    //     if(n <= 1)return 1;
    
    //     int[] dp=new int[n+1];
    //     dp[0]=1; dp[1]=1;
    //     for(int i=2;i<=n;i++){
    //         dp[i]=dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }

    // Space optimization
    public int climbStairs(int n) {
        if(n <= 1)return 1;

        // at step 0 and step one only 1(one way) to reach goal
        int dp1=1 , dp2=1;
        for(int i=2;i<=n;i++){
            int curr=dp1 + dp2;
            dp2=dp1;
            dp1=curr;
        }
        return dp1;
    }
}