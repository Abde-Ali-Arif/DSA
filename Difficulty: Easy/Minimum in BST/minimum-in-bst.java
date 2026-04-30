/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    public int minValue(Node root) {
        // if null return -1
        if(root == null)return -1;
        
        // if no left child means that current element is the smallest because of BST property so return curr value
        if (root.left == null)return root.data;
        // if it has left child then go and traverse it 
        return minValue(root.left);
    }
}