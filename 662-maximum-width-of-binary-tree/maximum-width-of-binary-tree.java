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
    class Pair{
        int ind;
        TreeNode node;
        Pair(TreeNode node , int ind){
            this.node = node;
            this.ind=ind;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null)return 0;
        int ans=0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int size= q.size();
            int min = q.peek().ind;
            int first=0, last=0;

            for(int i=0;i<size;i++){
                Pair curr= q.poll();
                int curr_id = curr.ind-min;
                TreeNode node = curr.node;
                if(i==0)first=curr_id;
                if(i==size-1)last=curr_id;
                if(node.left != null)q.offer(new Pair(node.left,curr_id*2+1));
                if(node.right != null)q.offer(new Pair(node.right,curr_id*2+2));
            }
            ans= Math.max(ans,last-first+1);
        }
        return ans;
    }
}