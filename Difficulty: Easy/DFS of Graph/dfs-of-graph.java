class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis= new boolean[adj.size()];
        dfs(0,adj,dfs,vis);
        return dfs;
    }
    public void dfs(int node ,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> dfs,boolean[] vis){
        dfs.add(node);
        vis[node]=true;
        
        // First traverse neighbours most deepest
        for(Integer it: adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,dfs,vis);
            }
        }
    }
    
}