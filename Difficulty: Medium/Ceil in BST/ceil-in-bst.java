/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        if(root == null)return -1;
        
        if(root.data == x)return root.data;
        
        else if(root.data < x) {
            return findCeil(root.right ,x);
        }else {
            // try to find more closer ans and if it returns -1 then return the root.data
            int leftCeil= findCeil(root.left ,x);
            if(leftCeil >= x)return leftCeil;
            return root.data;
        }
    }
}