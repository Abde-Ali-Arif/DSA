import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 1. Sort by start point ascending. If equal, sort by end point descending.
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int remainingCount = 0;
        int maxRightEnd = 0;
        
        // 2. Iterate and track the furthest right boundary
        for (int[] interval : intervals) {
            int currentEnd = interval[1];
            
            // If the current end extends past our max right boundary, it's not covered
            if (currentEnd > maxRightEnd) {
                remainingCount++;
                maxRightEnd = currentEnd; // Update the tracking boundary
            }
        }
        
        return remainingCount;
    }
}
