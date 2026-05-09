class Solution {
    class Pair{
        int curr;
        int parnt;
        Pair(int curr,int parnt){
            this.curr=curr;
            this.parnt=parnt;
        }
    }
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
    public boolean bfs(int node, int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        Queue<Pair> q = new LinkedList<>();
        // Add starting node into queue and mark it as visited
        q.add(new Pair(node,parent));
        vis[node]=true;
        
        while(!q.isEmpty()){
            Pair p= q.poll();
            int curr=p.curr;
            int parnt=p.parnt;
            
            // visit all neighbours
            for(Integer it : adj.get(curr)){
                if(!vis[it]){
                    vis[it]=true;
                    q.add(new Pair(it,curr));
                }else if(it != parnt){
                    // it is already visited and is not the parent of curr so cycle confirmed
                    return true;
                }
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
        
        // Traversal for DFS
        // for(int i=0;i<V;i++){
        //     if(!vis[i]){
        //         // if any of the component returns true then return it no need to check further
        //         if(dfs(i,-1,adj,vis))return true;
        //     }
        // }
        
        // Traversal for BFS
        for(int i=0;i<V;i++){
            if(!vis[i]){
                // if any of the component returns true then return it no need to check further
                if(bfs(i,-1,adj,vis))return true;
            }
        }
        
        // if none of the component returned true then no cycle exists return false
        return false;
    }
}