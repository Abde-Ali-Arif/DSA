/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    
    // Recursive
    // ArrayList<Integer> preOrder(Node root) {
    //     if(root == null)return new ArrayList<>();
        
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     ans.add(root.data);
    //     ans.addAll(preOrder(root.left));
    //     ans.addAll(preOrder(root.right));
    //     return ans;
    // }
    
    //Iterative
    ArrayList<Integer> preOrder(Node root) {
        if(root == null)return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node node = st.pop();
            ans.add(node.data);
            if(node.right != null)st.push(node.right);
            if(node.left != null)st.push(node.left);
        }
        return ans;
    }
}