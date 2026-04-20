class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max=0;
        int n=cardPoints.length-1;
        int lsum=0,rsum=0;
        int i=0;
        while(i < k){
            lsum += cardPoints[i];
            i++;
        }
        max=Math.max(lsum,max);
        if(k > n)return max;
        i=0;
        while(i < k){
            lsum -=cardPoints[k-i-1];
            rsum +=cardPoints[n-i];
            max=Math.max(lsum+rsum,max);
            i++;
        }
        return max;
    }
}