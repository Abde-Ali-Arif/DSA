class Solution {
    // //  T.C.-> O(3n)    S.C.->O(2n)
    // public int candy(int[] ratings) {
    //     int n=ratings.length;
    //     int[] left= new int[n];
    //     int[] right= new int[n];

    //     // Initially assign it a value
    //     left[0]=1;
    //     right[n-1]=1;
    //     for(int i=1;i<n;i++){
    //         if(ratings[i] > ratings[i-1]){
    //             left[i]=left[i-1]+1;
    //         }else{
    //             left[i]=1;
    //         }
    //     }
    //     for(int i=n-2;i>=0;i--){
    //         if(ratings[i] > ratings[i+1]){
    //             right[i]=right[i+1]+1;
    //         }else{
    //             right[i]=1;
    //         }
    //     }
    //     int sum=0;
    //     for(int i=0;i<n;i++){
    //         sum +=Math.max(left[i],right[i]);
    //     }
    //     return sum;
    // }

    //  T.C.-> O(n)    S.C.->O(1)
    public int candy(int[] ratings) {
        int n=ratings.length;
        int sum=1;
        int i=1;
        while(i < n){
            if(ratings[i] == ratings[i-1]){
                sum=sum+1;
                i++;
                continue;
            }
            int peak=1;
            while(i < n && ratings[i] > ratings[i-1]){
                peak++;
                sum+=peak;
                i++;
            }
            int down=1;
            while(i < n && ratings[i] < ratings[i-1]){
                sum+=down;
                down++;
                i++;
            }
            if(down>peak)sum+=down-peak;
        }
        return sum;
    }
}