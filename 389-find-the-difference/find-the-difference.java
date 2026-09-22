class Solution {
    public char findTheDifference(String s, String t) {
        int n=s.length();
        int[] hash = new int[26];

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            hash[ch-'a']++;
        }
        for(int i=0;i<=n;i++){
            char ch=t.charAt(i);
            if(hash[ch-'a'] == 0)return ch;
            hash[ch-'a']--;
        }
        return 'a';
    }
}