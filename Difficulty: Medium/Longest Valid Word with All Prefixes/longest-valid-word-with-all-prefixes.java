class Node {
    Node[] links;
    boolean flag;
    Node(){
        links=new Node[26];
        flag=false;
    }
    
    void set(char ch){
        links[ch-'a']=new Node();
    }
    
    boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
    
    void setEnd(){
        flag=true;
    }
    
    boolean isEnd(){
        return flag;
    }
        
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Node temp=root;
        for(int i=0;i<word.length();i++){
            if(!temp.containsKey(word.charAt(i))){
                temp.set(word.charAt(i));
            }
            temp=temp.get(word.charAt(i));
        }
        temp.setEnd();
    }
    
    public boolean check(String word){
        // boolean ans=true;
        Node temp=root;
        for(int i=0;i<word.length();i++){
            if(!temp.containsKey(word.charAt(i))){
                return false;
            }
            temp=temp.get(word.charAt(i));
            if(!temp.isEnd())return false;
        }
        return true;
        
    }
    
}
class Solution {
    public String longestValidWord(String[] words) {
        Trie trie=new Trie();
        for(String it:words){
            trie.insert(it);
        }
        
        String longest="";
        
        for(String it:words){
            if(trie.check(it)){
                if(longest.length() < it.length()) longest=it;
                else if(longest.length() == it.length() && it.compareTo(longest) < 0)longest=it;
            }
        }
        return longest;
    }
}