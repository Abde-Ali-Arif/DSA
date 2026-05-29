class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path=new int[m][n];
        path[0][0]=1;
        func(path,m-1,n-1,m,n);
        return path[m-1][n-1];
    }
    public int func(int[][] path,int row,int col,int m,int n){
        if(row < 0 || row >= m || col < 0 || col >= n) return 0;
        if(path[row][col] != 0)return path[row][col];
        path[row][col] = func(path,row,col-1,m,n) + func(path,row-1,col,m,n);
        return path[row][col];
    }
}