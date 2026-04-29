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
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        return (helper(root) == -1)?false:true;
    }
    public int helper(TreeNode root ){
        if(root == null) return 0;
        
        int lh=helper(root.left);
        // no need for futher exploration because the tree is already known to be unbalanced
        if(lh == -1)return -1; 
        int rh=helper(root.right);
        if (rh == -1)return -1;
        
        // means height is greater than 2 so no need to move further
        if(Math.abs(lh - rh) > 1) return -1; 
        return  Math.max(lh,rh)+1;
    }
}