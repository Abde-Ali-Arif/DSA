class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int maxlen=-1,r=0,l=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        
        while(r < s.length()){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
            if(mp.size() > k){
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                if(mp.get(s.charAt(l)) == 0)mp.remove(s.charAt(l));
                l++;
            }
            if(mp.size() == k)maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}