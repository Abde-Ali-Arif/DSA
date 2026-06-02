class Solution {
    // Recursive solution O(3^n * 3^n) = O(9^n)
    // public int maxChocolate(int[][] grid) {
    //     int n=grid.length;
    //     int m= grid[0].length;
    //     return func(grid,0,0,m-1,n,m);
    // }
    // public int func(int[][] grid , int i,int j1,int j2,int n,int m){
    //     // if gone out of bound
    //     if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)return (int)-1e8;
    //     // if reached last row then return
    //     if(i == n-1){
    //         if(j1 == j2)return grid[i][j1];
    //         else return grid[i][j1] + grid[i][j2];
    //     }

    //     int maxi=(int)-1e8;
    //     // Explore all 9 combination of paths
    //     for(int dj1=-1;dj1<=1;dj1++){
    //         for(int dj2=-1;dj2<=1;dj2++){
    //             int value=0;
    //             if(j1 == j2) value += grid[i][j1];
    //             else value +=grid[i][j1]+grid[i][j2];
    //             value +=func(grid,i+1,j1+dj1,j2+dj2,n,m);
    //             maxi=Math.max(maxi,value);
    //         }
    //     }
    //     return maxi;
    // }

    // Memoized version O(n*m*m*9)
    public int maxChocolate(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        int[][][] dp=new int[n][m][m];
        for(int[][] it:dp){
            for(int[] i:it){
                Arrays.fill(i,-1);
            }
        }
        return func(grid,0,0,m-1,n,m,dp);
    }
    public int func(int[][] grid , int i,int j1,int j2,int n,int m,int[][][] dp){
        // if gone out of bound
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)return (int)-1e8;
        // if reached last row then return
        if(i == n-1){
            if(j1 == j2)return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1)return dp[i][j1][j2];
        int maxi=(int)-1e8;
        // Explore all 9 combination of paths
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int value=0;
                if(j1 == j2) value += grid[i][j1];
                else value +=grid[i][j1]+grid[i][j2];
                value +=func(grid,i+1,j1+dj1,j2+dj2,n,m,dp);
                maxi=Math.max(maxi,value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}