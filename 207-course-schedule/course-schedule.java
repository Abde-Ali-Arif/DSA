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
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V=numCourses;
        int[] vis = new int[V];
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // Traversal for DFS
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                // if any of the component returns true
                // means cycle is present so courses cannot be done
                if(dfs(i,adj,vis))return false;
            }
        }

        // if no cycle found so it is possible to do courses
       return true; 
    }
}