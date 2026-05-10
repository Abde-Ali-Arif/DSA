class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj , int[] vis,Stack<Integer> st){
        vis[node]=1;
        
        for(Integer it:adj.get(node)){
            if(vis[it] == 0){
                dfs(it,adj,vis,st);
            }
        }
        // before returning after visiting all its neighbour now add it to stack
        st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        int[] vis = new int[V];
        ArrayList<Integer> topo=new ArrayList<>();
        Stack<Integer> st= new Stack<>();
        // Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                dfs(i,adj,vis,st);
            }
        }
        
        while(!st.isEmpty())topo.add(st.pop());
        
        return topo;
        
    }
}