class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                // find empty cell
                if(board[i][j] == '.'){
                    // try to place any of the character between 1 to 9
                    for(char ch='1' ;ch<='9';ch++){
                        if(isValid(board,i,j,ch)){
                            board[i][j]=ch;
                            if(solve(board))return true;
                            else board[i][j]='.';   //Backtrack
                        }
                    }
                    // not able to place any character so return and update sudoku again
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board,int row,int col,char ch){
        for(int i=0;i<9;i++){
            if(board[i][col] == ch)return false;    // check whole column
            if(board[row][i] == ch)return false;    // check whole row
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == ch) return false;
        }
        return true;
    }
}