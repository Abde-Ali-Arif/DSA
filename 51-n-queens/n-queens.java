class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] board=new int[n][n];
        helper(0,board,ans,n);
        return ans;
    }
    private void helper(int col,int[][] board,List<List<String>> ans,int n){
        if(col == n){
            List<String> res = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder s=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]==1)s.append("Q");
                    else s.append(".");
                }
                res.add(s.toString());
            }
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col]=1;
                helper(col+1,board,ans,n);
                // Backtrack
                board[row][col]=0;
            }
        }
    }
    private boolean isSafe(int row,int col,int[][] board,int n){

        // Upper Diagonal
        int r=row,c=col;
        while(r >=0 && c >= 0){
            if(board[r][c] == 1)return false;
            r--;c--;
        }
        // Lower Diagonal
        r=row;c=col;
        while(r < n && c >= 0){
            if(board[r][c] == 1)return false;
            r++;c--;
        }
        // left direction
        r=row;c=col;
        while(c >= 0){
            if(board[r][c] == 1)return false;
            c--;
        }
        return true;
    }
}