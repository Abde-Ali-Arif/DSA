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

    // O(n)
    // int cnt =0;
    // public int countNodes(TreeNode root) {
    //     if(root == null)return 0;

    //     helper(root);
    //     return cnt;
    // }
    // public void helper(TreeNode root){
    //     if(root == null) return;
    //     cnt++;
    //     helper(root.left);
    //     helper(root.right);
    // }

    // O((logn)^2)
    // better than O(n)
    public int getLeftHeight(TreeNode curr){
        int depth =0;
        while(curr != null){
            curr=curr.left;
            depth++;
        }
        return depth;
    }
    public int getRightHeight(TreeNode curr){
        int depth =0;
        while(curr != null){
            curr=curr.right;
            depth++;
        }
        return depth;
    }
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
        int lh= getLeftHeight(root);
        int rh = getRightHeight(root);
        if(lh == rh)return (1 << lh)-1;     // means 2^lh -1
        return 1 + countNodes(root.left) + countNodes(root.right);  
    }
}