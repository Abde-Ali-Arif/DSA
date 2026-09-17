class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> ans=new HashSet<>();
        List<Integer> curr=new ArrayList<>();
        backtrack(0,nums,curr,ans);

        List<List<Integer>> res=new ArrayList<>();
        for(List<Integer> it:ans)res.add(new ArrayList<>(it));
        return res;
    }

    public void backtrack(int ind,int[] nums,List<Integer> curr,HashSet<List<Integer>> ans){
        if(ind == nums.length){
            if(curr.size() >= 2)ans.add(new ArrayList<>(curr));
            return;
        }
        // two choices pick or not pick current num

        backtrack(ind+1,nums,curr,ans);
        // for picking check the non decreasing condition
        if(curr.size() == 0 || curr.getLast() <= nums[ind]){
            curr.add(nums[ind]);
            backtrack(ind+1,nums,curr,ans);
            curr.removeLast();
        }
    }
}