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

    // uses extra space to store inorder traversal
    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> inorder= new ArrayList<>();
    //     helper(root,inorder);
    //     return inorder.get(k-1);
    // }
    // public void helper(TreeNode node , List<Integer> inorder){
    //     if(node == null)return;
    //     helper(node.left,inorder);
    //     inorder.add(node.val);
    //     helper(node.right,inorder);
    // }

    int cnt=0;
    int ans=-1;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return ans;   
    }
    public void helper(TreeNode root,int k){
        if(root == null || cnt >= k)return ; // cnt >= k (for early stopping)

        helper(root.left,k);
        cnt++;
        // cnt reaches k means it is that number in inorder traversal
        if(cnt == k){
            ans= root.val;
            return;
        }
        helper(root.right,k);
    }
    
}