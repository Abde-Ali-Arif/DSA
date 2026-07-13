class Solution {
    // O(n^4)
    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     int n= nums.length;
    //     HashSet<List<Integer>> set= new HashSet<>();
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             for(int k=j+1;k<n;k++){
    //                 for(int l=k+1;l<n;l++){
    //                     if(nums[i]+nums[j]+nums[k]+nums[l] == target){
    //                         List<Integer> curr= new ArrayList<>();
    //                         curr.add(nums[i]);
    //                         curr.add(nums[j]);
    //                         curr.add(nums[k]);
    //                         curr.add(nums[l]);
    //                         Collections.sort(curr);
    //                         set.add(curr);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans= new ArrayList<>(set);
    //     return ans;
    // }

    // O(n^4)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n= nums.length;
        HashSet<List<Integer>> set= new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                HashSet<Long> prev= new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long fourth= target-nums[i];
                    fourth -= nums[j];
                    fourth -= nums[k];
                    if(prev.contains(fourth)){
                        List<Integer> curr= new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[k]);
                        curr.add((int)fourth);
                        Collections.sort(curr);
                        set.add(curr);
                    }
                    prev.add((long)nums[k]);
                }
            }
        }
        List<List<Integer>> ans= new ArrayList<>(set);
        return ans;
    }
}