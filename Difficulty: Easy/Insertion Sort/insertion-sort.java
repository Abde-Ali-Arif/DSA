class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        int n=arr.length;
        
        for(int i=1;i<n;i++){
            int key= arr[i];
            int j=i-1;
            
            // move all elements to the right till you find the element which is less than key
            while(j >= 0 && arr[j] > key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}