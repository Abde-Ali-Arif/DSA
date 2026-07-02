class Node {
    Node[] links;
    Node(){
        links=new Node[26];
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
        
}
class Solution {
    public static int countSubs(String s) {
        Node root = new Node();
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Node temp = root;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (!temp.containsKey(ch)) {
                    temp.set(ch);
                    cnt++;              // New distinct substring found
                }
                temp = temp.get(ch);
            }
        }
        return cnt;
    }
}