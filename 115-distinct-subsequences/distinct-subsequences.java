class Solution {

    // Recursive O(2^(n+m))
    // public int numDistinct(String s, String t) {
    //     int n=s.length();
    //     int m = t.length();
    //     return func(n-1,m-1,s,t);
    // }
    // public int func(int i,int j , String s , String t){
    //     if(j < 0)return 1;
    //     if(i < 0)return 0;
    //     // (once take this matched char and reduce j) + (once dont reduce and search for same character in future)
    //     if(s.charAt(i) == t.charAt(j)) return func(i-1,j-1,s,t) + func(i-1,j,s,t);
    //     return func(i-1,j,s,t);
    // }

    // Memoization O(n*m)
    // public int numDistinct(String s, String t) {
    //     int n=s.length();
    //     int m = t.length();
    //     int[][] dp = new int[n][m];
    //     for(int[] row:dp) Arrays.fill(row,-1);
    //     return func(n-1,m-1,s,t,dp);
    // }
    // public int func(int i,int j , String s , String t,int[][] dp){
    //     if(j < 0)return 1;
    //     if(i < 0)return 0;
    //     if(dp[i][j] != -1)return dp[i][j];
    //     if(s.charAt(i) == t.charAt(j)) return dp[i][j]=func(i-1,j-1,s,t,dp) + func(i-1,j,s,t,dp);
    //     return dp[i][j] = func(i-1,j,s,t,dp);
    // }

    // Tabulation O(n*m)
    // public int numDistinct(String s, String t) {
    //     int n=s.length();
    //     int m = t.length();
    //     int[][] dp = new int[n+1][m+1];
    //     // Base case if t is over then one possible answer found
    //     for(int i=0;i<=n;i++)dp[i][0]=1;

    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+ dp[i-1][j];
    //             else dp[i][j] = dp[i-1][j];
    //         }
    //     }
    //     return dp[n][m];
    // }

    // Space optimization O(n*m)
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        // Base case if t is over then one possible answer found
        prev[0]=1;

        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            curr[0]=1;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)) curr[j]=prev[j-1]+ prev[j];
                else curr[j] = prev[j];
            }
            prev = curr;
        }
        return prev[m];
    }
}