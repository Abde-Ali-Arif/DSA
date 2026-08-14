class Solution {

    // O(n^2)
    // public int maximumLengthSubstring(String s) {
    //     int n=s.length();
    //     int len=0;
    //     for(int i=0;i<n;i++){
    //         int[] hash=new int[26];
    //         for(int j=i;j<n;j++){
    //             int ind=s.charAt(j)-'a';
    //             hash[ind]++;
    //             if(hash[ind] > 2) break;
    //             len=Math.max(len,j-i+1);
    //         }
    //     }
    //     return len;
    // }

    // O(2n)
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int[] hash=new int[26];
        int len=0,l=0,r=0;

        while(r < n){
            int ind=s.charAt(r)-'a';
            hash[ind]++;
            
            while(hash[ind] > 2){
                int nind = s.charAt(l)-'a';
                hash[nind]--;
                l++;
            }
            len=Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
}