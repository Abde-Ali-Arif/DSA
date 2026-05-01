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
    class Pair{
        int col;
        Node node;
        Pair(Node node , int col){
            this.col=col;
            this.node= node;
        }
    }

    
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        
        // treemap because hash map is random
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty()){
            int size= q.size();
            
            for(int i=0;i<size;i++){
                Pair curr= q.poll();
                // irrespective of cond that it is present or not just add it
                // the most recent one encountered will be my correct answer update the map every time
                mp.put(curr.col,curr.node.data);
                
                if(curr.node.left != null)q.offer(new Pair(curr.node.left,curr.col-1));
                if(curr.node.right != null)q.offer(new Pair(curr.node.right,curr.col+1));
            }
        }
        
        for(int key : mp.keySet()){
            ans.add(mp.get(key));
        }
        
        return ans;
    }
    
    
}