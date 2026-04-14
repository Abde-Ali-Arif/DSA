class Solution {
    // O(2n)
    // public int characterReplacement(String s, int k) {
    //     int l=0,r=0,maxlen=0,maxfreq=0;
    //     int[] hash=new int[26];
    //     int n=s.length();

    //     while(r < n){
    //         char ch=s.charAt(r);
    //         hash[ch- 'A']++;
    //         maxfreq=Math.max(maxfreq,hash[ch-'A']);

    //         while((r-l+1)-maxfreq > k ){
    //             hash[s.charAt(l)-'A']--;
    //             l++;
    //         }
    //         if((r-l+1)-maxfreq <= k)maxlen=Math.max(maxlen,r-l+1);
    //         r++;
    //     }
    //     return maxlen;
    // }

    // O(n)
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxlen=0,maxfreq=0;
        int[] hash=new int[26];
        int n=s.length();

        while(r < n){
            char ch=s.charAt(r);
            hash[ch- 'A']++;
            maxfreq=Math.max(maxfreq,hash[ch-'A']);

            if((r-l+1)-maxfreq > k ){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-maxfreq <= k)maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}