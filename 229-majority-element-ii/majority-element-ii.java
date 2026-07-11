class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Integer> ans = new ArrayList<>();
        int max=n/3;
        for(int key:map.keySet()){
            if(map.get(key) > max)ans.add(key);
        }
        return ans;
    }
}