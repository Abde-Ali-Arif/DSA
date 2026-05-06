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
    public Node markParent(Node root,HashMap<Node,Node> parent, int target){
        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        Node res=null;
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.data == target) res= curr;
            if(curr.left != null){
                parent.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                parent.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
        return res;
    }
    public int minTime(Node root, int target) {
        HashMap<Node,Node> parent = new HashMap<>();
        Node res = markParent(root,parent,target);
        Queue<Node> q= new LinkedList<>();
        // Traverse Start from the point in tree which is the target 
        // Try to go in all possible three directions (just like undirected graph)
        q.offer(res);

        HashMap<Node,Boolean> visited=new HashMap<>();
        visited.put(res,true);
        int time=0;

        while(!q.isEmpty()){
            int size= q.size();
            boolean flag= false;
            
            for(int i=0 ; i<size ; i++){
                Node curr =q.poll();
                // Try to go radially outwards keeping track of visited in all three ways
                if(curr.left != null && visited.get(curr.left) == null ){
                    flag=true;
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right != null && visited.get(curr.right) == null ){
                    flag=true;
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent.get(curr) != null && visited.get(parent.get(curr)) == null ){
                    flag=true;
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
            }
            if(flag)time++;
        }
        return time;
    }
}