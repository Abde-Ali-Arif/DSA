import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration));

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration));

        return (int) ans;
    }

    private long solve(int[] firstStart, int[] firstDur,
                       int[] secondStart, int[] secondDur) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];

        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[m];
        long[] prefMinDur = new long[m];
        long[] suffMinFinish = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefMinDur[0] = rides[0][1];

        for (int i = 1; i < m; i++) {
            prefMinDur[i] =
                Math.min(prefMinDur[i - 1], rides[i][1]);
        }

        suffMinFinish[m - 1] =
            (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffMinFinish[i] =
                Math.min(
                    suffMinFinish[i + 1],
                    (long) rides[i][0] + rides[i][1]
                );
        }

        long res = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long finishFirst =
                (long) firstStart[i] + firstDur[i];

            int idx = upperBound(starts, finishFirst) - 1;

            if (idx >= 0) {
                res = Math.min(
                    res,
                    finishFirst + prefMinDur[idx]
                );
            }

            if (idx + 1 < m) {
                res = Math.min(
                    res,
                    suffMinFinish[idx + 1]
                );
            }
        }

        return res;
    }

    private int upperBound(int[] arr, long target) {

        int l = 0;
        int r = arr.length;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}