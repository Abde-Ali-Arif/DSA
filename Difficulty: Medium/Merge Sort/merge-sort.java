class Solution {
    public void mergeSort(int arr[], int l, int r) {
        if(l == r)return;
        int mid = l+(r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    private void merge(int arr[], int l,int mid, int r){
        int[] newArr= new int[r-l+1];
        
        int ind=0;
        int i=l;
        int j=mid+1;
        while(i <= mid && j <= r){
            if(arr[i] < arr[j]){
                newArr[ind]=arr[i];
                ind++;
                i++;
            }else{
                newArr[ind]=arr[j];
                ind++;
                j++;
            }
        }
        
        // copy remaining elements
        while(i <= mid){
            newArr[ind]=arr[i];
            i++;
            ind++;
        }
        while(j <= r){
            newArr[ind]=arr[j];
            j++;
            ind++;
        }
        ind=0;
        for(i=l;i<=r;i++){
            arr[i]=newArr[ind];
            ind++;
        }
    }
    
}