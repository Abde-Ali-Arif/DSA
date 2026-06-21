class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt=0;
        for(int i=0;i<costs.length;i++){
            if(costs[i] <= coins){
                // buy
                coins -= costs[i];
                cnt++;
            }else break;
        }
        return cnt;
    }
}