class Solution {
    
    // Recursive exponential complexity
    // static int matrixMultiplication(int arr[]) {
    //     int n= arr.length;
    //     return func(1,n-1,arr);
    // }
    // static int func(int i,int j,int[] arr){
    //     if(i == j)return 0;
        
    //     int mini=Integer.MAX_VALUE;
    //     for(int k=i;k<j;k++){
    //         int steps=arr[i-1]*arr[k]*arr[j] + func(i,k,arr) + func(k+1,j,arr);
    //         mini= Math.min(mini,steps);
    //     }
    //     return mini;
    // }
    
    // Memoization O(n^3)
    // static int matrixMultiplication(int arr[]) {
    //     int n= arr.length;
    //     int[][] dp= new int[n][n];
    //     for(int[] row:dp){
    //         Arrays.fill(row,-1);
    //     }
    //     return func(1,n-1,arr,dp);
    // }
    // static int func(int i,int j,int[] arr,int[][] dp){
    //     if(i == j)return 0;
        
    //     if(dp[i][j] != -1)return dp[i][j];
    //     int mini=Integer.MAX_VALUE;
    //     for(int k=i;k<j;k++){
    //         int steps=arr[i-1]*arr[k]*arr[j] + func(i,k,arr,dp) + func(k+1,j,arr,dp);
    //         mini= Math.min(mini,steps);
    //     }
    //     return dp[i][j] = mini;
    // }
    
    // Tabulation
    static int matrixMultiplication(int arr[]) {
        int n= arr.length;
        int[][] dp= new int[n][n];
        // Base case no need because already initialized with zero
        // for(int i=0;i<n;i++)dp[i][i] = 0;
        
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<=n-1;j++){
                int mini=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int steps=arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    mini= Math.min(mini,steps);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][n-1];
    }
}