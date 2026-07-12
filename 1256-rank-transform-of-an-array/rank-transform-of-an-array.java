class Solution {

    class Pair{
        int val;
        int ind;
        Pair(int v,int i){
            val=v;
            ind=i;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        for(int i=0;i<arr.length;i++){
            pq.offer(new Pair(arr[i],i));
        }
        int rank=0;
        int prev=Integer.MAX_VALUE;
        int[] ans = new int[arr.length];
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(p.val != prev){
                rank++;
            }
            prev=p.val;
            ans[p.ind]=rank;
        }
        return ans;
    }
}