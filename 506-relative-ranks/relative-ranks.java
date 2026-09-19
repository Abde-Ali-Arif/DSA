class Solution {
    class Pair{
        int num;
        int ind;
        Pair(int num,int ind){
            this.num=num;
            this.ind = ind;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->{return b.num-a.num;});

        for(int i=0;i<score.length;i++)pq.offer(new Pair(score[i],i));

        String[] ans= new String[score.length];

        int rank=1;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(rank == 1){
                ans[p.ind]="Gold Medal";
            }else if(rank == 2){
                ans[p.ind]="Silver Medal";
            }else if(rank == 3){
                ans[p.ind]="Bronze Medal";
            }else ans[p.ind]=rank+"";
            rank++;
        }
        return ans;
    }
}