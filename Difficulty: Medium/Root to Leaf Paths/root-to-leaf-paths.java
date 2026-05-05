/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        if(root == null)return ans;
        
        helper(root,ans,curr);
        return ans;
    }
    public void helper(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr){
        if(root == null)return;
        
        curr.add(root.data);
        if(isLeaf(root)){
            // store the answer and go back
            ans.add(new ArrayList<>(curr));
        }else{
            helper(root.left,ans,curr);
            helper(root.right,ans,curr);
            
        }
        // back track
        curr.remove(curr.size()-1);
    }
    public boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
}