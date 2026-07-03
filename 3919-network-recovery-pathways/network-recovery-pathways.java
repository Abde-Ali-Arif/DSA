class Solution {

    class Edge {
        int to;
        int cost;
        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;
        ArrayList<Edge>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int maxCost = 0;

        for (int[] e : edges) {
            graph[e[0]].add(new Edge(e[1], e[2]));
            indegree[e[1]]++;
            maxCost = Math.max(maxCost, e[2]);
        }

        // Topological order
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (Edge e : graph[node]) {
                indegree[e.to]--;
                if (indegree[e.to] == 0)
                    q.offer(e.to);
            }
        }

        int low = 0;
        int high = maxCost;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, graph, topo, online, k)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }

        return ans;
    }

    boolean check(int limit,
                  ArrayList<Edge>[] graph,
                  ArrayList<Integer> topo,
                  boolean[] online,
                  long k) {

        int n = online.length;

        long INF = Long.MAX_VALUE / 4;

        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (Edge e : graph[u]) {

                int v = e.to;

                if (e.cost < limit)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                dist[v] = Math.min(dist[v], dist[u] + e.cost);
            }
        }

        return dist[n - 1] <= k;
    }
}