class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        int m = restrictions.length;

        int[][] arr = new int[m + 1][2];

        arr[0][0] = 1;
        arr[0][1] = 0;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = restrictions[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // Left → Right
        for (int i = 1; i <= m; i++) {
            int dist = arr[i][0] - arr[i - 1][0];

            arr[i][1] =Math.min(arr[i][1],arr[i - 1][1] + dist);
        }

        // Right → Left
        for (int i = m - 1; i >= 0; i--) {

            int dist =
                arr[i + 1][0] - arr[i][0];

            arr[i][1] =Math.min(arr[i][1],arr[i + 1][1] + dist);
        }

        int ans = 0;

        for (int i = 1; i <= m; i++) {

            int left = arr[i - 1][1];
            int right = arr[i][1];

            int dist =
                arr[i][0] - arr[i - 1][0];

            ans = Math.max(ans,(left + right + dist) / 2);
        }

        // Extend after last restriction
        ans = Math.max(ans,arr[m][1] + (n - arr[m][0]));

        return ans;
    }
}