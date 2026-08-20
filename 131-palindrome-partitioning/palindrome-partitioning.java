class Solution {
    public List<List<String>> partition(String s) {
        int n=s.length();
        List<List<String>> ans= new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(s,0,n,res,ans);
        return ans;
    }

    private void helper(String s,int ind ,int n ,List<String> res ,List<List<String>> ans){
        if(ind == n){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=ind;i<n;i++){
            if(isPartition(s,ind,i)){
                res.add(s.substring(ind,i+1));
                helper(s,i+1,n,res,ans);
                res.removeLast();
            }
        }
    }
    private boolean isPartition(String s,int ind ,int n){
        while(ind < n){
            if(s.charAt(ind) != s.charAt(n))return false;
            ind++;n--;
        }
        return true;
    }
}