class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();


        for(int i=0;i<v;i++)adj.add(new ArrayList<>());
        // forming undirected graph
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] col=new int[v];
        
        return helper(0,col,m,v,adj);
    }
    
    boolean helper(int vertex , int[] col,int m,int v,ArrayList<ArrayList<Integer>> adj){
        if(vertex == v)return true;
        
        for(int i=1;i<=m;i++){
            if(safe(vertex,col,i,adj)){
                col[vertex]=i;
                if(helper(vertex+1,col,m,v,adj))return true;
                col[vertex]=0;
            }
        }
        return false;
    }
    
    boolean safe(int vertex,int[] col,int color,ArrayList<ArrayList<Integer>> adj){
        for(int it:adj.get(vertex)){
            if(color == col[it])return false;
        }
        return true;
    }
}