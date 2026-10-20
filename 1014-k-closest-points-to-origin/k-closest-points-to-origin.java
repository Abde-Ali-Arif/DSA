class Solution {
    class Pair{
        int x;
        int y;
        double dist;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
            this.dist = ((double) x * x) + ((double) y * y);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.dist, a.dist));

        for(int[] arr:points){
            pq.offer(new Pair(arr[0],arr[1]));

            if(pq.size() > k)pq.poll();
        }
        int[][] ans=new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            ans[i][0]=p.x;
            ans[i][1]=p.y;
            i++;
        }
        return ans;
    }
}