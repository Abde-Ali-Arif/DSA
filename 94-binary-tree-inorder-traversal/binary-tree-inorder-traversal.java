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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)return res;

        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     if(root == null)return res;

    //     Stack<TreeNode> st= new Stack<>();
    //     TreeNode curr = root;

    //     while(curr != null || !st.isEmpty()) {

    //         // Go to leftmost node
    //         while(curr != null) {
    //             st.push(curr);
    //             curr = curr.left;
    //         }

    //         // Process node
    //         curr = st.pop();
    //         res.add(curr.val);

    //         // Move to right subtree
    //         curr = curr.right;
    //     }
    //     return res;
    // }
}