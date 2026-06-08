class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n= nums.length;
        int[] ans= new int[n];
        int ind=0,cnt=0;
        for(int it:nums){
            if(it < pivot){
                ans[ind]=it;
                ind++;
            }else if(it == pivot)cnt++;
        }
        for(int i=0;i<cnt;i++){
            ans[ind]=pivot;
            ind++;
        }
        for(int it:nums){
            if(it > pivot){
                ans[ind]=it;
                ind++;
            }
        }
        return ans;
    }
}