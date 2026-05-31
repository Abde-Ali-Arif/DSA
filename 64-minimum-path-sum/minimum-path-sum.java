class Solution {
    // Recursive solution
    // public int minPathSum(int[][] grid) {
    //     int m=grid.length;
    //     int n=grid[0].length;
    //     return func(m-1,n-1,m,n,grid);
    // }
    // public int func(int row,int col,int m,int n,int[][] grid){
    //     if(row < 0 || row >= m || col < 0 || col >= n ) return Integer.MAX_VALUE;
    //     if(row == 0 && col == 0)return grid[row][col];
    //     int up=func(row,col-1,m,n,grid);
    //     int left=func(row-1,col,m,n,grid);
    //     int min =Math.min(up,left);
    //     if(min == Integer.MAX_VALUE)min=0;
    //     return grid[row][col] + min;
    // }

    // Memoization
    // public int minPathSum(int[][] grid) {
    //     int m=grid.length;
    //     int n=grid[0].length;
    //     int[][] path=new int[m][n];
    //     for(int[] it:path){
    //         Arrays.fill(it,Integer.MAX_VALUE);
    //     }
    //     return func(path,m-1,n-1,m,n,grid);
    // }
    // public int func(int[][] path,int row,int col,int m,int n,int[][] grid){
    //     if(row < 0 || row >= m || col < 0 || col >= n ) return Integer.MAX_VALUE;
    //     if(row == 0 && col == 0)return grid[row][col];
    //     if(path[row][col] != Integer.MAX_VALUE)return path[row][col];
    //     int up=func(path,row,col-1,m,n,grid);
    //     int left=func(path,row-1,col,m,n,grid);
    //     int min =Math.min(up,left);
    //     if(min == Integer.MAX_VALUE)min=0;
    //     return path[row][col] = grid[row][col] +min;
    // }

    // Tabulation
    // public int minPathSum(int[][] grid) {
    //     int m=grid.length;
    //     int n=grid[0].length;
    //     int[][] path=new int[m][n];

    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(i == 0 && j == 0) path[0][0]=grid[0][0];
    //             else{
    //                 int up=Integer.MAX_VALUE;
    //                 int left=Integer.MAX_VALUE;
    //                 if(i > 0) up=path[i-1][j];
    //                 if(j > 0) left=path[i][j-1];
    //                 int min =Math.min(up,left);
    //                 path[i][j] = grid[i][j] + min;
    //             }
    //         }
    //     }
    //     return path[m-1][n-1];
    // }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int up = (int)1e9;
                    int left = (int)1e9;
                    if (i > 0) up = prev[j];
                    if (j > 0) left = curr[j - 1];
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}