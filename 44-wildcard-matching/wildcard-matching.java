class Solution {
    // Recursion O(2^(n+m))
    // public boolean isMatch(String s, String p) {
    //    int n= p.length();
    //    int m =s.length();
    //    return func(n,m,s,p); 
    // }
    // public boolean func(int i,int j, String s, String p){
    //     if(i == 0 && j == 0)return true;
    //     if(i == 0 && j > 0) return false; // if s is left and p over no chance for matching
    //     if(j == 0 && i > 0) {
    //         // check if it is star no problem still valid otherwise false
    //         for(int ii=1; ii<=i;ii++){
    //             if(p.charAt(ii-1) != '*')return false;
    //         }
    //         return true;
    //     }
    //     if(s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '?')return func(i-1,j-1,s,p);
    //     if(p.charAt(i-1) == '*') return func(i-1,j,s,p) || func(i,j-1,s,p);
    //     return false;
    // }

    // Memoization ( a little problem because boolean array if not preinitailized so time complexity is little higher)
    // public boolean isMatch(String s, String p) {
    //    int n= p.length();
    //    int m =s.length();
    //    boolean[][] dp=new boolean[n+1][m+1];
    //    return func(n,m,s,p,dp); 
    // }
    // public boolean func(int i,int j, String s, String p,boolean[][] dp){
    //     if(i == 0 && j == 0)return true;
    //     if(i == 0 && j > 0) return false; // if s is left and p over no chance for matching
    //     if(j == 0 && i > 0) {
    //         // check if it is star no problem still valid otherwise false
    //         for(int ii=1; ii<=i;ii++){
    //             if(p.charAt(ii-1) != '*')return false;
    //         }
    //         return true;
    //     }

    //     if(dp[i][j] != false)return dp[i][j];
    //     if(s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '?')return dp[i][j] =func(i-1,j-1,s,p,dp);
    //     if(p.charAt(i-1) == '*') return dp[i][j] = func(i-1,j,s,p,dp) || func(i,j-1,s,p,dp);
    //     return dp[i][j] = false;
    // }

    // Tabulation
    public boolean isMatch(String s, String p) {
       int n= p.length();
       int m =s.length();
       boolean[][] dp=new boolean[n+1][m+1];
       // Base cases
       dp[0][0] = true;
       for(int i=1;i<=n;i++) {
            boolean flag=true;
            for(int ii=1; ii<=i;ii++){
                if(p.charAt(ii-1) != '*'){
                    flag=false;
                    break;
                }
            }
        dp[i][0]=flag;
       }

       for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
            if(s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '?')dp[i][j]= dp[i-1][j-1];
            else if(p.charAt(i-1) == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
       }
       return dp[n][m]; 
    }

    // space optimization is bit tricky 
    // public boolean isMatch(String s, String p) {
    //     int n = p.length();
    //     int m = s.length();
    //     boolean[] prev = new boolean[m+1];
    //     prev[0] = true;

    //     for(int i=1;i<=n;i++){

    //         boolean[] curr = new boolean[m+1];
    //         boolean flag = true;
    //         for(int ii=1;ii<=i;ii++){
    //             if(p.charAt(ii-1)!='*'){
    //                 flag=false;
    //                 break;
    //             }
    //         }
    //         curr[0]=flag;
    //         for(int j=1;j<=m;j++){
    //             if(s.charAt(j-1)==p.charAt(i-1) || p.charAt(i-1)=='?') curr[j]=prev[j-1];
    //             else if(p.charAt(i-1)=='*') curr[j]=prev[j] || curr[j-1];
    //         }
    //         prev=curr;
    //     }
    //     return prev[m];
    // }
}