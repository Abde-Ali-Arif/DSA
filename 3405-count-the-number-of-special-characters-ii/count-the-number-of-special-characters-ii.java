class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] hash=new int[256];
        Arrays.fill(hash,-1);
        int cnt=0;
        // hash all lower case letters
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            if(Character.isLowerCase(ch)){
                hash[ch]=i;
            }
        }
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            // it should be uppercase
            if(!Character.isLowerCase(ch)){
                // all of its lower case should be before the upeercase
                if(hash[ch] == -1 && hash[ch+32] != -1 && hash[ch+32] < i){
                    cnt++;
                }
                // mark this uppercase as used or visited so in future no same uppercase is used
                hash[ch]=i;
            }
        }
        return cnt;
    }
}