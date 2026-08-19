class Solution {
    public boolean exist(char[][] board, String word) {
        int m= board.length;
        int n=board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board,word,i,j,0,m,n))return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board,String word,int i,int j,int k,int m,int n){
        if(k >= word.length()) return true;
        if(i < 0 || i >= m || j < 0 || j >= n || word.charAt(k) != board[i][j])return false;
        board[i][j]='.';
        int[] row={0,1,0,-1};
        int[] col ={1,0,-1,0};
        boolean temp=false;

        for(int ind=0;ind<4;ind++){
            temp = temp || helper(board,word,i+row[ind],j+col[ind],k+1,m,n);
        }
        // backtrack
        board[i][j]=word.charAt(k);
        return temp;
    }
}