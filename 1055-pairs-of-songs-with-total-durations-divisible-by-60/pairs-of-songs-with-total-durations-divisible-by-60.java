class Solution {

    // O(n^2)
    // public int numPairsDivisibleBy60(int[] time) {
    //     int n=time.length;
    //     int cnt=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if((time[i]+time[j])%60 == 0)cnt++;
    //         }
    //     }
    //     return cnt;
    // }

    // O(n)
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainderCounts = new int[60];
        int cnt = 0;
        
        for (int t : time) {
            int curr = t % 60;
            // If curr is 0, target is (60 - 0) % 60 = 0
            // If curr is 20, target is (60 - 20) % 60 = 40
            int target = (60 - curr) % 60;
            
            // Add the number of matching complements found so far
            cnt += remainderCounts[target];
            
            // Record the current remainder
            remainderCounts[curr]++;
        }
        
        return cnt;
    }
}