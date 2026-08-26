class Solution {
    void selectionSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            int minIndx=i;
            for(int j=i+1;j<n;j++){
                if(arr[minIndx] > arr[j])minIndx=j;
            }
            swap(arr,minIndx,i);
        }
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}