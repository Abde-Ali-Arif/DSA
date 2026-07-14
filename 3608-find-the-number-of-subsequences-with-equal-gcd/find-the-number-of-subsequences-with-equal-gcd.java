class Solution {

    int MOD = 1000000007;
    int[][][] memo;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        memo = new int[n + 1][201][201];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= 200; j++)
                Arrays.fill(memo[i][j], -1);

        return dfs(0, 0, 0, nums);
    }

    int dfs(int idx, int g1, int g2, int[] nums) {

        if (idx == nums.length) {
            return (g1 != 0 && g1 == g2) ? 1 : 0;
        }

        if (memo[idx][g1][g2] != -1)
            return memo[idx][g1][g2];

        long ans = 0;

        // Skip
        ans += dfs(idx + 1, g1, g2, nums);

        // Put in seq1
        int ng1 = (g1 == 0) ? nums[idx] : gcd(g1, nums[idx]);
        ans += dfs(idx + 1, ng1, g2, nums);

        // Put in seq2
        int ng2 = (g2 == 0) ? nums[idx] : gcd(g2, nums[idx]);
        ans += dfs(idx + 1, g1, ng2, nums);

        return memo[idx][g1][g2] = (int) (ans % MOD);
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}