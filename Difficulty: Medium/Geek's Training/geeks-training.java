class Solution {
    // Recursive
    // public int maximumPoints(int mat[][]) {
    //     int n=mat.length;
    //     return func(n-1,3,mat);
    // }
    // public int func(int day,int last,int[][] mat){
    //     if(day == 0){
    //         int maxi=0;
    //         for(int i=0;i<=2;i++){
    //             if(i != last)maxi=Math.max(maxi,mat[0][i]);
    //         }
    //         return maxi;
    //     }
    //     int maxi=0;
    //     for(int i=0;i<=2;i++){
    //         if(i != last){
    //             int points = mat[day][i] + func(day-1,i,mat);
    //             maxi=Math.max(maxi,points);
    //         }
    //     }
    //     return maxi;
    // }
    
    // Memoized code
    public int maximumPoints(int mat[][]) {
        int n=mat.length;
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return func(n-1,3,mat,dp);
    }
    public int func(int day,int last,int[][] mat,int[][] dp){
        if(day == 0){
            int maxi=0;
            for(int i=0;i<=2;i++){
                if(i != last)maxi=Math.max(maxi,mat[0][i]);
            }
            return maxi;
        }
        if(dp[day][last] != -1)return dp[day][last];
        int maxi=0;
        for(int i=0;i<=2;i++){
            if(i != last){
                int points = mat[day][i] + func(day-1,i,mat,dp);
                maxi=Math.max(maxi,points);
            }
        }
        return dp[day][last]=maxi;
    }
}