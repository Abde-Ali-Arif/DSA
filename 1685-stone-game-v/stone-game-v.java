class Solution {

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        // prefix[i] = sum of first i elements
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[l][r] = maximum score Alice can get
        // from subarray l...r
        int[][] dp = new int[n][n];

        // Length of the interval
        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len <= n; l++) {

                int r = l + len - 1;

                for (int mid = l; mid < r; mid++) {

                    long leftSum = prefix[mid + 1] - prefix[l];
                    long rightSum = prefix[r + 1] - prefix[mid + 1];

                    if (leftSum < rightSum) {

                        // Bob removes right side
                        dp[l][r] = Math.max(
                            dp[l][r],
                            (int) leftSum + dp[l][mid]
                        );

                    } else if (leftSum > rightSum) {

                        // Bob removes left side
                        dp[l][r] = Math.max(
                            dp[l][r],
                            (int) rightSum + dp[mid + 1][r]
                        );

                    } else {

                        // Alice can choose either side
                        dp[l][r] = Math.max(
                            dp[l][r],
                            Math.max(
                                (int) leftSum + dp[l][mid],
                                (int) rightSum + dp[mid + 1][r]
                            )
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}