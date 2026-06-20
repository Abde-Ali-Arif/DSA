class Solution {
    public boolean isPalindrome(int i,int j,String s){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    // Recursive
    // public int minCut(String s) {
    //     int n=s.length();
    //     return func(0,n,s)-1;
    // }
    // public int func(int ind,int n,String s){
    //     if(ind == n)return 0;

    //     int mini=Integer.MAX_VALUE;
    //     for(int j=ind;j<n;j++){
    //         if(isPalindrome(ind,j,s)){
    //             int cost=1+func(j+1,n,s);
    //             mini=Math.min(mini,cost);
    //         }
    //     }
    //     return mini;
    // }

    // Memoization
    public int minCut(String s) {
        int n=s.length();
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        return func(0,n,s,dp)-1;
    }
    public int func(int ind,int n,String s,int[] dp){
        if(ind == n)return 0;
        if(dp[ind] != -1)return dp[ind];

        int mini=Integer.MAX_VALUE;
        for(int j=ind;j<n;j++){
            if(isPalindrome(ind,j,s)){
                int cost=1+func(j+1,n,s,dp);
                mini=Math.min(mini,cost);
            }
        }
        return dp[ind]=mini;
    }
}