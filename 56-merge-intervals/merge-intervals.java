class Solution {
    public int[][] merge(int[][] intervals) {
        int n =intervals.length , i=0;
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        

        while(i < n){

            // overlapping part
            int[] newInterval={intervals[i][0] , intervals[i][1]};
            i=i+1;
            while(i < n && newInterval[1] >= intervals[i][0] ){
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
                i++;
            }
            res.add(newInterval);
        }


        // Convert List<int[]> → int[][]
        return res.toArray(new int[res.size()][]);
    }
}