class Solution {
    class Disjoint{
        List<Integer> parent =new ArrayList<>();
        List<Integer> size =new ArrayList<>();
        
        Disjoint(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node){
            if(node == parent.get(node))return node;
            parent.set(node,findUPar(parent.get(node)));
            return parent.get(node);
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
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)return -1;
        Disjoint net = new Disjoint(n);
        for(int i=0;i<connections.length;i++){
            net.unionBySize(connections[i][0],connections[i][1]);
        }
        int nodesNotConnected=0;
        for(int i=0;i<n;i++){
            if(net.findUPar(i) == i)nodesNotConnected++;
        }
        // because only one node start node will be parent of itself and is part of network
        // other all are out of network so there cnt should be increamented
        return nodesNotConnected-1;
    }
}