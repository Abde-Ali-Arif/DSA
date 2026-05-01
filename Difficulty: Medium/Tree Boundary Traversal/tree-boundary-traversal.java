/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        
        if (!isLeaf(root))ans.add(root.data);
        addLeft(root,ans);
        addLeaf(root,ans);
        addRight(root,ans);
        return ans;
    }
    
    boolean isLeaf(Node node){
        // if(node.left == null && node.right == null)return true;
        // return false;
        return node.left == null && node.right == null;
    }
    
    void addLeft(Node node , ArrayList<Integer> ans){
        Node curr = node.left;
        while(curr != null){
            // add only if the node is non-leaf node 
            if(!isLeaf(curr)) ans.add(curr.data);
            // go to left if it exists otherwise go to right
            if(curr.left != null)curr=curr.left;
            else curr=curr.right;
        }
    }
    void addLeaf(Node node , ArrayList<Integer> ans){
        // you can perform any traversal in, pre, post but maintain the condition of leaf
        if(isLeaf(node)){
            ans.add(node.data);
            return;
        }
        if(node.left != null)addLeaf(node.left,ans);
        if(node.right != null)addLeaf(node.right,ans);
        
    }
    void addRight(Node node , ArrayList<Integer> ans){
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            // add only if the node is non-leaf node 
            if(!isLeaf(curr)) temp.add(curr.data);
            // go to left if it exists otherwise go to right
            if(curr.right != null)curr=curr.right;
            else curr=curr.left;
        }
        // reverse the temp list so that correct order is maintained
        Collections.reverse(temp);
        ans.addAll(temp);
    }
}