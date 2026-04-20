class Solution {
    // O(n^2)
    // public int numberOfSubarrays(int[] nums, int k) {
    //     int cnt =0;
    //     for(int i=0;i<nums.length;i++){
    //         int odd=0;
    //         for(int j=i;j<nums.length;j++){
    //             if(nums[j]%2 != 0){
    //                 odd++;
    //             }
    //             if(odd == k)cnt++;
    //             else if(odd > k)break;
    //         }
    //     }
    //     return cnt;
    // }

    public int numberOfSubarrays(int[] nums, int k) {
        return noOfSubarraysLessOrEqualToGoal(nums,k)-noOfSubarraysLessOrEqualToGoal(nums,k-1);
    }
    public int noOfSubarraysLessOrEqualToGoal(int[] nums, int goal){
        if(goal < 0)return 0;
        int cnt=0,odd=0,l=0,r=0;

        while(r < nums.length){
            if(nums[r]%2 != 0)odd++;

            while(odd > goal){
                if(nums[l]%2 != 0){
                    odd--;
                }
                l++;
            }
            if(odd <= goal){
                cnt +=(r-l+1);
            }
            r++;
        }
        return cnt;
    }
}