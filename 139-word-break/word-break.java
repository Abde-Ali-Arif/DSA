class Solution {
    // Gives TLE
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     int n = s.length();
    //     Set<String> set= new HashSet<>(wordDict);
    //     if(helper(0,0,s,set,n))return true;
    //     return false;
    // }
    // private boolean helper(int start ,int end, String s,Set<String> set,int n){
    //     if(end == n-1){
    //         String snew=s.substring(start,end+1);
    //         if(set.contains(snew)){
    //             return true;
    //         }
    //         return false;
    //     }

    //     boolean temp=false;
    //     String snew=s.substring(start,end+1);
    //     if(set.contains(snew)){
    //         temp=temp || helper(end+1,end+1,s,set,n);
    //     }
    //     temp=temp || helper(start,end+1,s,set,n);
    //     return temp;
    // }

    // Memoized version
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set= new HashSet<>(wordDict);
        int[][] dp = new int[n][n];
        for(int[] it:dp)Arrays.fill(it,-1);

        if(helper(0,0,s,set,n,dp))return true;
        return false;
    }
    private boolean helper(int start ,int end, String s,Set<String> set,int n,int[][] dp){
        if(end == n-1){
            String snew=s.substring(start,end+1);
            if(set.contains(snew)){
                return true;
            }
            return false;
        }
        if(dp[start][end] != -1)return (dp[start][end]==1)?true:false;

        boolean temp=false;
        String snew=s.substring(start,end+1);
        if(set.contains(snew)){
            temp=temp || helper(end+1,end+1,s,set,n,dp);
        }
        temp=temp || helper(start,end+1,s,set,n,dp);
        dp[start][end]=(temp)?1:0;
        return temp;
    }
}