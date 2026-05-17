class Solution {
    class Pair{
        int steps;
        int node;
        Pair(int node,int dist){
            this.node=node;
            this.steps=dist;
        }
    }
    public int minSteps(int[] arr, int start, int end) {
        if(start == end) return 0;
        int mod=1000;
        Queue<Pair> q = new LinkedList<>();
        // Node , steps
        q.add(new Pair(start,0));
        int[] dist= new int[1000];
        Arrays.fill(dist,(int)1e9);
        dist[start]=0;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int node= curr.node;
            int steps=curr.steps;
            
            for(int it :arr){
                int num = (int)(((long)it * node) % mod);
                if(steps + 1 < dist[num]){
                    dist[num]=steps+1;
                    if(num==end)return steps+1;
                    q.add(new Pair(num,steps+1));
                }
            }
        }
        return -1;
    }
}