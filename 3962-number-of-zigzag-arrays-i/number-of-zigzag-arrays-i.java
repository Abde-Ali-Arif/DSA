class Solution {

    static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        // arrays ending at value i
        long[] up = new long[m];
        long[] down = new long[m];

        // Base case → length = 2
        for (int x = 0; x < m; x++) {
            up[x] = x;
            down[x] = m - x - 1;
        }

        // Build lengths from 3 → n
        for (int len = 3; len <= n; len++) {

            long[] nextUp = new long[m];
            long[] nextDown = new long[m];

            // Prefix sums
            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefUp[i + 1] =
                        (prefUp[i] + up[i]) % MOD;

                prefDown[i + 1] =
                        (prefDown[i] + down[i]) % MOD;
            }

            for (int x = 0; x < m; x++) {

                // previous smaller
                nextUp[x] = prefDown[x];

                // previous larger
                nextDown[x] =
                        (prefUp[m]
                        - prefUp[x + 1]
                        + MOD) % MOD;
            }

            up = nextUp;
            down = nextDown;
        }

        long answer = 0;

        for (int i = 0; i < m; i++) {
            answer =
                    (answer + up[i] + down[i]) % MOD;
        }

        return (int) answer;
    }
}