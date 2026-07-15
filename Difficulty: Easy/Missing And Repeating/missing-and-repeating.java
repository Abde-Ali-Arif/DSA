class Solution {
    // O(n^2)
    // ArrayList<Integer> findTwoElement(int arr[]) {
    //     int n=arr.length;
    //     int repeating=-1;
    //     int missing =-1;
    //     for(int i=1;i<=n;i++){
    //         int cnt=0;
    //         for(int j=0;j<n;j++){
    //             if(arr[j] == i)cnt++;
    //         }
    //         if(cnt == 2)repeating=i;
    //         if(cnt == 0)missing=i;
    //         if(repeating != -1 && missing != -1)break;
    //     }
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     ans.add(repeating);
    //     ans.add(missing);
    //     return ans;
    // }
    
    // O(n)
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n=arr.length;
        long sn=((long)n*(n+1))/2;
        long s2n=((long)n*(n+1)*(2*n+1))/6;
        
        long s=0;
        long s2=0;
        
        for(int i=0;i<n;i++){
            s += arr[i];
            s2 += (long)arr[i]*arr[i];
        }
        
        long val1 =s-sn; // x - y
        long val2= (s2 - s2n)/val1;  // x + y
        
        long x=(val1 + val2)/2;
        long y=x-val1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int)x);
        ans.add((int)y);
        return ans;
    }
}
