class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        int n= arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] hash= new int[n];
        int maxi=1,lastind=0;
        
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(arr[prev] < arr[i] && 1+dp[prev] > dp[i]){
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(dp[i] > maxi){
                maxi=dp[i];
                lastind=i;
            }
        }
        ArrayList<Integer> ans= new ArrayList<>();
        while(hash[lastind] != lastind){
            ans.add(arr[lastind]);
            lastind=hash[lastind];
        }
        ans.add(arr[lastind]);
        Collections.reverse(ans);
        return ans;
    }
}
