class Solution {
    
    // O(n*k)
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n= nums.length;
    //     int[] ans = new int[n+1-k];
    //     int ind=0;

    //     for(int i=0;i<n-k+1;i++){
    //         int max=Integer.MIN_VALUE;
    //         for(int j =i;j<k+i;j++){
    //             max=Math.max(max,nums[j]);
    //         }
    //         ans[ind++]=max;
    //     }
    //     return ans;
    // }

    // O(2n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        Deque<Integer> dq= new LinkedList<>();
        int[] ans = new int[n+1-k];
        int ind=0;

        for(int i=0;i<n;i++){

            if(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.removeFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            
            dq.offerLast(i);
            if(i >= k-1) ans[ind++]=nums[dq.peekFirst()];
        }
        return ans;
    }
}