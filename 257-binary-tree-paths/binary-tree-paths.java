/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    public void helper(TreeNode root, List<String> ans, StringBuilder curr){
        if(root == null)return;
        int curr_length= curr.length();
        if(curr.length() != 0)curr.append("->");
        curr.append(root.val);
        if(isLeaf(root)){
            // store the answer and go back
            ans.add(curr.toString());
        }else{
            helper(root.left,ans,curr);
            helper(root.right,ans,curr);
            
        }
        // back track
        curr.setLength(curr_length);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null)return ans;
        
        StringBuilder curr = new StringBuilder();
        helper(root,ans,curr);
        return ans;
    }
}