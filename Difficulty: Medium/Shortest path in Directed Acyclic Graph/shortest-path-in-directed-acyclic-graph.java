// User function Template for Java
class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int x,int y){
            node=x;
            wt=y;
        }
    }
    public void dfs(int node,ArrayList<ArrayList<Pair>> adj , int[] vis,Stack<Integer> st){
        vis[node]=1;
        
        for(Pair it:adj.get(node)){
            if(vis[it.node] == 0){
                dfs(it.node,adj,vis,st);
            }
        }
        // before returning after visiting all its neighbour now add it to stack
        st.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        // Get ready with Directed Acyclic Graph
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        
        // Topological Sort performed
        int[] vis = new int[V];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                dfs(i,adj,vis,st);
            }
        }
        // stack has correct topological sort order
        
        // initialize distance array
        int[] dist= new int[V];
        for(int i=0;i<V;i++)dist[i]=(int)1e9;
        
        // source node distance is 0
        dist[0]=0;
        while(!st.isEmpty()){
            int node=st.pop();
            for(Pair it:adj.get(node)){
                int v=it.node;
                int wt= it.wt;
                if(dist[node]+wt < dist[v]){
                    // smaller wt found
                    dist[v]=dist[node]+wt;
                }
            }
        }
        // if not rechable then set it to -1
        for(int i=0;i<V;i++){
            if(dist[i] == (int)1e9)dist[i]=-1;
        }
        return dist;
    }
}