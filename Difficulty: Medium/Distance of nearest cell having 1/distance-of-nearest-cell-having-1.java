class Solution {
    class Pair{
        int r;
        int c;
        int dist;
        Pair(int row,int col,int dist){
            this.r=row;
            this.c=col;
            this.dist=dist;
        }
    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        
        // Get ready with visited array for traversal
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=grid[i][j];
                if(grid[i][j] == 1)q.add(new Pair(i,j,0));
            }
        }

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.r,c=p.c,dist=p.dist;
            grid[r][c]=dist;
            // visit in all 4 directions
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 ){
                    q.add(new Pair(nrow,ncol,dist+1));
                    vis[nrow][ncol]=1;
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j=0;j<m;j++) {
                row.add(grid[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}