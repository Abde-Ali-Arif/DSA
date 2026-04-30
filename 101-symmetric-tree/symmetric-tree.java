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
    public boolean isSymmetric(TreeNode root) {
        // divide the tree from root into two halves 
        return isSameTree(root.left,root.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if both null means similar
        if(p == null && q == null) return true;
        // if any one null then no need for further exploration just return false
        if(p == null || q == null) return false;

        // if value is disimilar return false
        if(p.val != q.val)return false;

        // none of the above condition execute so it is known that the current node is similar
        // check for its children (check left with its right child and vice versa)
        return isSameTree(p.left,q.right) && isSameTree(p.right,q.left);
    }
}