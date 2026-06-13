class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans= new StringBuilder();
        for(String st:words){
            int total=0;
            for(int i =0;i<st.length();i++){
                char ch=st.charAt(i);
                int ind= ch -'a';
                total +=weights[ind];
            }
            total = total%26;
            ans.append(""+(char)('z'-total));
        }
        return ans.toString();
    }
}