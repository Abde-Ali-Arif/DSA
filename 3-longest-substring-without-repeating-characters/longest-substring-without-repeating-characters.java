class Solution {
    // Brute force O(n^2)
    // public int lengthOfLongestSubstring(String s) {
    //     int maxLen=0;

    //     for(int i=0 ;i<s.length();i++){
    //         int[] hash=new int[256];
    //         for(int j =i;j<s.length();j++){
    //             if(hash[s.charAt(j)] == 1)break;
    //             hash[s.charAt(j)] = 1;
    //             int len=j-i+1;
    //             maxLen=Math.max(maxLen,len);
    //         }
    //     }
    //     return maxLen;
    // }

    // Better But r is not moving by one step everytime
    // public int lengthOfLongestSubstring(String s) {
    //     int maxLen=0;
    //     int l=0 ,r=0;

    //     int[] hash=new int[256];
    //     while(r<s.length()){
    //         if(hash[s.charAt(r)] == 1){
    //             hash[s.charAt(l)]=0;
    //             l++;
    //         }else{
    //             hash[s.charAt(r)]=1;
    //             maxLen=Math.max(maxLen,r-l+1);
    //             r++;
    //         }
    //     }
    //     return maxLen;
    // }
    

    // optimal O(n)
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int l=0 ,r=0;

        int[] hash=new int[256];
        // fill index as -1
        Arrays.fill(hash,-1);

        while(r < s.length()){
            if(hash[s.charAt(r)] != -1 && hash[s.charAt(r)] >= l){
                // the above condition tells that the char is already seen and is in range
                l = hash[s.charAt(r)]+1;
            }
            maxLen=Math.max(maxLen,r-l+1);
            hash[s.charAt(r)]=r;
            r++;
        }
        return maxLen;
    }
}