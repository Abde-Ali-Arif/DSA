class Solution {
    // public long maxTotalValue(int[] nums, int k) {
    //     int n = nums.length;

    //     PriorityQueue<Long> pq = new PriorityQueue<>();

    //     for(int l=0;l<n;l++){
    //         int mn = nums[l];
    //         int mx = nums[l];

    //         for(int r=l;r<n;r++){
    //             mn = Math.min(mn, nums[r]);
    //             mx = Math.max(mx, nums[r]);

    //             long val = mx - mn;

    //             if(pq.size() < k){
    //                 pq.offer(val);
    //             }
    //             else if(val > pq.peek()){
    //                 pq.poll();
    //                 pq.offer(val);
    //             }
    //         }
    //     }

    //     long ans = 0;

    //     while(!pq.isEmpty()){
    //         ans += pq.poll();
    //     }

    //     return ans;
    // }

    static class Node {
        long value;
        int l, r;

        Node(long value, int l, int r) {
            this.value = value;
            this.l = l;
            this.r = r;
        }
    }

    int[][] mx;
    int[][] mn;
    int[] lg;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        build(nums);

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> Long.compare(b.value, a.value));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(getValue(l, n - 1), l, n - 1));
        }

        long ans = 0;

        while (k-- > 0 && !pq.isEmpty()) {
            Node cur = pq.poll();

            ans += cur.value;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;

                pq.offer(
                    new Node(
                        getValue(cur.l, nr),
                        cur.l,
                        nr
                    )
                );
            }
        }

        return ans;
    }

    private long getValue(int l, int r) {
        return (long) queryMax(l, r) - queryMin(l, r);
    }

    private void build(int[] nums) {
        int n = nums.length;

        lg = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int K = lg[n] + 1;

        mx = new int[K][n];
        mn = new int[K][n];

        for (int i = 0; i < n; i++) {
            mx[0][i] = nums[i];
            mn[0][i] = nums[i];
        }

        for (int k = 1; k < K; k++) {
            for (int i = 0; i + (1 << k) <= n; i++) {

                mx[k][i] = Math.max(
                    mx[k - 1][i],
                    mx[k - 1][i + (1 << (k - 1))]
                );

                mn[k][i] = Math.min(
                    mn[k - 1][i],
                    mn[k - 1][i + (1 << (k - 1))]
                );
            }
        }
    }

    private int queryMax(int l, int r) {
        int k = lg[r - l + 1];

        return Math.max(
            mx[k][l],
            mx[k][r - (1 << k) + 1]
        );
    }

    private int queryMin(int l, int r) {
        int k = lg[r - l + 1];

        return Math.min(
            mn[k][l],
            mn[k][r - (1 << k) + 1]
        );
    }
}