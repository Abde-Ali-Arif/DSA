class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int it:nums){
            min= Math.min(min,it);
            max= Math.max(max,it);
        }
        long ans=max-min;
        ans=ans*k;
        return ans;
    }
}