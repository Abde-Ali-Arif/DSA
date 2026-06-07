class Solution {
    
    // Recursion
    // public int cutRod(int[] price) {
    //     int n=price.length;
    //     return func(n-1,n,price);
    // }
    // public int func(int ind,int max,int[] price){
    //     if(ind == 0){
    //         if(max < 1)return 0;
    //         else{
    //             return max*price[0];
    //         }
    //     }
    //     int notcut=func(ind-1,max,price);
    //     int cut=0;
    //     if(max >= ind+1) cut = price[ind] + func(ind , max-ind-1,price);
    //     return Math.max(cut,notcut);
    // }
    
    // Memoization
    public int cutRod(int[] price) {
        int n=price.length;
        int[][] dp= new int[n][n+1];
        for(int[] row : dp)Arrays.fill(row,-1);
        return func(n-1,n,price,dp);
    }
    public int func(int ind,int max,int[] price,int[][] dp){
        if(ind == 0){
            if(max < 1)return 0;
            else{
                return max*price[0];
            }
        }
        if(dp[ind][max] != -1) return dp[ind][max];
        int notcut=func(ind-1,max,price,dp);
        int cut=0;
        if(max >= ind+1) cut = price[ind] + func(ind , max-ind-1,price,dp);
        return dp[ind][max] = Math.max(cut,notcut);
    }
}