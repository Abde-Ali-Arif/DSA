/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        
        helper(root,0,ans);
        return ans;
    }
    public void helper(Node root ,int level,ArrayList<Integer> ans){
        if (root == null)return;
        
        if(level == ans.size())ans.add(root.data);
        if(root.left != null) helper(root.left , level+1,ans);
        if(root.right != null) helper(root.right , level+1,ans);
    }
}