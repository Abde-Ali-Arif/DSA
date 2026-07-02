class Solution {
    class Pair{
        int r;
        int c;
        int healt;
        Pair(int row,int col,int health){
            r=row;
            c=col;
            healt=health;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        int[][] vis= new int[n][m];
        int[] drow={-1,0,0,1};
        int[] dcol={0,-1,1,0};
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,0,health-grid.get(0).get(0)));

        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.r;
            int col=p.c;
            int healt=p.healt;
            if(row == n-1 && col == m-1 && healt > 0)return true;

            for(int i=0;i<4;i++){
                int nrow =row+drow[i];
                int ncol =col+dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int nhealt=healt-grid.get(nrow).get(ncol);
                    if(vis[nrow][ncol] < nhealt && nhealt > 0){
                        // cell is valid now try to vis it
                        q.offer(new Pair(nrow,ncol,nhealt));
                        vis[nrow][ncol]=nhealt;
                    }
                }
            }
        }
        return false;
    }
}