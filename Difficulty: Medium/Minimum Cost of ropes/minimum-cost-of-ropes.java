class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int it:arr)pq.offer(it);
        int total_cost=0;
        while(!pq.isEmpty()){
            int r1=pq.poll();
            if(pq.isEmpty())return total_cost;
            int r2=pq.poll();
            total_cost += r2+r1;
            pq.offer(r1+r2);
        }
        return total_cost;
    }
}