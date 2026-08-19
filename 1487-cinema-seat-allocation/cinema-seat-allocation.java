class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store reserved seats for only the rows that have reservations.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initially every row can accommodate 2 groups.
        int ans = 2 * n;

        // Build a bitmask for each affected row.
        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int col = seat[1];

            // Seat 1 -> bit 0
            // Seat 10 -> bit 9
            int mask = map.getOrDefault(row, 0);

            mask |= (1 << (col - 1));

            map.put(row, mask);
        }

        // Each affected row was initially counted as 2 groups.
        // Now calculate its actual maximum.
        for (int mask : map.values()) {

            // Remove the initial 2 groups for this row.
            ans -= 2;

            // Check seats 2,3,4,5
            boolean left = (mask & (0b0000011110)) == 0;

            // Check seats 6,7,8,9
            boolean right = (mask & (0b0111100000)) == 0;

            if (left && right) {
                // Both sides can accommodate a group.
                ans += 2;
            }
            else if (left || right) {
                // One side can accommodate a group.
                ans += 1;
            }
            else {
                // Neither side works.
                // But maybe the middle block 4,5,6,7 works.
                boolean middle = (mask & (0b0001111000)) == 0;

                if (middle) {
                    ans += 1;
                }
            }
        }

        return ans;
    }
}