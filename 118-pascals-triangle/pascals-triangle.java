class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> ans = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j == i)ans.add(1);
                else{
                    int left=res.get(i-1).get(j-1);
                    int right=res.get(i-1).get(j);
                    ans.add(left+right);
                }
            }
            res.add(ans);
        }
        return res;
    }
}