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

    // Search for a word in the Trie
    public boolean search(String word) {
        Node temp=root;
        for(int i=0;i<word.length();i++){
            if(!temp.containsKey(word.charAt(i))) return false;
            temp=temp.get(word.charAt(i));
        }
        return temp.isEnd();
    }

    // Check if a prefix exists in the Trie
    public boolean startsWith(String word) {
        Node temp=root;
        for(int i=0;i<word.length();i++){
            if(!temp.containsKey(word.charAt(i))) return false;
            temp=temp.get(word.charAt(i));
        }
        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */