class Solution {
    public boolean dfs(int node, int[][] adj,int[] vis,int[] check){
        // 2:-same path
        // 1:-visited but not from current path
        vis[node]=2;

        // initially node is not considered safe so mark it as 0
        check[node]=0;
        
        for(Integer it: adj[node]){
            if(vis[it] == 0){
                // if dfs in future return true this means there was a cycle in this path
                // All nodes having outgoing edges to this path will also not bemarked 1(check)
                if(dfs(it,adj,vis,check))return true;
            }else if(vis[it] == 2){
                // this means it is visited before and is in same path so cycle found
                // if cycle found return and it cannot be a safe node 
                return true;
            }
        }
        // BackTrack
        vis[node]=1;

        // reaching this confirms that no cycle exits so mark it as safe node
        check[node]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis= new int[V];
        int[] check= new int[V];

        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,check);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i] == 1)ans.add(i);
        }
        return ans;
    }
}