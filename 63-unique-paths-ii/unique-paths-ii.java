class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] path=new int[m][n];
        for(int[] it:path){
            Arrays.fill(it,-1);
        }
        path[0][0]=1;
        return func(path,m-1,n-1,m,n,obstacleGrid);
    }
    public int func(int[][] path,int row,int col,int m,int n,int[][] obstacleGrid){
        if(row < 0 || row >= m || col < 0 || col >= n || obstacleGrid[row][col] == 1) return 0;
        if(path[row][col] != -1)return path[row][col];
        return path[row][col] = func(path,row,col-1,m,n,obstacleGrid) + func(path,row-1,col,m,n,obstacleGrid);
    }
}