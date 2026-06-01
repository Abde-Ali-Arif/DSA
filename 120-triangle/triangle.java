class Solution {
    // Recursive
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n=triangle.size();
    //     return func(triangle,n,0,0);
    // }
    // public int func(List<List<Integer>> triangle,int n,int row,int col){
    //     // no chance of going col out of bound because each new row will have one more element
    //     if(row == n-1)return triangle.get(row).get(col);
    //     int down= triangle.get(row).get(col) +func(triangle,n,row+1,col);
    //     int diag= triangle.get(row).get(col) +func(triangle,n,row+1,col+1);
    //     return Math.min(down,diag);
    // }

    // Memoization
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n=triangle.size();
    //     int[][] dp= new int[n][n];
    //     for(int[] it:dp){
    //         Arrays.fill(it,-1);
    //     }
    //     return func(triangle,n,0,0,dp);
    // }
    // public int func(List<List<Integer>> triangle,int n,int row,int col,int[][] dp){
    //     // no chance of going col out of bound because each new row will have one more element
    //     if(row == n-1)return triangle.get(row).get(col);
    //     if(dp[row][col] != -1)return dp[row][col];
    //     int down= triangle.get(row).get(col) +func(triangle,n,row+1,col,dp);
    //     int diag= triangle.get(row).get(col) +func(triangle,n,row+1,col+1,dp);
    //     return dp[row][col] = Math.min(down,diag);
    // }

    // Tabulation
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n=triangle.size();
    //     int[][] dp= new int[n][n];
    //     // make dp ready with base cases so that we can move bottom up
    //     for(int i=0;i<n;i++){
    //         dp[n-1][i]=triangle.get(n-1).get(i);
    //     }
    //     for(int row=n-2;row>=0;row--){
    //         for(int col=row;col>=0;col--){
    //             int down=triangle.get(row).get(col) +dp[row+1][col];
    //             int diag=triangle.get(row).get(col) +dp[row+1][col+1];
    //             dp[row][col]=Math.min(down,diag);
    //         }
    //     }
    //     return dp[0][0];
    // }

    // Space Optimization
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp= new int[n];
        // make dp ready with base cases so that we can move bottom up
        for(int i=0;i<n;i++){
            dp[i]=triangle.get(n-1).get(i);
        }
        for(int row=n-2;row>=0;row--){
            int[] curr=new int[n];
            for(int col=row;col>=0;col--){
                int down=triangle.get(row).get(col) +dp[col];
                int diag=triangle.get(row).get(col) +dp[col+1];
                curr[col]=Math.min(down,diag);
            }
            dp=curr;
        }
        return dp[0];
    }
}