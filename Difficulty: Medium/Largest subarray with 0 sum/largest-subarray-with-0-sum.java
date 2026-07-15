class Solution {
    // O(n^2)
    // int maxLength(int arr[]) {
    //     int n= arr.length;
    //     int ans=0;
    //     for(int i=0;i<n;i++){
    //         int sum=0;
    //         for(int j=i;j<n;j++){
    //             sum +=arr[j];
    //             if(sum == 0)ans=Math.max(ans,j-i+1);
    //         }
    //     }
    //     return ans;
    // }
    
    // O(n) prefix sum
    int maxLength(int arr[]) {
        int n= arr.length;
        int ans=0,sum=0;
        HashMap<Integer,Integer> mp= new HashMap<>();
        
        for(int i=0;i<n;i++){
            sum +=arr[i];
            if(sum == 0)ans=i+1;
            else{
                if(mp.containsKey(sum))ans=Math.max(ans,i-mp.get(sum));
                else mp.put(sum,i);
            }
        }
        return ans;
    }
}