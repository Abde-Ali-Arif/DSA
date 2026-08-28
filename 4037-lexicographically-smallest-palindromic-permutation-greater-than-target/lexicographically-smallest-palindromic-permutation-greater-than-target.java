class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int half = n / 2;

        // Count characters
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check whether a palindrome is possible
        int oddCount = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                middle = i;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        // Characters available for the first half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        /*
         * Try to construct a first half equal to
         * target's first half.
         */
        int[] cnt = halfFreq.clone();

        StringBuilder halfString = new StringBuilder();

        boolean possible = true;

        for (int i = 0; i < half; i++) {

            int c = target.charAt(i) - 'a';

            if (cnt[c] == 0) {
                possible = false;
                break;
            }

            cnt[c]--;
            halfString.append((char) ('a' + c));
        }

        /*
         * If we can match the target's first half,
         * build the complete palindrome and directly compare.
         *
         * This handles cases like:
         *
         * s = "bb"
         * target = "ba"
         *
         * half = "b"
         * palindrome = "bb"
         *
         * "bb" > "ba"
         */
        if (possible) {

            String candidate = buildPalindrome(
                halfString,
                middle
            );

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * The exact matching palindrome was either impossible
         * or not greater than target.
         *
         * Now find the RIGHTMOST position where we can
         * increase the first half.
         */
        for (int change = half - 1; change >= 0; change--) {

            int[] remaining = halfFreq.clone();

            StringBuilder left = new StringBuilder();

            // Match target before `change`
            boolean ok = true;

            for (int i = 0; i < change; i++) {

                int c = target.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    ok = false;
                    break;
                }

                remaining[c]--;
                left.append((char) ('a' + c));
            }

            if (!ok) {
                continue;
            }

            /*
             * Choose the smallest character strictly greater
             * than target[change].
             */
            int targetChar = target.charAt(change) - 'a';

            int bigger = -1;

            for (int c = targetChar + 1; c < 26; c++) {

                if (remaining[c] > 0) {
                    bigger = c;
                    break;
                }
            }

            if (bigger == -1) {
                continue;
            }

            left.append((char) ('a' + bigger));
            remaining[bigger]--;

            /*
             * Fill remaining half with smallest characters.
             */
            for (int c = 0; c < 26; c++) {
                while (remaining[c] > 0) {
                    left.append((char) ('a' + c));
                    remaining[c]--;
                }
            }

            /*
             * Since left[change] > target[change],
             * the complete palindrome is guaranteed to be
             * greater than target.
             */
            return buildPalindrome(left, middle);
        }

        return "";
    }

    private String buildPalindrome(
        StringBuilder left,
        int middle
    ) {

        StringBuilder ans = new StringBuilder();

        // Left half
        ans.append(left);

        // Middle for odd length
        if (middle != -1) {
            ans.append((char) ('a' + middle));
        }

        // Right half = reverse(left)
        for (int i = left.length() - 1; i >= 0; i--) {
            ans.append(left.charAt(i));
        }

        return ans.toString();
    }
}