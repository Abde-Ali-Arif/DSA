class Solution {
    class Pair {
        int node;
        int wt;

        Pair(int n,int w) {
            wt = w;
            node = n;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        
        int[] vis = new int[V];
        
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.add(new Pair(0,0));  // (node,dist)
        int sum=0;
        while(!pq.isEmpty()){
            int wt= pq.peek().wt;
            int node = pq.poll().node;
            
            if(vis[node] == 1)continue;
            vis[node]=1;
            sum+=wt;
            for(Pair curr:adj.get(node)){
                int adjnode=curr.node;
                int edw=curr.wt;
                if(vis[adjnode] == 0)pq.add(new Pair(adjnode,edw));
            }
        }
        return sum;
    }
}
