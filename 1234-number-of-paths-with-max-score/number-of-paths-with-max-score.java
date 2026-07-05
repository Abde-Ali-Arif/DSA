public class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        // dpMax stores the maximum sum to reach (i, j) from the start 'S'
        int[][] dpMax = new int[n][n];
        // dpCount stores the number of paths to reach (i, j) with the maximum sum
        int[][] dpCount = new int[n][n];

        // Initialize the starting position 'S' at the bottom-right corner
        dpCount[n - 1][n - 1] = 1;

        // Step 1: Traverse the board backwards from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // If it's an obstacle or we haven't reached this cell yet, skip it
                if (board.get(i).charAt(j) == 'X' || dpCount[i][j] == 0) {
                    continue;
                }

                // Three possible directions to move: Up, Left, Up-Left (Diagonal)
                int[][] directions = {{-1, 0}, {0, -1}, {-1, -1}};

                for (int[] dir : directions) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    // Check bounds and ensure the next cell is not an obstacle
                    if (ni >= 0 && nj >= 0 && board.get(ni).charAt(nj) != 'X') {
                        char nextChar = board.get(ni).charAt(nj);
                        int value = (nextChar == 'E') ? 0 : (nextChar - '0');
                        int newSum = dpMax[i][j] + value;

                        // Case A: Found a strictly better maximum path to the next cell
                        if (newSum > dpMax[ni][nj]) {
                            dpMax[ni][nj] = newSum;
                            dpCount[ni][nj] = dpCount[i][j];
                        } 
                        // Case B: Found an alternative path with an identical maximum sum
                        else if (newSum == dpMax[ni][nj]) {
                            dpCount[ni][nj] = (dpCount[ni][nj] + dpCount[i][j]) % MOD;
                        }
                    }
                }
            }
        }
        // Step 2: Extract result from the destination 'E' at top-left (0, 0)
        if (dpCount[0][0] == 0) {
            return new int[]{0, 0};
        }
        return new int[]{dpMax[0][0], dpCount[0][0]};
    }
}
