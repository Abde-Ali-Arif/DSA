class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return helper(nums,0,n-1,0,0,true);
    }

    boolean helper(int[] nums , int start,int end, int s1, int s2, boolean flag){
        if(start > end){
            if(s1 >= s2) return true;
            return false;
        }

        if(flag) return helper(nums,start+1,end,s1+nums[start],s2,!flag) || helper(nums,start,end-1,s1+nums[end],s2,!flag);

        return helper(nums,start+1,end,s1,s2+nums[start],!flag) && helper(nums,start,end-1,s1,s2+nums[end],!flag);
    }
}