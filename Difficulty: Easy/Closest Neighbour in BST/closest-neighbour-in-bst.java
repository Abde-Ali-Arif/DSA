/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    public int findMaxFork(Node root, int k) {
        if(root == null)return -1;
        
        if(root.data == k)return root.data;
        
        else if(root.data > k) {
            return findMaxFork(root.left ,k);
        }else {
            // try to find more closer ans in right and if it returns -1 then return the root.data
            int rightNeigh = findMaxFork(root.right ,k);
            if(rightNeigh == -1)return root.data;
            return rightNeigh;
        }
    }
}