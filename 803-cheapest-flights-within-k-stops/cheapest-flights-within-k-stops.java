class Solution {
    class PQ{
        int dist;
        int stop;
        int node;
        PQ(int dist,int stop,int node){
            this.stop=stop;
            this.node=node;
            this.dist=dist;
        }
    }
    class Pair{
        int dist;
        int node;
        Pair(int dist,int node){
            this.node=node;
            this.dist=dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] dist= new int[n];
        // assign max dist and get ready with directed graph
        for(int i=0;i<n;i++){
            dist[i]=(int)1e9;
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][2],flights[i][1]));
        }
        
        Queue<PQ> q= new LinkedList<>();
        q.add(new PQ(0,0,src));
        dist[src]=0;
        
        while(!q.isEmpty()){
            PQ curr= q.poll();
            int stop=curr.stop;
            int node=curr.node;
            int dis=curr.dist;
            // queue will have all elements in increasing order of stops so we can break if particular stop reached
            if(stop > k)break;
            for(Pair it:adj.get(node)){
                int adjnode=it.node;
                int wt= it.dist;
                if(dis+wt < dist[adjnode]){
                    dist[adjnode]=dis+wt;
                    q.add(new PQ(dist[adjnode],stop+1,adjnode));
                }
            }
        }
        return (dist[dst] == (int)1e9)?-1:dist[dst];
    }
}