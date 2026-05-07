/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {
        
    // }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
        
    // }

public List<String> serialize(TreeNode node) {
        List<String> list = new ArrayList<>();
        helper(node, list);
        return list;
    }
    void helper(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(node.val+"");

        helper(node.left, list);
        helper(node.right, list);
    }

    TreeNode deserialize(List<String> list) {
        Collections.reverse(list);
        TreeNode node = helper2(list);
        return node;
    }
    TreeNode helper2(List<String> list) {
        String val = list.remove(list.size() - 1);

        if (val.charAt(0) == 'n') {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = helper2(list);
        node.right = helper2(list);

        return node;
    }




}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));