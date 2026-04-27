// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        
        int wt=0;
        int total_wt=0;
        
        for(int i=0;i<bt.length-1;i++){
            wt=wt+bt[i];
            total_wt+=wt;
        }
        return total_wt/bt.length;
    }
}
