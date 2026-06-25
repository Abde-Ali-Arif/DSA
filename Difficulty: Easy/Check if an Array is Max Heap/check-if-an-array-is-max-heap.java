class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n= arr.length;
        for(int i=0;i<n;i++){
            if(2*i+1 < n){
                // check for the condition for left child
                if(arr[i] < arr[2*i+1])return false;
            }
            if(2*i+2 < n){
                // check for the condition for right child
                if(arr[i] < arr[2*i+2])return false;
            }
        }
        return true;
    }
}