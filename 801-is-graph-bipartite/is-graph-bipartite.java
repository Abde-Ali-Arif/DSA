class Solution {
    public boolean bfs(int node,int[] color,int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node]=1;

        while(!q.isEmpty()){
            int curr=q.poll();
            // color all its neighbours
            for(int it:graph[curr]){
                if(color[it] == 0){
                    // color with opposite color to that of curr 
                    color[it]=(color[curr]==1)?2:1;
                    q.add(it);
                }else if(color[it] == color[curr]){
                    // already colored same so it is not bipartite
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node,int colr,int[] color,int[][] graph) {
        color[node]=colr;
        // color with opposite color to that of node
        int c=(color[node]==1)?2:1;

        for(int it : graph[node]){
            if(color[it] == 0){
                if(!dfs(it,c,color,graph))return false;
            }else if(color[it] == color[node]){
                // already colored same so it is not bipartite
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V= graph.length;
        int[] color = new int[V];   // try to color with 1 and 2
        for(int i=0;i<V;i++){
            if(color[i] == 0){
                // bfs or dfs
                // if(!bfs(i,color,graph))return false;
                if(!dfs(i,1,color,graph))return false;
            }
        }
        return true;
    }
}