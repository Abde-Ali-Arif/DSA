// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist= new int[V];
        for(int i=0;i<V;i++){
            dist[i]=(int)1e8;
        }
        dist[src]=0;
        // Perform relaxation for n-1 iterations
        for(int i=0;i<V-1;i++){
            for(int[] it:edges){
                int u=it[0];
                int v=it[1];
                int wt=it[2];
                if(dist[u] != (int)1e8 && dist[u] + wt < dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        // if in N iteration weights still update then negative cycle exists
        for(int[] it:edges){
                int u=it[0];
                int v=it[1];
                int wt=it[2];
                if(dist[u] != (int)1e8 && dist[u] + wt < dist[v])return new int[]{-1};
        }
        return dist;
    }
}
