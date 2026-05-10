class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V=numCourses;
        int[] order = new int[V];
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        ArrayList<Integer> topo=new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i] == 0)q.add(i);
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            // reduce indegree of its neighbours 
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)q.add(it);
            }
        }
        if(topo.size() != V)return new int[]{};
        for(int i=V-1;i>=0;i--){
            order[i]=topo.remove(0);
        }
        return order;
    }
}