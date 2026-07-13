class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

       // start sorting from higest number
       int ind=m+n-1;
       int i=m-1;
       int j=n-1;
       while(i >= 0 && j >= 0){
        if(nums1[i] >= nums2[j]){
            nums1[ind]=nums1[i];
            i--;
        }else{
            nums1[ind]=nums2[j];
            j--;
        }
        ind--;
       }

       while(j >= 0){
        nums1[ind]=nums2[j];
        ind--;
        j--;
       } 
    }
}