class Solution {
    
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        if(V == 0)return ans;
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                q.add(i);
                vis[i]=true;
                ans.add(new ArrayList<>());
            }
            while(!q.isEmpty()){
                Integer node = q.poll();
                ans.get(ans.size()-1).add(node);
                // for(int j=0;j<adj.get(node).size();j++){
                //     if(!vis[adj.get(node).get(j)]){
                //     vis[adj.get(node).get(j)]=true;
                //     q.add(adj.get(node).get(j));
                //     }
                // }
                for(Integer it:adj.get(node)){
                    if(!vis[it]){
                        vis[it]=true;
                        q.add(it);
                    }
                }
            }
        }
        return ans;
    }
}