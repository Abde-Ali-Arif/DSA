class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())return false;
        HashMap<Character,Integer> hash= new HashMap<>();

        // hash all frequency count
        for(int i=0;i<magazine.length();i++){
            char ch=magazine.charAt(i);
            hash.put(ch,hash.getOrDefault(ch,0)+1);
        }

        // now consume each word to form ransomNote
        // if a single char not found in magazine instantly return false
        for(int i=0;i<ransomNote.length();i++){
            char ch=ransomNote.charAt(i);
            if(hash.containsKey(ch)){
                int freq=hash.get(ch);
                hash.remove(ch);
                if(freq > 1)hash.put(ch,freq-1);
            }else return false;
        }
        return true;
    }
}