class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,maxLen=0;

        while(r < nums.length){
            if(nums[r] == 1){
                r++;
            }
            else if (nums[r] == 0 && k > 0){
                k--;
                r++;
            }else{
                if(nums[l] == 1)l++;
                else{
                    l++;
                    k++;
                }
            }
            maxLen=Math.max(maxLen,r-l);
        }
        return maxLen;
    }
}