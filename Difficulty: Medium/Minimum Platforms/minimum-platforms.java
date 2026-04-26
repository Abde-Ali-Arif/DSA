class Solution {
    
    class Data {
        int time;
        int type;
        public Data(int time,int type){
            this.time =time;
            this.type=type;
        }
    }
    
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Data[] cus= new Data[arr.length+dep.length];
        for(int i=0;i<arr.length;i++){
            // 0 means arriving and 1 means departing
            cus[i]=new Data(arr[i],0);
            cus[2*n-i-1]=new Data(dep[i],1);
        }
        int cnt=0, max=0;
        Arrays.sort(cus,(a, b) -> {if(a.time == b.time) return a.type - b.type;return a.time - b.time;});
        for(int i=0;i< cus.length;i++){
            if(cus[i].type == 0){
                cnt++;
                max=Math.max(max,cnt);
            }else{
                cnt--;
            }
        }
        return max;
    }
    
    // public int minPlatform(int arr[], int dep[]) {
    //     Arrays.sort(arr);
    //     Arrays.sort(dep);
        
    //     int s=0,e=0;
    //     int max_platform=0;
    //     int cnt=0;
        
    //     while(s < arr.length){
    //         if(arr[s] < dep[e]){
    //             // train arriving
    //             cnt++;
    //             max_platform=Math.max(max_platform,cnt);
    //             s++;
    //         }else if(dep[e] < arr[s]){
    //             // train leaving
    //             cnt--;
    //             e++;
    //         }else{
    //             // train arriving also and departing also
    //             cnt++;
    //             max_platform=Math.max(max_platform,cnt);
    //             cnt--;
    //             s++;
    //             e++;
    //         }
    //     }
    //     return max_platform;
    // }
}
