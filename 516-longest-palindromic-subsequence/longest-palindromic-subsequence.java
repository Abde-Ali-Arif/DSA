class Solution {
    // Recursion 
    // public int longestPalindromeSubseq(String s) {
    //     int n=s.length();
    //     String s2 = new StringBuilder(s).reverse().toString();
    //     return func(n-1,n-1,s,s2);
    // }
    // public int func(int i,int j,String s1, String s2){
    //     if(i < 0 || j < 0)return 0;
    //     // both characters equal so inmaxcrease by 1
    //     if(s1.charAt(i) == s2.charAt(j)) return 1 + func(i-1,j-1,s1,s2);
        
    //     return Math.max(func(i-1,j,s1,s2) , func(i,j-1,s1,s2));
    // }
    
    // Memoization
    // public int longestPalindromeSubseq(String s) {
    //     int n=s.length();
    //     String s2 = new StringBuilder(s).reverse().toString();
    //     int[][] dp = new int[n][n];
    //     for(int[] row :dp) Arrays.fill(row,-1);
    //     return func(n-1,n-1,s,s2,dp);
    // }
    // static int func(int i,int j,String s1, String s2,int[][] dp){
    //     if(i < 0 || j < 0)return 0;
        
    //     if(dp[i][j] != -1)return dp[i][j];
    //     // both characters equal so increase by 1
    //     if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + func(i-1,j-1,s1,s2,dp);
        
    //     return dp[i][j] = Math.max(func(i-1,j,s1,s2,dp) , func(i,j-1,s1,s2,dp));
    // }
    
    // Tabulation
    // public int longestPalindromeSubseq(String s) {
    //     int n=s.length();
    //     String s2 = new StringBuilder(s).reverse().toString();
    //     int[][] dp = new int[n+1][n+1];
    //     // perform shifting of index so that -1 index is treated as 0 index
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=n;j++){
    //             if(s.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
    //             else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            
    //         }
    //     }   
    //     return dp[n][n];
    // }
    
    // Space optimization
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[] prev = new int[n+1];
        
        // perform shifting of index so that -1 index is treated as 0 index
        
        for(int i=1;i<=n;i++){
            int[] curr = new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == s2.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j] , curr[j-1]);
            }
            prev = curr;
        }
        return prev[n];
    }
}