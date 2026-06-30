class Solution {
    public int numberOfSubstrings(String s) {
        int r=0,cnt=0;
        int[] lastSeen={-1,-1,-1};


        while(r<s.length()){
            lastSeen[s.charAt(r) - 'a']=r;
            
            int min =Math.min(Math.min(lastSeen[0],lastSeen[1]),lastSeen[2]);
            cnt += min+1;
            r++;
        }
        return cnt;
    }
}