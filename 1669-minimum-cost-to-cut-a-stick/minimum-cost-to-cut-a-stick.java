class Solution {
    // Recursion
    // public int minCost(int n, int[] cuts) {
    //     Arrays.sort(cuts);
    //     int c=cuts.length;
    //     int[] arr = new int[c+2];
    //     arr[0]=0;
    //     arr[c+1]=n;
    //     for(int i=1;i<=c;i++) arr[i]=cuts[i-1];

    //     return func(1,c,arr);
    // }
    // public int func(int i,int j, int[] arr){
    //     if(i > j)return 0;
    //     int mini=Integer.MAX_VALUE;
    //     for(int ind = i;ind<=j;ind++){
    //         int cost = arr[j+1] - arr[i-1] + func(i,ind-1,arr) + func(ind+1,j,arr);
    //         mini =Math.min(mini,cost);
    //     }
    //     return mini;
    // }

    // Memoization
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int c=cuts.length;
        int[] arr = new int[c+2];
        arr[0]=0;
        arr[c+1]=n;
        for(int i=1;i<=c;i++) arr[i]=cuts[i-1];
        int[][] dp= new int[c+1][c+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return func(1,c,arr,dp);
    }
    public int func(int i,int j, int[] arr,int[][] dp){
        if(i > j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int ind = i;ind<=j;ind++){
            int cost = arr[j+1] - arr[i-1] + func(i,ind-1,arr,dp) + func(ind+1,j,arr,dp);
            mini =Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
}