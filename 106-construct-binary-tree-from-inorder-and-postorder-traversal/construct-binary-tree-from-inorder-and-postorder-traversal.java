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
    public TreeNode build(int[] postorder, int st ,int end,int[] inorder,int inst,int inend,HashMap<Integer,Integer> inmap){
        if(st > end || inst > inend)return null;
        TreeNode node = new TreeNode(postorder[end]);
        int inRoot = inmap.get(node.val);
        int numsleft = inRoot-inst;
        node.left=build(postorder,st,st+numsleft-1,inorder,inst,inRoot-1,inmap);
        node.right=build(postorder,st+numsleft,end-1,inorder,inRoot+1,inend,inmap);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || inorder==null || postorder.length!=inorder.length)return null;
        HashMap<Integer,Integer> inmap= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }
        return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inmap);
    }
}