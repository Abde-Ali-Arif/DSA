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
    int ind=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,Integer.MAX_VALUE);
    }
    public TreeNode construct(int[] preorder , int bound){
        if(ind == preorder.length || preorder[ind] > bound)return null;
        TreeNode root= new TreeNode(preorder[ind++]);
        root.left= construct(preorder,root.val);
        root.right= construct(preorder,bound);
        return root;
    }
}