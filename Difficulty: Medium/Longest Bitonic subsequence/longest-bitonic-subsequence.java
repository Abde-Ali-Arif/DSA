class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        // dp1 increasing from 0 to n
        int[] dp1 = new int[n];
        Arrays.fill(dp1,1);
        
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev] < nums[i] && 1+dp1[prev] > dp1[i]){
                    dp1[i]=1+dp1[prev];
                }
            }
        }
        
        // dp2 increasing from n to 0
        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);
        
        for(int i=n-1;i>=0;i--){
            for(int prev=n-1;prev>i;prev--){
                if(nums[prev] < nums[i] && 1+dp2[prev] > dp2[i]){
                    dp2[i]=1+dp2[prev];
                }
            }
        }
        
        // calculate maximum length
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp1[i] > 1 && dp2[i] > 1){
                ans=Math.max(ans,dp1[i]+dp2[i]-1);
            }
        }
        return ans;
    }
}
