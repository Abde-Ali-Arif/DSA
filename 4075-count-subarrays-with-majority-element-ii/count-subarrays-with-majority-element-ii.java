class Solution {

    class BIT {
        int[] bit;

        BIT(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & (-idx);
            }
        }

        int query(int idx) {
            int sum = 0;

            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & (-idx);
            }

            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] =
                    prefix[i - 1]
                    + (nums[i - 1] == target ? 1 : -1);
        }

        int shift = n + 2;

        BIT bit = new BIT(2 * n + 5);

        long ans = 0;

        bit.update(shift, 1);

        for (int i = 1; i <= n; i++) {

            int idx = prefix[i] + shift;

            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return ans;
    }
}