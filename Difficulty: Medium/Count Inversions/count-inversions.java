class Solution {
    // public int inversionCount(int arr[]) {
    //     int cnt=0;
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=i+1;j<arr.length;j++){
    //             if(arr[i] > arr[j])cnt++;
    //         }
    //     }
    //     return cnt;
    // }
    
    
    // Optimal
    int cnt=0;
    public int inversionCount(int arr[]) {
        mergeSort(arr,0,arr.length-1);
        return cnt;
    }
    
    public void merge(int[] arr, int low, int mid, int high) {
        // Create temp array
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        // Merge both sorted parts
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp.add(arr[left++]);
            else{
                temp.add(arr[right++]);
                cnt += mid-left+1;
            }
        }

        // Add remaining left elements
        while (left <= mid)
            temp.add(arr[left++]);

        // Add remaining right elements
        while (right <= high)
            temp.add(arr[right++]);

        // Copy back to original array
        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low);
    }

    // Recursive merge sort
    public void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        // Find mid index
        int mid = (low + high) / 2;

        // Sort left half
        mergeSort(arr, low, mid);

        // Sort right half
        mergeSort(arr, mid + 1, high);

        // Merge both halves
        merge(arr, low, mid, high);
    }

}