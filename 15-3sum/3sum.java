class Solution {
    // O(n^3)
    // public List<List<Integer>> threeSum(int[] nums) {
    //     int n= nums.length;
    //     HashSet<List<Integer>> set= new HashSet<>();
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             for(int k=j+1;k<n;k++){
    //                 if(nums[i]+nums[j]+nums[k] == 0){
    //                     List<Integer> curr= new ArrayList<>();
    //                     curr.add(nums[i]);
    //                     curr.add(nums[j]);
    //                     curr.add(nums[k]);
    //                     Collections.sort(curr);
    //                     set.add(curr);
    //                 }
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans= new ArrayList<>(set);
    //     return ans;
    // }

    // O(n^2)
    // public List<List<Integer>> threeSum(int[] nums) {
    //     int n= nums.length;
    //     HashSet<List<Integer>> set= new HashSet<>();
    //     for(int i=0;i<n;i++){
    //         HashSet<Integer> prev= new HashSet<>();
    //         for(int j=i+1;j<n;j++){
    //             int third= -(nums[i]+nums[j]);
    //             if(prev.contains(third)){
    //                 List<Integer> curr= new ArrayList<>();
    //                 curr.add(third);
    //                 curr.add(nums[i]);
    //                 curr.add(nums[j]);
    //                 Collections.sort(curr);
    //                 set.add(curr);
    //             }
    //             prev.add(nums[j]);
    //         }
    //     }
    //     List<List<Integer>> ans= new ArrayList<>(set);
    //     return ans;
    // }

    // O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1])continue;
            int j=i+1;
            int k=n-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum > 0)k--;
                else if(sum < 0)j++;
                else{
                    List<Integer> curr=new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    ans.add(curr);
                    j++;
                    k--;
                    // make sure that this same elements are not taken another time
                    while( j < k && nums[j] == nums[j-1])j++;
                    while(j < k && nums[k] == nums[k+1])k--;
                }
            }
        }
        return ans;
    }
}