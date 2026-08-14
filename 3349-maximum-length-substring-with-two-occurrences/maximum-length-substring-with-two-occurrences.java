class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int len=0;
        for(int i=0;i<n;i++){
            int[] hash=new int[26];
            boolean flag=false;
            for(int j=i;j<n;j++){
                int ind=s.charAt(j)-'a';
                hash[ind]++;
                if(hash[ind] > 2) break;
                len=Math.max(len,j-i+1);
            }
        }
        return len;
    }
}