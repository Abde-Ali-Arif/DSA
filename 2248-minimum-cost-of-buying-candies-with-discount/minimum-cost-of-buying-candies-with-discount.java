class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int totalcst=0;
        int mincst=Integer.MAX_VALUE;
        int cnt =0;
        for(int i=cost.length-1;i>=0;i--){
            // include it in total cost if we have not purchased 2 candies else reset cnt
            if(cnt < 2 ){
                cnt++;
                totalcst += cost[i];
                mincst=Math.min(mincst,cost[i]);
            }else {
                cnt=0;
            }
        }
        return totalcst;
    }
}