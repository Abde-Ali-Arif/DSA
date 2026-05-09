class Solution {
    public void dfs(int row, int col,char[][] grid,int[] drow,int[] dcol,int n,int m){
        grid[row][col]='2';        

        // visit in all 4 directions (horizontal and vertical)
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            // call dfs anly if it is unvisited
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' ){
                dfs(nrow,ncol,grid,drow,dcol,n,m);
            }
        }
        
        
        
    }
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int cnt=0;

        for(int i= 0;i<n;i++){
            for(int j=0;j<m;j++){
                // if any island found then try to merge all its neighbours using dfs
                // each time dfs is call is over and a new call is made increase cnt 
                if(grid[i][j] == '1'){
                    dfs(i,j,grid,drow,dcol,n,m);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}