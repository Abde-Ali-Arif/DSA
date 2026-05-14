class Solution {
    class Pair {
        int node;
        int wt;

        Pair(int n,int w) {
            wt = w;
            node = n;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[src]=0;
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.add(new Pair(src,0));
        
        while(pq.size() != 0){
            int dis = pq.peek().wt;
            int node =pq.poll().node;
            for(Pair it:adj.get(node)){
                int adjnode = it.node;
                int edgeWt = it.wt;
                if(dis +edgeWt < dist[adjnode]){
                    dist[adjnode]=dis+edgeWt;
                    pq.add(new Pair(adjnode,dist[adjnode]));
                }
            }
        }
        return dist;
    }
}