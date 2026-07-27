class Solution {
    // public int maximumProduct(int[] nums) {
    //     int n= nums.length;
    //     Arrays.sort(nums);

    //     int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        
    //     int option2 = nums[0] * nums[1] * nums[n - 1];
        
    //     return Math.max(option1, option2);
    // }

    public int maximumProduct(int[] nums) {
        int n= nums.length;

        int m1=-1000,m2=-1000,m3=-1000;
        int min1=1000,min2=1000;

        for(int i=0;i<n;i++){
            if(nums[i] > m1){
                m3=m2;
                m2=m1;
                m1=nums[i];
            }else if(nums[i] > m2){
                m3=m2;
                m2=nums[i];
            }else if(nums[i] > m3){
                m3=nums[i];
            }
            if(nums[i] < min1){
                min2=min1;
                min1=nums[i];
            }else if(nums[i] < min2){
                min2 = nums[i];
            }
        }

        int option1 = m1*m2*m3;
        
        int option2 = min1* min2 * m1;
        
        return Math.max(option1, option2);
    }
}