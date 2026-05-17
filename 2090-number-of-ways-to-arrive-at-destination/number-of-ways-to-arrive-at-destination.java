class Solution {
    class Pair{
        long dist;
        int node;
        Pair(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        long[] dist= new long[n];
        int[] ways= new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            dist[i]=Long.MAX_VALUE;
        }
        // create a undirected graph 
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        pq.add(new Pair(0,0));
        dist[0]= 0;
        ways[0]= 1;
        int mod=(int)1e9+7;

        while(!pq.isEmpty()){
            Pair curr= pq.poll();
            int node= curr.node;
            long dis= curr.dist;

            // visit all its neighbours
            for(Pair it:adj.get(node)){
                long wt=it.dist;
                int adjnode=it.node;
                // if visiting first time assgin value and add it to queue
                if(dis+wt < dist[adjnode]){
                    ways[adjnode]= ways[node];
                    dist[adjnode]=dis+wt;
                    pq.add(new Pair(adjnode,dis+wt));
                }
                // if visiting the same short path again then increase count of ways
                else if(dis+wt == dist[adjnode]){
                    ways[adjnode]=(ways[node] + ways[adjnode]) % mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}