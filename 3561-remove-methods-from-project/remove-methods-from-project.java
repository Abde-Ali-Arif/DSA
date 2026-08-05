class Solution {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : invocations)
            adj.get(e[0]).add(e[1]);

        boolean[] suspicious = new boolean[n];

        dfs(k, adj, suspicious);

        // Check whether any outside node invokes a suspicious node
        for (int[] e : invocations) {

            int u = e[0];
            int v = e[1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i])
                ans.add(i);
        }

        return ans;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                     boolean[] suspicious) {

        suspicious[node] = true;

        for (int nxt : adj.get(node)) {
            if (!suspicious[nxt])
                dfs(nxt, adj, suspicious);
        }
    }
}