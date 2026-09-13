class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int len=0;
        int curr=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch == ' '){
                curr=0;
                continue;
            }else {
                curr++;
                len=curr;
            }
        }
        return len;
    }
}