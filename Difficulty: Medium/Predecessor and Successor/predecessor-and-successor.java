/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> ans= new ArrayList<>();
        ans.add(null);// predecessor
        ans.add(null);// successor
        helper(root,key,ans);
        return ans;
    }
    public void helper(Node root,int key,ArrayList<Node> ans){
        if(root == null)return;
        
        if(root.data < key){
            // possibly a predecessor
            ans.set(0,root);
            // store it and explore right for greater value
            helper(root.right,key,ans);
        }else if(root.data > key){
            // possibly a successor
            ans.set(1,root);
            // store and explore left for smaller value
            helper(root.left,key,ans);
        }else{
            // key is equal to data so explore both paths
            helper(root.left,key,ans);
            helper(root.right,key,ans);
        }
    }
}