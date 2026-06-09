class Solution {

    // Recursion O(3^(n+m))
    // public int minDistance(String word1, String word2) {
    //     int n=word1.length();
    //     int m = word2.length();
    //     return func(n-1,m-1,word1,word2);
    // }
    // public int func(int i,int j , String word1 , String word2){
    //     if(j < 0)return i+1;
    //     if(i < 0)return j+1;

    //     if(word1.charAt(i) == word2.charAt(j)) return func(i-1,j-1,word1,word2);
    //     return 1+Math.min(func(i,j-1,word1,word2),Math.min(func(i-1,j,word1,word2),func(i-1,j-1,word1,word2)));
    // }

    // Memoization O(n*m)
    // public int minDistance(String word1, String word2) {
    //     int n=word1.length();
    //     int m = word2.length();
    //     int[][] dp = new int[n][m];
    //     for(int[] row:dp) Arrays.fill(row,-1);
    //     return func(n-1,m-1,word1,word2,dp);
    // }
    // public int func(int i,int j , String word1 , String word2,int[][] dp){
    //     if(j < 0)return i+1;
    //     if(i < 0)return j+1;

    //     if(dp[i][j] != -1)return dp[i][j];
    //     if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] = func(i-1,j-1,word1,word2,dp);
    //     return dp[i][j] = 1+Math.min(func(i,j-1,word1,word2,dp),Math.min(func(i-1,j,word1,word2,dp),func(i-1,j-1,word1,word2,dp)));
    // }

    // Memoization with one based indexing O(n*m)
    // public int minDistance(String word1, String word2) {
    //     int n=word1.length();
    //     int m = word2.length();
    //     int[][] dp = new int[n+1][m+1];
    //     for(int[] row:dp) Arrays.fill(row,-1);
    //     return func(n,m,word1,word2,dp);
    // }
    // public int func(int i,int j , String word1 , String word2,int[][] dp){
    //     if(j == 0)return i;
    //     if(i == 0)return j;

    //     if(dp[i][j] != -1)return dp[i][j];
    //     if(word1.charAt(i-1) == word2.charAt(j-1)) return dp[i][j] = func(i-1,j-1,word1,word2,dp);
    //     return dp[i][j] = 1+Math.min(func(i,j-1,word1,word2,dp),Math.min(func(i-1,j,word1,word2,dp),func(i-1,j-1,word1,word2,dp)));
    // }

    // Tabulation with one based indexing O(n*m)
    // public int minDistance(String word1, String word2) {
    //     int n=word1.length();
    //     int m = word2.length();
    //     int[][] dp = new int[n+1][m+1];
    //     // Base case
    //     for(int i=0;i<=n;i++)dp[i][0]=i;
    //     for(int j=0;j<=m;j++)dp[0][j]=j;

    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
    //             else dp[i][j] = 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
    //         }
    //     }
    //     return dp[n][m];
    // }

    // space optimization 
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m = word2.length();
        int[] prev= new int[m+1];
        // Base case
        for(int j=0;j<=m;j++)prev[j]=j;

        for(int i=1;i<=n;i++){
            int[] curr= new int[m+1];
            curr[0]=i;
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) curr[j] = prev[j-1];
                else curr[j] = 1+Math.min(curr[j-1],Math.min(prev[j],prev[j-1]));
            }
            prev = curr;
        }
        return prev[m];
    }
}