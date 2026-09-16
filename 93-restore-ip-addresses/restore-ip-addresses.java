import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        // An IP address requires between 4 and 12 digits
        if (s == null || s.length() < 4 || s.length() > 12) {
            return ans;
        }
        
        helper(s, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    /**
     * @param s        The original input string.
     * @param ind      The current index we are exploring in the string.
     * @param segments The count of segments successfully placed so far (0 to 4).
     * @param curr     The current working IP string builder.
     * @param ans      The final list storing all valid IP addresses.
     */
    private void helper(String s, int ind, int segments, StringBuilder curr, List<String> ans) {
        // Base Case: If we have processed the whole string and found exactly 4 segments
        if (ind == s.length() && segments == 4) {
            ans.add(curr.toString());
            return;
        }

        // Optimization: If we already have 4 segments but digits are left, or if we run out of digits
        if (segments >= 4 || ind >= s.length()) {
            return;
        }

        // Try extracting a segment of length 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {
            // Out of bounds check
            if (ind + len > s.length()) {
                break;
            }

            String part = s.substring(ind, ind + len);
            
            // Validate leading zeros: if length > 1, it cannot start with '0'
            if (part.length() > 1 && part.charAt(0) == '0') {
                break; 
            }

            // Validate value range: must be between 0 and 255
            int val = Integer.parseInt(part);
            if (val > 255) {
                break;
            }

            // Backtracking Step
            int originalLen = curr.length();
            if (segments > 0) {
                curr.append(".");
            }
            curr.append(part);

            // Move to the next segment
            helper(s, ind + len, segments + 1, curr, ans);

            // Restore the StringBuilder state (backtrack)
            curr.setLength(originalLen);
        }
    }
}
