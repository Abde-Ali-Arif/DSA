class Solution {
    // O(n^2)
    // public int findMaxLength(int[] nums) {
    //     int n=0;
    //     int len=0;
    //     for(int i=0;i<nums.length;i++){
    //         int cnt0=0;
    //         int cnt1=0;
    //         for(int j=i;j<nums.length;j++){
    //             if(nums[j] == 0)cnt0++;
    //             else cnt1++;
    //             if(j-i+1 > len && cnt0 == cnt1)len=j-i+1;
    //         }
    //     }
    //     return len;
    // }


    public int findMaxLength(int[] nums) {
        int n=0;
        int len=0;
        HashMap<Integer,Integer> hash= new HashMap<>();
        hash.put(0,-1);
        int runningSum=0;    // interpret 0 -> -1 and 1 -> +1 
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)runningSum--;
            else runningSum++;
            // subarray which has sum as zero is found
            if(hash.containsKey(runningSum)){
                int prevInd=hash.get(runningSum);
                len=Math.max(len,i-prevInd);
            }else{
                hash.put(runningSum,i);
            }    
        }
        return len;
    }
}