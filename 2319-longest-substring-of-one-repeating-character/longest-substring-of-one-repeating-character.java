class Solution {

    class Node {
        int leftChar;
        int rightChar;

        int prefix;
        int suffix;
        int best;
        int len;

        Node() {
        }

        Node(char c) {
            leftChar = rightChar = c;
            prefix = suffix = best = len = 1;
        }
    }

    Node[] tree;
    char[] s;

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(s[start]);
            return;
        }

        int mid = start + (end - start) / 2;

        build(2 * node + 1, start, mid);
        build(2 * node + 2, mid + 1, end);

        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
    }

    private Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node res = new Node();

        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.prefix = a.prefix;
        res.suffix = b.suffix;

        res.best = Math.max(a.best, b.best);

        // Boundary characters are equal,
        // so suffix of left + prefix of right can be joined.
        if (a.rightChar == b.leftChar) {

            res.best = Math.max(
                res.best,
                a.suffix + b.prefix
            );

            // Entire left segment has the same character
            if (a.prefix == a.len) {
                res.prefix = a.len + b.prefix;
            }

            // Entire right segment has the same character
            if (b.suffix == b.len) {
                res.suffix = b.len + a.suffix;
            }
        }

        return res;
    }

    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree[node] = new Node(c);
            return;
        }

        int mid = start + (end - start) / 2;

        if (idx <= mid) {
            update(2 * node + 1, start, mid, idx, c);
        } else {
            update(2 * node + 2, mid + 1, end, idx, c);
        }

        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public int[] longestRepeating(
        String str,
        String queryCharacters,
        int[] queryIndices
    ) {
        s = str.toCharArray();

        int n = s.length;

        tree = new Node[4 * n];

        build(0, 0, n - 1);

        int q = queryIndices.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {

            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);

            s[index] = c;

            update(0, 0, n - 1, index, c);

            ans[i] = tree[0].best;
        }

        return ans;
    }
}