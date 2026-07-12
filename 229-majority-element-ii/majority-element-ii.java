class Solution {
    // Hashing technique used
    // public List<Integer> majorityElement(int[] nums) {
    //     int n=nums.length;
    //     HashMap<Integer,Integer> map = new HashMap<>();

    //     for(int i=0;i<n;i++){
    //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    //     }
    //     List<Integer> ans = new ArrayList<>();
    //     int max=n/3;
    //     for(int key:map.keySet()){
    //         if(map.get(key) > max)ans.add(key);
    //     }
    //     return ans;
    // }

    // Voting Algorithm
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        
        int cnt1=0,cnt2=0;
        int ele1=Integer.MAX_VALUE;
        int ele2=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(cnt1 == 0 && ele2 != nums[i]){
                cnt1++;
                ele1=nums[i];
            }
            else if(cnt2 == 0 && ele1 != nums[i]){
                cnt2++;
                ele2=nums[i];
            }
            else if( ele1 == nums[i]) cnt1++;
            else if( ele2 == nums[i]) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int max=n/3;
        int freq1=0,freq2=0;
        for(int i=0;i<n;i++){
            if(nums[i] == ele1)freq1++;
            else if(nums[i] == ele2)freq2++;
        }

        if(freq1 > n/3) ans.add(ele1);
        if(freq2 > n/3) ans.add(ele2);
        return ans;
    }
}