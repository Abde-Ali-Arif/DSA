class Solution {
    
    // Recursive 
    // int ans = 0;
    // public int longCommSubstr(String s1, String s2) {
    //     func(s1.length()-1, s2.length()-1, s1, s2);
    //     return ans;
    // }

    // int func(int i, int j, String s1, String s2) {
    //     if(i < 0 || j < 0) return 0;

    //     int len = 0;
    //     if(s1.charAt(i) == s2.charAt(j)) {
    //         len = 1 + func(i-1, j-1, s1, s2);
    //         ans = Math.max(ans, len);
    //     }
    //     func(i-1, j, s1, s2);
    //     func(i, j-1, s1, s2);
    //     return len;
    // }
    
    
    // memoization
    // int ans=0;
    // public int longCommSubstr(String s1, String s2) {
    //     int n=s1.length();
    //     int m= s2.length();
    //     int[][] dp = new int[n][m];
    //     for(int[] row :dp) Arrays.fill(row,-1);
    //     func(n-1,m-1,n,m,s1,s2,dp);
    //     return ans;
    // }
    // public int func(int i,int j, int n, int m,String s1, String s2,int[][] dp){
    //     if(i < 0 || j < 0)return 0;
        
    //     if(dp[i][j] != -1)return dp[i][j];
        
        
    //     func(i-1, j,n,m, s1, s2,dp);
    //     func(i, j-1,n,m ,s1, s2,dp);
        
    //     // both characters equal so increase by 1
    //     if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + func(i-1,j-1,n,m,s1,s2,dp);
    //     else {
    //         dp[i][j] = 0;
    //     }
    //     ans=Math.max(ans,dp[i][j]);
    //     return dp[i][j];
    // }
    
    // Tabulation
    // public int longCommSubstr(String s1, String s2) {
    //     int n=s1.length();
    //     int m= s2.length();
    //     int[][] dp = new int[n+1][m+1];
    //     int ans=0;
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(s1.charAt(i-1) == s2.charAt(j-1)) {
    //                 dp[i][j] = 1 + dp[i-1][j-1];
    //                 ans=Math.max(ans,dp[i][j]);
    //             }else dp[i][j] = 0;
    //         }
    //     }
    //     return ans;
    // }
    
    // Space optimized
    public int longCommSubstr(String s1, String s2) {
        int n=s1.length();
        int m= s2.length();
        int[] prev = new int[m+1];
        int ans=0;
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                    ans=Math.max(ans,curr[j]);
                }else curr[j] = 0;
            }
            prev=curr;
        }
        return ans;
    }
}