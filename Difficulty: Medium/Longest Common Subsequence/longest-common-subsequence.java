class Solution {
    
    // Recursive
    // static int lcs(String s1, String s2) {
    //     int n = s1.length();
    //     int m = s2.length();
        
    //     return func(n-1,m-1,n,m,s1,s2);
        
    // }
    // static int func(int i,int j, int n, int m,String s1, String s2){
    //     if(i < 0 || j < 0)return 0;
    //     // both characters equal so inmaxcrease by 1
    //     if(s1.charAt(i) == s2.charAt(j)) return 1 + func(i-1,j-1,n,m,s1,s2);
        
    //     return 0 + Math.max(func(i-1,j,n,m,s1,s2) , func(i,j-1,n,m,s1,s2));
    // }
    
    // Memoization
    // static int lcs(String s1, String s2) {
    //     int n = s1.length();
    //     int m = s2.length();
    //     int[][] dp = new int[n][m];
    //     for(int[] row :dp) Arrays.fill(row,-1);
    //     return func(n-1,m-1,n,m,s1,s2,dp);
    // }
    // static int func(int i,int j, int n, int m,String s1, String s2,int[][] dp){
    //     if(i < 0 || j < 0)return 0;
        
    //     if(dp[i][j] != -1)return dp[i][j];
    //     // both characters equal so increase by 1
    //     if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + func(i-1,j-1,n,m,s1,s2,dp);
        
    //     return dp[i][j] = 0 + Math.max(func(i-1,j,n,m,s1,s2,dp) , func(i,j-1,n,m,s1,s2,dp));
    // }
    
    // Tabulation
    // static int lcs(String s1, String s2) {
    //     int n = s1.length();
    //     int m = s2.length();
    //     int[][] dp = new int[n+1][m+1];
        
    //     // perform shifting of index so that -1 index is treated as 0 index
        
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
    //             else dp[i][j] = 0 + Math.max(dp[i-1][j] , dp[i][j-1]);
            
    //         }
    //     }
        
    //     return dp[n][m];
    // }
    
    // Space optimization
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];
        
        // perform shifting of index so that -1 index is treated as 0 index
        
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = 0 + Math.max(prev[j] , curr[j-1]);
            }
            prev = curr;
        }
        
        return prev[m];
    }
    
}