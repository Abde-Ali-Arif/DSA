class Solution {
    class Pair{
        int row;
        int col;
        int time;
        public Pair (int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n= grid.length;     //row
        int m=grid[0].length;   //col

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int freshcnt=0;

        // Get ready with visited array for traversal
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // rotten Oranges
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Pair(i,j,0));
                }else{
                    // no Orange or fresh Orange
                    vis[i][j]=0;
                }
                if(grid[i][j] == 1)freshcnt++;
            }
        }

        int time=0;
        int cnt=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        // Start BFS traversal
        while(!q.isEmpty()){
            Pair p= q.poll();
            int r=p.row , c=p.col , t=p.time;
            time=Math.max(time,t);

            // visit in all 4 directions
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1 ){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }

        // check all oranges are rotten or not
        if(freshcnt != cnt)return -1;
        return time;
    }
}