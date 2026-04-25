class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    class Data {
        int start;
        int end;
         public Data(int start ,int end){
            this.start=start;
            this.end = end;
        }
    }
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        
        // create a new data structure to hold the start and end time together
        Data[] arr=new Data[n];
        for(int i=0;i < start.length;i++){
            arr[i]=new Data(start[i],end[i]);
        }
        // sort on the basis of meeting end time
        Arrays.sort(arr,(a,b)-> Integer.compare(a.end,b.end));
        
        int cnt=1;
        int free_time=arr[0].end;
        for(int i=0 ;i< n ;i++){
            // check for the room when it was emptied and when new meeting began
            if(arr[i].start > free_time){
                // update the free time of the room
                free_time=arr[i].end;
                cnt++;
            }
        }
        return cnt;
    }
}
