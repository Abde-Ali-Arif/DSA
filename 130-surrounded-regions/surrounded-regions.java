class Solution {
    class Pair{
        int r;
        int c;
        Pair(int row,int col){
            this.r=row;
            this.c=col;
        }
    }
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        
        char[][] vis = new char[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        // Get ready with visited array for traversal
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=board[i][j];
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == n-1 || j == m-1)){
                    q.add(new Pair(i,j));
                }else{
                    board[i][j]='X';
                }
            }
        }

        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.r,c=p.c;

            // visit in all 4 directions
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && board[nrow][ncol]=='X' && vis[nrow][ncol] =='O' ){
                    q.add(new Pair(nrow,ncol));
                    board[nrow][ncol]='O';
                }
            }
        }
    }
}