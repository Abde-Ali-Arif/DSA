class Solution {

    // Gives TLE
    // public String smallestNumber(String num, long t) {
    //     long n=Long.valueOf(num);
    //     while(n < Long.MAX_VALUE){
    //         long number=n;
    //         long multiply=1;
    //         while(number > 0){
    //             if(number%10 == 0)break;
    //             multiply *= number%10;
    //             number=number/10;
    //         }
    //         if(multiply % t == 0) return n+"";
    //         n++;
    //     }
    //     return "-1";
    // }


    // factors[d][0] = count of factor 2
    // factors[d][1] = count of factor 3
    // factors[d][2] = count of factor 5
    // factors[d][3] = count of factor 7

    private final int[][] factors = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {

        // Required powers of 2,3,5,7 in t
        int[] need = new int[4];

        int[] primes = {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                t /= primes[i];
                need[i]++;
            }
        }

        // t still has another prime factor
        if (t != 1) {
            return "-1";
        }

        int n = num.length();

        /*
         * First find the minimum number of digits required
         * to represent the prime factors of t.
         */
        int[] factorDigits = getMinimumDigits(need);
        int requiredLength = countDigits(factorDigits);

        /*
         * If even the minimum required number of digits is
         * greater than num.length(), we need a longer number.
         */
        if (requiredLength > n) {
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < n + 1 - requiredLength; i++) {
                ans.append('1');
            }

            appendDigits(ans, factorDigits);

            return ans.toString();
        }

        /*
         * Calculate prime factors present in the whole num.
         */
        int[] totalFactors = new int[4];

        int firstZero = n;

        for (int i = 0; i < n; i++) {

            int d = num.charAt(i) - '0';

            if (d == 0 && firstZero == n) {
                firstZero = i;
            }

            for (int j = 0; j < 4; j++) {
                totalFactors[j] += factors[d][j];
            }
        }

        /*
         * If num itself is zero-free and already divisible
         * by t, it is the smallest possible answer.
         */
        if (firstZero == n && containsAll(totalFactors, need)) {
            return num;
        }

        /*
         * prefixFactors represents the factors contributed
         * by the part before the current position.
         *
         * We move from right to left and try to increase
         * the current digit.
         */
        int[] prefixFactors = totalFactors.clone();

        for (int i = n - 1; i >= 0; i--) {

            int currentDigit = num.charAt(i) - '0';

            // Remove current digit from prefix
            for (int j = 0; j < 4; j++) {
                prefixFactors[j] -= factors[currentDigit][j];
            }

            /*
             * Positions after i.
             */
            int remainingPositions = n - 1 - i;

            /*
             * If i is after the first zero, then keeping the
             * prefix unchanged would already contain a zero,
             * so this position cannot be used for a valid
             * answer.
             */
            if (i > firstZero) {
                continue;
            }

            /*
             * Try making current digit just slightly larger.
             *
             * This gives the smallest number greater than num
             * while preserving the longest possible prefix.
             */
            for (int bigger = currentDigit + 1; bigger <= 9; bigger++) {

                int[] remainingNeed = new int[4];

                /*
                 * Required factors minus factors already supplied
                 * by prefix.
                 */
                for (int j = 0; j < 4; j++) {
                    remainingNeed[j] =
                        Math.max(0, need[j] - prefixFactors[j]);
                }

                /*
                 * The new digit contributes some factors.
                 */
                for (int j = 0; j < 4; j++) {
                    remainingNeed[j] =
                        Math.max(0, remainingNeed[j] - factors[bigger][j]);
                }

                /*
                 * Find the minimum number of digits needed
                 * to satisfy the remaining factors.
                 */
                int[] required = getMinimumDigits(remainingNeed);

                int requiredCount = countDigits(required);

                /*
                 * Can the remaining positions contain all
                 * required factors?
                 */
                if (requiredCount <= remainingPositions) {

                    StringBuilder ans = new StringBuilder();

                    // Original prefix
                    ans.append(num, 0, i);

                    // Increased digit
                    ans.append((char) ('0' + bigger));

                    /*
                     * To make the number as small as possible,
                     * put 1's before the required digits.
                     */
                    for (int x = 0;
                         x < remainingPositions - requiredCount;
                         x++) {
                        ans.append('1');
                    }

                    // Required digits in increasing order
                    appendDigits(ans, required);

                    return ans.toString();
                }
            }
        }

        /*
         * No answer of the same length exists.
         *
         * Therefore construct the smallest valid number
         * with n+1 digits.
         */
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n + 1 - requiredLength; i++) {
            ans.append('1');
        }

        appendDigits(ans, factorDigits);

        return ans.toString();
    }

    /*
     * Converts required prime factors into the minimum
     * number of digits.
     *
     * We prefer:
     *
     * 8 = 2^3
     * 9 = 3^2
     * 4 = 2^2
     * 6 = 2 * 3
     * 5 = 5
     * 7 = 7
     */
    private int[] getMinimumDigits(int[] need) {

        int a = need[0]; // factor 2
        int b = need[1]; // factor 3
        int c = need[2]; // factor 5
        int d = need[3]; // factor 7

        int[] result = new int[10];

        // Use as many 8's as possible
        result[8] = a / 3;
        a %= 3;

        // Use as many 9's as possible
        result[9] = b / 2;
        b %= 2;

        /*
         * Remaining powers of 2.
         */
        result[4] = a / 2;
        a %= 2;

        /*
         * If one 2 and one 3 remain,
         * combine them into 6.
         */
        if (a == 1 && b == 1) {
            result[6] = 1;
            a = 0;
            b = 0;
        }

        /*
         * If one 4 and one 3 remain, use
         * 6 + 2 instead.
         */
        if (result[4] == 1 && b == 1) {
            result[4] = 0;
            result[6]++;
            result[2]++;
            b = 0;
            a = 0;
        }

        if (a == 1) {
            result[2]++;
        }

        if (b == 1) {
            result[3]++;
        }

        result[5] = c;
        result[7] = d;

        return result;
    }

    private int countDigits(int[] count) {

        int total = 0;

        for (int i = 2; i <= 9; i++) {
            total += count[i];
        }

        return total;
    }

    private void appendDigits(StringBuilder sb, int[] count) {

        /*
         * Digits must be in increasing order to make
         * the suffix lexicographically smallest.
         */
        for (int digit = 2; digit <= 9; digit++) {

            for (int i = 0; i < count[digit]; i++) {
                sb.append((char) ('0' + digit));
            }
        }
    }

    private boolean containsAll(int[] have, int[] need) {

        for (int i = 0; i < 4; i++) {
            if (have[i] < need[i]) {
                return false;
            }
        }

        return true;
    }
}