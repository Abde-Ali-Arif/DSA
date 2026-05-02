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
    // Iteratuve version
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode nn = new TreeNode(val);
        if (root == null)return nn;

        TreeNode node = root;
        while(node != null){
            if(node.val > val ){
                if(node.left != null) node= node.left;
                else {
                    node.left=nn;
                    break;
                }
            }
            else if(node.val < val){
                if(node.right != null)node= node.right;
                else{
                    node.right=nn;
                    break;
                }
            }
        }
        return root;
     }

    // Recursive version
    //  public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if (root == null)return new TreeNode(val);

    //     if(root.val > val) root.left =insertIntoBST(root.left,val);
    //     else root.right= insertIntoBST(root.right,val);
    //     return root;
    //  }
}