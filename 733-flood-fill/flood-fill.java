class Solution {
    class Pair{
        int row;
        int col;
        public Pair (int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n= image.length;     //row
        int m=image[0].length;   //col
        int prevColor= image[sr][sc];

        if(prevColor == color)return image;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));     // starting point
        int[][] vis = new int[n][m];

        // Get ready with visited array for traversal
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=image[i][j];
            }
        }
        vis[sr][sc]=color;

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
                vis[nrow][ncol] == prevColor ){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol]=color;
                }
            }
        }
        return vis;
    }
}