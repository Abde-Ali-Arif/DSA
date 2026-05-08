class Solution {
    public boolean dfs(int node, int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[node]=true;
        
        for(Integer it: adj.get(node)){
            if(!vis[it]){
                if(dfs(it,node,adj,vis))return true;
            }else if(it != parent){
                // this means it is visited before but is not parent of node so cycle found
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        if(V == 0)return false;
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,-1,adj,vis))return true;
            }
        }
        return false;
    }
}