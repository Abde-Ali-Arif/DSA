class Solution {
    
    // O(n^2)
    // public long subarrayXor(int arr[], int k) {
    //     int n= arr.length;
    //     int cnt=0;
    //     for(int i=0;i<n;i++){
    //         int xor=0;
    //         for(int j=i;j<n;j++){
    //             xor ^=arr[j];
    //             if(xor == k)cnt++;
    //         }
    //     }
    //     return cnt;
    // }
    
    // O(n) prefix xor
    public long subarrayXor(int arr[], int k) {
        int n= arr.length;
        int cnt=0,xor=0;
        HashMap<Integer,Integer> mp= new HashMap<>();
        mp.put(0,1);
        
        for(int i=0;i<n;i++){
            xor ^=arr[i];
            int x=xor^k;
            if(mp.containsKey(x))cnt += mp.get(x);
            mp.put(xor,mp.getOrDefault(xor,0)+1);
        }
        return cnt;
    }
}