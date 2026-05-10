class Solution {
    
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,int[] vis){
        // 2:-same path
        // 1:-visited but not from current path
        vis[node]=2;
        
        for(Integer it: adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it,adj,vis))return true;
            }else if(vis[it] == 2){
                // this means it is visited before and is in same path so cycle found
                return true;
            }
        }
        // BackTrack
        vis[node]=1;
        return false;
    }
    
    public boolean bfs( ArrayList<ArrayList<Integer>> adj,int[] vis){
        int V=adj.size();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        int cnt=0;  // this will cnt numbers in toposort
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i] == 0)q.add(i);
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            // reduce indegree of its neighbours 
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)q.add(it);
            }
        }
        
        return cnt != V;
        
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        if(V == 0)return false;
        int[] vis = new int[V];
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        // Traversal for DFS
        // for(int i=0;i<V;i++){
        //     if(vis[i] == 0){
        //         // if any of the component returns true then return it no need to check further
        //         if(dfs(i,adj,vis))return true;
        //     }
        // }
        
        if(bfs(adj,vis))return true;
        return false;
    }
}