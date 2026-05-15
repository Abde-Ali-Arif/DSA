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
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        
        // if any of the source or destination is 1 then traversal is not possible
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)return -1;

        // if source is the destination
        if(0 == n-1 && 0 == m-1)return 1;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],(int)1e9);
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1,0,0));
        dist[0][0]=1;
        while(!q.isEmpty()){
            Pair curr= q.poll();
            int dis= curr.dist;
            int r=curr.r;
            int c= curr.c;

            // visit all 8 directions
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int newr=r+i;
                    int newc=c+j;
                    if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc] == 0
                    && dis +1 <dist[newr][newc]){
                        // if we reached destination
                        if(newr == n-1 && newc == m-1)return dis+1;
                        dist[newr][newc]=dis+1;
                        q.offer(new Pair(dis+1,newr,newc));
                    }
                }
            }
        }
        return -1;
    }
}