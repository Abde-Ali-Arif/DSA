class Solution {
    class Pair{
        int dist;
        int r;
        int c;
        Pair(int dist,int r,int c){
            this.r=r;
            this.c=c;
            this.dist=dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m= heights[0].length;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }

        PriorityQueue<Pair> q= new PriorityQueue<>((a,b)->a.dist-b.dist);
        q.add(new Pair(0,0,0));
        dist[0][0]=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.r;
            int c=p.c;
            int dis=p.dist;
            for(int i=0;i<4;i++){
                int row=r+drow[i];
                int col=c+dcol[i];
                if(row>=0 && row<n && col>=0 && col<m &&
                Math.max(Math.abs(heights[r][c]-heights[row][col]), dist[r][c]) < dist[row][col] ){
                    dist[row][col]=Math.max(Math.abs(heights[r][c]-heights[row][col]), dist[r][c]);
                    q.add(new Pair(dist[row][col],row,col));
                }
            }
        }
        return dist[n-1][m-1];
    }
}