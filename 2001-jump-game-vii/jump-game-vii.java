class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] vis = new boolean[n];
        vis[0] = true;

        int farthest = 0;

        while (!q.isEmpty()) {

            int idx = q.poll();

            if (idx == n - 1) return true;

            int start = Math.max(idx + minJump, farthest + 1);
            int end = Math.min(idx + maxJump, n - 1);

            for (int j = start; j <= end; j++) {

                if (s.charAt(j) == '0' && !vis[j]) {
                    vis[j] = true;
                    q.offer(j);
                }
            }

            farthest = end;
        }

        return false;
    }
}