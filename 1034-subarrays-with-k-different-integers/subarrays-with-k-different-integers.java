class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int[] nums, int k){
        if(k<=0)return 0;
        int cnt=0,r=0,l=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        
        while(r < nums.length){
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
            while(mp.size() > k){
                mp.put(nums[l],mp.get(nums[l])-1);
                if(mp.get(nums[l]) == 0)mp.remove(nums[l]);
                l++;
            }
            if(mp.size() <= k)cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}