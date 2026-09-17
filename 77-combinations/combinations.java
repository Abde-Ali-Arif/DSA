class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        backtrack(1,n,k,curr,ans);
        return ans;
    }

    public void backtrack(int num,int n,int k,List<Integer> curr,List<List<Integer>> ans){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(num > n || curr.size() > k)return;

        // two choices pick or not pick current num

        backtrack(num+1,n,k,curr,ans);
        curr.add(num);
        backtrack(num+1,n,k,curr,ans);
        curr.removeLast();

    }
}