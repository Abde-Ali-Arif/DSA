class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        while(!pq.isEmpty()){
            int s1=pq.poll();
            if(pq.isEmpty()){
                return s1;
            }
            int s2=pq.poll();

            // 2 Cases
            // if equal both destroyed so dont push anything in PQ
            // if unequal push the greater minus(-) smaller
            if(s1 != s2){
                if(s1>s2)pq.offer(s1-s2);
                else pq.offer(s2-s1);
            }
        }
        return 0;
    }
}