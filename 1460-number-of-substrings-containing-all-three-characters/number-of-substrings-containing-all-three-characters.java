class Solution {
    public int numberOfSubstrings(String s) {
        int r=0,cnt=0;
        int[] lastSeen={-1,-1,-1};


        while(r<s.length()){
            lastSeen[s.charAt(r) - 'a']=r;
            
            int min = lastSeen[0];
            if (lastSeen[1] < min) min = lastSeen[1];
            if (lastSeen[2] < min) min = lastSeen[2];
            cnt += min+1;
            r++;
        }
        return cnt;
    }
}