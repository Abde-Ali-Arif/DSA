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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length!=inorder.length)return null;
        HashMap<Integer,Integer> inmap= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inmap);
    }
    public TreeNode build(int[] preorder, int st ,int end,int[] inorder,int inst,int inend,HashMap<Integer,Integer> inmap){
        if(st > end || inst > inend)return null;
        TreeNode node = new TreeNode(preorder[st]);
        int inRoot = inmap.get(node.val);
        int numsleft = inRoot-inst;
        node.left=build(preorder,st+1,st+numsleft,inorder,inst,inRoot-1,inmap);
        node.right=build(preorder,st+numsleft+1,end,inorder,inRoot+1,inend,inmap);
        return node;
    }
}