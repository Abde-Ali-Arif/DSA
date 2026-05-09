class Solution {
    class Pair{
        int row;
        int col;
        public Pair (int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numEnclaves(int[][] grid) {
        int n= grid.length;     //row
        int m=grid[0].length;   //col

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cnt=0, visCnt=0;

        // Get ready with visited array for traversal
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=grid[i][j];
                if(grid[i][j] == 1){
                    // land found 
                    cnt++;
                    // if on border than mark it as visited and increase visCnt and add to q.
                    if(i == 0 || j == 0 || i == n-1 || j == m-1){
                        visCnt++;
                        vis[i][j]=2;
                        q.add(new Pair(i,j));
                    }
                }
            }
        }

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        // Start BFS traversal
        while(!q.isEmpty()){
            Pair p= q.poll();
            int r=p.row , c=p.col;

            // visit in all 4 directions
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                vis[nrow][ncol] == 1 ){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol]=2;
                    visCnt++;
                }
            }
        }
        return cnt-visCnt;
    }
}