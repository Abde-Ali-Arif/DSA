class Solution {

    // Not understood
    static class Pair {
        long count;
        long waviness;

        Pair(long c, long w) {
            count = c;
            waviness = w;
        }
    }

    String s;
    Pair[][][][][] memo;
    boolean[][][][][] vis;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x <= 0) return 0;

        s = String.valueOf(x);

        int n = s.length();

        memo = new Pair[n + 1][2][2][11][11];
        vis = new boolean[n + 1][2][2][11][11];

        return dfs(0, 1, 0, 10, 10).waviness;
    }

    private Pair dfs(int pos,
                     int tight,
                     int started,
                     int prevPrev,
                     int prev) {

        if (pos == s.length()) {
            return new Pair(1, 0);
        }

        if (vis[pos][tight][started][prevPrev][prev]) {
            return memo[pos][tight][started][prevPrev][prev];
        }

        vis[pos][tight][started][prevPrev][prev] = true;

        long totalCount = 0;
        long totalWaviness = 0;

        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;

        for (int digit = 0; digit <= limit; digit++) {

            int nextTight =
                (tight == 1 && digit == limit) ? 1 : 0;

            if (started == 0 && digit == 0) {

                Pair child =
                    dfs(pos + 1, nextTight, 0, 10, 10);

                totalCount += child.count;
                totalWaviness += child.waviness;
            } else {

                int add = 0;

                if (started == 1 && prevPrev != 10) {

                    boolean peak =
                        prev > prevPrev && prev > digit;

                    boolean valley =
                        prev < prevPrev && prev < digit;

                    if (peak || valley) add = 1;
                }

                int newPrevPrev;
                int newPrev;

                if (started == 0) {
                    newPrevPrev = 10;
                    newPrev = digit;
                } else {
                    newPrevPrev = prev;
                    newPrev = digit;
                }

                Pair child =
                    dfs(pos + 1,
                        nextTight,
                        1,
                        newPrevPrev,
                        newPrev);

                totalCount += child.count;

                totalWaviness +=
                    child.waviness + add * child.count;
            }
        }

        return memo[pos][tight][started][prevPrev][prev] =
            new Pair(totalCount, totalWaviness);
    }
}