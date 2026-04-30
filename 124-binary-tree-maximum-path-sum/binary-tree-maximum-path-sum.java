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

    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        heightSum(root);
        return maxSum;
    }
    
    public int heightSum(TreeNode root){
       if(root == null) return 0;
        
        int lsum=Math.max(0,heightSum(root.left));
        int rsum=Math.max(0,heightSum(root.right));
        int currentSum = lsum + rsum + root.val;
        maxSum = Math.max(maxSum,currentSum);
        
        return root.val + Math.max(lsum,rsum);
    }
}