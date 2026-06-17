class Solution {
    public char processStr(String s, long k) {

        long len = 0;

        // Compute final length
        for (char ch : s.toCharArray()) {

            if (Character.isLetter(ch)) {
                len++;
            }

            else if (ch == '#') {
                len *= 2;
            }

            else if (ch == '*') {
                if (len > 0) len--;
            }

            // '%' → length unchanged
        }

        if (k >= len) return '.';

        // Traverse backward
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {

                if (k == len - 1)
                    return ch;

                len--;
            }

            else if (ch == '#') {

                len /= 2;
                k %= len;
            }

            else if (ch == '%') {

                k = len - 1 - k;
            }

            else if (ch == '*') {

                len++;
            }
        }

        return '.';
    }
}