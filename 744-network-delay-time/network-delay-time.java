class Solution {
    class Pair{
        int dist;
        int node;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // (n+1) beacuse nodes numbering start from 1 so we need last n index also 
        // 0 index will be empty
        int[] dist= new int[n+1];
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
            dist[i]=(int)1e9;
        }
        // create a directed graph 
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(k,0));
        dist[k]=0;

        while(!pq.isEmpty()){
            Pair curr= pq.poll();
            int node= curr.node;
            int dis= curr.dist;

            // visit all its neighbours
            for(Pair it:adj.get(node)){
                int wt=it.dist;
                int adjnode=it.node;
                if(dis+wt < dist[adjnode]){
                    dist[adjnode]=dis+wt;
                    pq.add(new Pair(adjnode,dis+wt));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++){
            max= Math.max(max,dist[i]);
        }
        return (max == (int)1e9)?-1:max;
    }
}