class Solution {
    class Pair{
        int freq;
        int val;
        Pair(int f,int v){
            freq=f;
            val=v;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Integer.compare(a.freq,b.freq));
        for(int key:mp.keySet()){
            pq.offer(new Pair(mp.get(key),key));
            // remove the least occuring element
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=pq.poll().val;
        }
        return ans;
    }
}