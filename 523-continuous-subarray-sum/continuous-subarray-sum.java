class Solution {
    // O(n^2)
    // public boolean checkSubarraySum(int[] nums, int k) {
    //     int n=nums.length;
    //     for(int i=0;i<n;i++){
    //         int sum=0;
    //         for(int j=i;j<n;j++){
    //             sum += nums[j];
    //             if(j-i+1 > 1 && sum%k == 0)return true;
    //         }
    //     }
    //     return false;
    // }

    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int runningSum=0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(0,-1);
        for(int i=0;i<n;i++){
            runningSum += nums[i];
            int remainder=runningSum%k;
            if(hash.containsKey(remainder)){
                // check that its length is greater than or equal to 2
                int prevInd=hash.get(remainder);
                if(i-prevInd > 1)return true;
            }else hash.put(remainder,i);
        }
        return false;
    }
}