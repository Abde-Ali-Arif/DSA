class Solution {
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if(nums[i]==nums[j] && Math.abs(i-j) <= k)return true;
    //         }
    //     }
    //     return false;
    // }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hash= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(nums[i])){
                if(Math.abs(hash.get(nums[i])-i) <= k)return true;
            }
            hash.put(nums[i],i);
        }
        return false;
    }
}