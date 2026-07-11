class Solution {

    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i])continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            vis[i] = true;

            int vertices = 0;
            int degreeSum = 0;
            while (!q.isEmpty()) {
                int node = q.poll();
                vertices++;
                degreeSum += adj.get(node).size();
                for (int nei : adj.get(node)) {
                    if (!vis[nei]) {
                        vis[nei] = true;
                        q.offer(nei);
                    }
                }
            }

            int edgesInComponent = degreeSum / 2;

            if (edgesInComponent == vertices*(vertices - 1)/2)ans++;
        }
        return ans;
    }
}