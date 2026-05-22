class Solution {
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
    public int removeStones(int[][] stones) {
        int maxR=0;
        int maxC=0;
        for(int[] i:stones){
            maxR=Math.max(maxR , i[0]);
            maxC=Math.max(maxC , i[1]);
        }

        Disjoint ds= new Disjoint(maxR+maxC+2);
        HashMap<Integer,Integer> map= new HashMap<>();

        for(int[] i:stones){
            int nodeRow=i[0];
            int nodeCol=i[1]+maxR+1;

            ds.unionByRank(nodeRow,nodeCol);
            map.put(nodeRow,1);
            map.put(nodeCol,1);
        }

        int cnt=0;
        for(Map.Entry<Integer,Integer> it: map.entrySet()){
            if(ds.findUPar(it.getKey()) == it.getKey())cnt++;
        }
        return stones.length-cnt;
    }
}