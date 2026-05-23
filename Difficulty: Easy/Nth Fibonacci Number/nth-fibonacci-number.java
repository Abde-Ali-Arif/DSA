class Solution {
    // O(2^n)
    // public int nthFibonacci(int n) {
    //     if(n <= 1)return n;
        
    //     return nthFibonacci(n-1) + nthFibonacci(n-2);
    // }
    
    // Dp solution O(n)
    // public int nthFibonacci(int n) {
    //     int[] dp=new int[n+1];
    //     return fab(n,dp);
    // }
    // private int fab(int n, int[] dp){
    //     if(n <= 1)return n;

    //     if(dp[n] != 0)return dp[n];
    //     return dp[n]=fab(n-1,dp)+fab(n-2,dp);
    // }
    
    // Most optimized
    public int nthFibonacci(int n) {
        if(n <= 1)return n;
        int prev2=0,prev=1;
        for(int i=2;i<=n;i++){
            int curi=prev2 + prev;
            prev2=prev;
            prev=curi;
        }
        return prev;
    }
}