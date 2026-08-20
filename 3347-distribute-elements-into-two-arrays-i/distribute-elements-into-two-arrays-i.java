class Solution {
    public int[] resultArray(int[] nums) {
        
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2= new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i=2;i<nums.length;i++){
            if(arr1.getLast() > arr2.getLast()){
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
        }
        int ind=0;
        for(int it:arr1){
            nums[ind]=it;
            ind++;
        }
        for(int it:arr2){
            nums[ind]=it;
            ind++;
        }
        return nums;
    }
}