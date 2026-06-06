class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n= nums.length;
        int[] ans= new int[n];

        // get ready with right sum
        int[] right=new int[n];
        int rsum=0;
        for(int i=n-1;i>=0;i--){
            right[i] = rsum;
            rsum += nums[i];
        }
        
        // prepare answer along with carrying the prefixsum
        int lsum=0;
        for(int i=0;i<n;i++){
            ans[i]=Math.abs(lsum - right[i]);
            lsum += nums[i];
        }
        return ans;
    }
}