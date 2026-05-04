/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // Recursive solution
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null)return null;
        
    //     if(root.val < p.val && root.val < q.val)return lowestCommonAncestor(root.right,p,q);
    //     if(root.val > p.val && root.val > q.val)return lowestCommonAncestor(root.left,p,q);

    //     return root;
    // }

    // iterative
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)return null;
        TreeNode curr= root;
        while(curr != null){
            // p and q both values are biger than curr so no chance of ans in left try in right
            if(curr.val < p.val && curr.val < q.val) curr= curr.right;
            // p and q both values are less than curr so no chance of ans in right try in left
            else if(curr.val > p.val && curr.val > q.val) curr= curr.left;
            // at any point p or q splits or one is equal to curr so it is the ans hence stop
            else break;
        }
        return curr;
    }
}