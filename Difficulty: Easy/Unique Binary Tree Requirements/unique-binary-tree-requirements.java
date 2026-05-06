// User function Template for Java

class Solution {

    public static boolean isPossible(int a, int b) {
        // inoder traversal is needed to built a unique BT
        // if inorder is present and other should be any of other return true
        if(a == 2 && b == 2)return false;
        return (a == 2 || b == 2)?true:false;
    }
}