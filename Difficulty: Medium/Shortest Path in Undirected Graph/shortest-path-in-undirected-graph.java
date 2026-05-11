class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        // get ready with graph
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        // initialize distance array
        int[] dist= new int[V];
        for(int i=0;i<V;i++)dist[i]=Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        
        // add source to queue and its dist should be zero
        q.add(src);
        dist[src]=0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                if(dist[node]+1 < dist[it]){
                    dist[it]=dist[node]+1;
                    q.add(it);
                }
            }
        }
        // if not rechable then set it to -1
        for(int i=0;i<V;i++){
            if(dist[i] == Integer.MAX_VALUE)dist[i]=-1;
        }
        return dist;
    }
}
