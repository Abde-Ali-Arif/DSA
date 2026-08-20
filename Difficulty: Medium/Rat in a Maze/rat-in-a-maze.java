class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n= maze.length;
        if(maze[0][0]==0 || maze[n-1][n-1]==0)return new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        maze[0][0]=0;
        helper(0,0,maze,n,res,ans);
        return ans;
    }
    
    private void helper(int row,int col,int[][] maze,int n,StringBuilder res,ArrayList<String> ans){
        if(row == n-1 && col == n-1){
            ans.add(res.toString());
            return;
        }
        
        
        // Directions in alphabetical order: D, L, R, U
        int[] r = {1, 0, 0, -1};
        int[] c = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};
        for(int i=0;i<4;i++){
            int nrow=row+r[i];
            int ncol=col+c[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && maze[nrow][ncol] == 1){
                maze[nrow][ncol]=0;
                res.append(dir[i]);

                helper(nrow,ncol,maze,n,res,ans);
                maze[nrow][ncol]=1;
                res.deleteCharAt(res.length()-1);
            }
        }
    }
}