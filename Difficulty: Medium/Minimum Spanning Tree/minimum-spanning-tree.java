class Solution {
    class Pair {
        int node;
        int wt;

        Pair(int n,int w) {
            wt = w;
            node = n;
        }
    }
    class Disjoint{
        List<Integer> parent =new ArrayList<>();
        List<Integer> size =new ArrayList<>();
        List<Integer> rank =new ArrayList<>();
        
        Disjoint(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
                rank.add(0);
            }
        }

        public int findUPar(int node){
            if(node == parent.get(node))return node;
            parent.set(node,findUPar(parent.get(node)));
            return parent.get(node);
        }
        
        public void unionByRank(int u,int v){
            int ulp_u= findUPar(u);
            int ulp_v= findUPar(v);

            if(ulp_u == ulp_v)return;
            if(rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
            }else if(rank.get(ulp_u) > rank.get(ulp_v)){
                parent.set(ulp_v,ulp_u);
            }else{
                parent.set(ulp_v,ulp_u);
                int ranku=rank.get(ulp_u);
                rank.set(ulp_u,ranku+1);
            }
        }

        public void unionBySize(int u,int v){
            int ulp_u= findUPar(u);
            int ulp_v= findUPar(v);

            if(ulp_u == ulp_v)return;
            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_u) + size.get(ulp_v));
            }else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
    // Kruskal's Algorithm
    public int spanningTree(int V, int[][] edges) {
        
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        int mstwt=0;
        Disjoint ds= new Disjoint(V);
        
        for(int i=0;i<edges.length;i++){
            int wt=edges[i][2];
            int u=edges[i][0];
            int v=edges[i][1];
            if(ds.findUPar(u) != ds.findUPar(v)){
                mstwt+=wt;
                ds.unionByRank(u,v);
            }
        }
        return mstwt;
        
    }
    
    // Prims Algorithm
    // public int spanningTree(int V, int[][] edges) {
    //     ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        
    //     for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
    //     for(int i=0;i<edges.length;i++){
    //         adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
    //         adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
    //     }
        
    //     int[] vis = new int[V];
        
    //     PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.wt-b.wt);
    //     pq.add(new Pair(0,0));  // (node,dist)
    //     int sum=0;
    //     while(!pq.isEmpty()){
    //         int wt= pq.peek().wt;
    //         int node = pq.poll().node;
            
    //         if(vis[node] == 1)continue;
    //         vis[node]=1;
    //         sum+=wt;
    //         for(Pair curr:adj.get(node)){
    //             int adjnode=curr.node;
    //             int edw=curr.wt;
    //             if(vis[adjnode] == 0)pq.add(new Pair(adjnode,edw));
    //         }
    //     }
    //     return sum;
    // }
}
