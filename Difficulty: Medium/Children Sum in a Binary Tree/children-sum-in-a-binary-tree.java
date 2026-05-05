/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    
    public boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    public int data(Node node){
        return (node == null)?0:node.data;
    }
    
    public boolean isSumProperty(Node root) {
        if(root == null)return true;
        
        // if Leaf node by default condition holds true return without checking
        if(isLeaf(root))return true;
        
        // if (left + right) == root check for left and right subtrees
        if(root.data != data(root.left)+data(root.right))return false;
        
        return isSumProperty(root.left) && isSumProperty(root.right);
    }
}