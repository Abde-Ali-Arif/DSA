class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[] prev = new int[n+1];
        
        // perform shifting of index so that -1 index is treated as 0 index
        
        for(int i=1;i<=n;i++){
            int[] curr = new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == s2.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j] , curr[j-1]);
            }
            prev = curr;
        }
        return n-prev[n];
    }
}