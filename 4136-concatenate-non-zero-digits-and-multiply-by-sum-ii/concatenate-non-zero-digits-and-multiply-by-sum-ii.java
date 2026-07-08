class Solution {

    static final long MOD = 1000000007L;

    class Node {
        long value;   // concatenated number modulo MOD
        long sum;     // sum of non-zero digits
        int len;      // count of non-zero digits

        Node() {}

        Node(long value, long sum, int len) {
            this.value = value;
            this.sum = sum;
            this.len = len;
        }
    }

    Node[] tree;
    long[] pow10;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // Precompute powers of 10
        pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        tree = new Node[4 * n];
        build(1, 0, n - 1, s);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            Node res = query(1, 0, n - 1, queries[i][0], queries[i][1]);
            ans[i] = (int)((res.value * res.sum) % MOD);
        }

        return ans;
    }

    private void build(int idx, int l, int r, String s) {

        if (l == r) {

            int digit = s.charAt(l) - '0';

            if (digit == 0) {
                tree[idx] = new Node(0, 0, 0);
            } else {
                tree[idx] = new Node(digit, digit, 1);
            }

            return;
        }

        int mid = (l + r) / 2;

        build(idx * 2, l, mid, s);
        build(idx * 2 + 1, mid + 1, r, s);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    private Node query(int idx, int l, int r, int ql, int qr) {

        if (r < ql || l > qr)
            return new Node(0, 0, 0);

        if (l >= ql && r <= qr)
            return tree[idx];

        int mid = (l + r) / 2;

        Node left = query(idx * 2, l, mid, ql, qr);
        Node right = query(idx * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {

        Node ans = new Node();

        ans.len = left.len + right.len;

        ans.sum = left.sum + right.sum;

        ans.value = (left.value * pow10[right.len]) % MOD;
        ans.value = (ans.value + right.value) % MOD;

        return ans;
    }
}