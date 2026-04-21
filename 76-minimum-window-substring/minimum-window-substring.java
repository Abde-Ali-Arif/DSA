class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())return "";
        int minLen=Integer.MAX_VALUE;
        int l=0,r=0,startInd=-1,cnt=0;
        int[] hash=new int[256];

        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)-'A']++;
        }

        while(r<s.length()){
            if(hash[s.charAt(r) - 'A']-- > 0)cnt++;
            // hash[s.charAt(r) - 'A']--;
            while(cnt == t.length() && l < s.length()){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    startInd=l;
                }
                // hash[s.charAt(l)-'A']++;
                if(++hash[s.charAt(l)-'A'] > 0)cnt--;
                l++;
            }
            r++;
        }
        return (startInd == -1)? "": s.substring(startInd,minLen+startInd);
    }
}