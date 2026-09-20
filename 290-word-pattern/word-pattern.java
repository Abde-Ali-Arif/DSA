class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> hash= new HashMap<>();
        String[] words = s.split(" ");
        int n = pattern.length();
        if(n != words.length)return false;
        for(int i=0;i<n;i++){
            char p=pattern.charAt(i);
            if(hash.containsKey(p)){
                if(!words[i].equals(hash.get(p)))return false;
            }else if(hash.containsValue(words[i])){
                return false;
            }else{
                hash.put(p,words[i]);
            }
        }
        return true;
    }
}