class Solution {
    int MOD = 1000000007;
    int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        dfs(1, -1, 0, graph);

        return power(2, maxDepth - 1);
    }

    public void dfs(int node, int parent, int depth, List<Integer>[] graph) {

        maxDepth = Math.max(maxDepth, depth);

        for (int next : graph[node]) {
            if (next != parent) {
                dfs(next, node, depth + 1, graph);
            }
        }
    }

    public int power(long base, int exp) {
        long ans = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return (int) ans;
    }
}