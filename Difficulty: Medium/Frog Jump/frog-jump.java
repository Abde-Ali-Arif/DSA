class Solution {
    // Recursive
    // int minCost(int[] height) {
    //     return func(height.length-1,height);
    // }
    // int func(int ind , int[] height){
    //     if(ind == 0)return 0;
        
    //     int left=func(ind -1,height) + Math.abs(height[ind] - height[ind-1]);
    //     int right=Integer.MAX_VALUE;
    //     if(ind > 1)right= func(ind-2,height)+ Math.abs(height[ind] -height[ind-2]);
    //     return Math.min(left,right);
    // }
    
    // Memoization
    // int minCost(int[] height) {
    //     int n=height.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp,-1);
    //     return func(n-1,height,dp);
    // }
    // int func(int ind , int[] height,int[] dp){
    //     if(ind == 0)return 0;
    //     // if already computed just return no need to again compute
    //     if(dp[ind] != -1)return dp[ind];
        
    //     int left=func(ind -1,height,dp) + Math.abs(height[ind] - height[ind-1]);
    //     int right=Integer.MAX_VALUE;
    //     if(ind > 1)right= func(ind-2,height,dp)+ Math.abs(height[ind] -height[ind-2]);
    //     return dp[ind] = Math.min(left,right);
    // }
    
    // Tabulation 
    // int minCost(int[] height) {
    //     int n=height.length;
    //     int[] dp = new int[n];
    //     dp[0]=0;
    //     for(int i=1;i<n;i++){
    //         int left=dp[i-1] + Math.abs(height[i] - height[i-1]);
    //         int right=Integer.MAX_VALUE;
    //         if(i > 1)right= dp[i-2] + Math.abs(height[i] -height[i-2]);
    //         dp[i]=Math.min(left,right);
    //     }
    //     return dp[n-1];
    // }
    
    // Space optimization
    int minCost(int[] height) {
        int n=height.length;
        int prev =0,prev2=0;
        
        for(int i=1;i<n;i++){
            int left=prev + Math.abs(height[i] - height[i-1]);
            int right=Integer.MAX_VALUE;
            if(i > 1)right= prev2 + Math.abs(height[i] -height[i-2]);
            int curr=Math.min(left,right);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}