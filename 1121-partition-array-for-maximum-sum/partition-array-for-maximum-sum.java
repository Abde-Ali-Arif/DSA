class Solution {
    // Recursion 
    // public int maxSumAfterPartitioning(int[] arr, int k) {
    //     int n=arr.length;
    //     return func(0,n,k,arr);
    // }
    // public int func(int ind ,int n,int k,int[] arr){
    //     if(ind == n)return 0;

    //     int len=0,maxi=Integer.MIN_VALUE,maxans=Integer.MIN_VALUE;
    //     for(int j=ind;j<Math.min(n,ind+k);j++){
    //         len++;
    //         maxi=Math.max(maxi,arr[j]);
    //         int sum=len*maxi+func(j+1,n,k,arr);
    //         maxans=Math.max(maxans,sum);
    //     }
    //     return maxans;
    // }

    // Memoization
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return func(0,n,k,arr,dp);
    }
    public int func(int ind ,int n,int k,int[] arr,int[] dp){
        if(ind == n)return 0;

        if(dp[ind] != -1)return dp[ind];
        int len=0,maxi=Integer.MIN_VALUE,maxans=Integer.MIN_VALUE;
        for(int j=ind;j<Math.min(n,ind+k);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            int sum=len*maxi+func(j+1,n,k,arr,dp);
            maxans=Math.max(maxans,sum);
        }
        return dp[ind]=maxans;
    }
}