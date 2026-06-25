class Solution {
    // public int kthSmallest(int[] arr, int k) {
    //     PriorityQueue<Integer> pq= new PriorityQueue<>();
    //     for(int i=0;i<arr.length;i++){
    //         pq.add(arr[i]);
    //     }
    //     for(int i=1;i<k;i++){
    //         pq.remove();
    //     }
    //     return pq.remove();
    // }
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            
            if(pq.size() > k)pq.remove();
        }
        return pq.remove();
    }
}
