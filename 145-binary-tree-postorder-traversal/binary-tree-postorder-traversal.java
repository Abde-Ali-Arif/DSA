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
    
    // //  Recursive Solution
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     if(root == null)return res;

    //     res.addAll(postorderTraversal(root.left));
    //     res.addAll(postorderTraversal(root.right));
    //     res.add(root.val);
    //     return res;
    // }

    // // Iterative solution using Two Stacks
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     if(root == null)return res;

    //     Stack<TreeNode> st= new Stack<>();
    //     Stack<Integer> ans =new Stack<>();
    //     st.push(root);
    //     while(!st.isEmpty()){
    //         TreeNode temp = st.pop();
    //         ans.push(temp.val);
    //         if(temp.left != null) st.push(temp.left);
    //         if(temp.right != null) st.push(temp.right);
    //     }
    //     while(!ans.isEmpty()){
    //         res.add(ans.pop());
    //     }
    //     return res;
    // }


    // Iterative solution using single Stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)return res;

        Stack<TreeNode> st= new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            res.add(temp.val);
            if(temp.left != null) st.push(temp.left);
            if(temp.right != null) st.push(temp.right);
        }
        Collections.reverse(res);
        return res;
    }

}