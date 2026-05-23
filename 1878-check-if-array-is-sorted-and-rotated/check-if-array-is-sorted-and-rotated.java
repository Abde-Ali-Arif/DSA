class Solution {
    public boolean check(int[] nums) {
        int index=0;
        for ( int i = 0 ; i <  nums.length-1 ; i++){
            if(nums[i] > nums[i+1] && i < nums.length-1){
                index = i+1;
                break;
            }
        }
        int i = index;
        System.out.println(index);
        int size = nums.length-1;
        while(size != 0){
            if( i < nums.length-1){
                if(nums[i] > nums[i+1]){
                    System.out.println("returning in iteration "+i+ "\t"+size);
                return false;
                }
            }
            if(i == nums.length-1){
                if(nums[i] > nums[0]){
                    System.out.println("returning from in iteration "+i+ "\t"+size);
                return false;
                }
                i=0;
                break;
            }
            i++;
            size--;
            
        }
        return true;
    }
}