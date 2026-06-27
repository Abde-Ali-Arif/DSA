class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long)x,
                    freq.getOrDefault((long)x, 0) + 1);
        }

        int ans = 1;

        // Special handling for 1
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);

            if (cnt % 2 == 0)
                cnt--;

            ans = Math.max(ans, cnt);
        }

        for (long x : freq.keySet()) {

            if (x == 1) continue;

            long curr = x;

            int len = 1; // center

            while (
                freq.getOrDefault(curr, 0) >= 2
                && freq.containsKey(curr * curr)
            ) {
                len += 2;
                curr = curr * curr;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}