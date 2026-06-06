class Solution {
    
    // recursion memoization and tabulation is same as 
    // https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
    
    // Space optimization
    public int countPartitions(int[] arr, int diff) {
        int n=arr.length;
        
        int totalSum = 0;
        for(int it:arr)totalSum += it;
        if((totalSum-diff) % 2 == 1 || (totalSum - diff) < 0)return 0;
        
        int target =(totalSum-diff)/2;
        int[] prev= new int[target+1];
        
        // asign all base cases
        if(target >= arr[0]) prev[arr[0]]=1;
        if(arr[0] == 0) prev[0]=2;
        else prev[0]=1;
        
        for(int ind=1;ind<n;ind++){
            int[] curr= new int[target+1];
            for(int sum = 0 ;sum<=target;sum++){
                int notpick=prev[sum];
                int pick=0;
                if(sum >= arr[ind])pick = prev[sum-arr[ind]];
                curr[sum] = notpick + pick;
            }
            prev = curr;
        }
        return prev[target];
    }
}
