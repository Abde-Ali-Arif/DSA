import java.math.BigInteger;

class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) cnt[ch - 'a']++;

        char mid = 0;
        boolean hasMid = false;
        int[] half = new int[26];
        for (int c = 0; c < 26; c++) {
            half[c] = cnt[c] / 2;
            if (cnt[c] % 2 == 1) {
                mid = (char) ('a' + c);
                hasMid = true;
            }
        }

        int halfLen = n / 2;
        BigInteger M = arrangements(half);

        long kk = k;
        StringBuilder half1 = new StringBuilder();
        int remaining = halfLen;

        for (int pos = 0; pos < halfLen; pos++) {
            boolean committed = false;
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;
                BigInteger needed = M.multiply(BigInteger.valueOf(half[c]))
                                      .divide(BigInteger.valueOf(remaining));
                if (BigInteger.valueOf(kk).compareTo(needed) <= 0) {
                    half1.append((char) ('a' + c));
                    half[c]--;
                    M = needed;
                    remaining--;
                    committed = true;
                    break;
                } else {
                    kk -= needed.longValueExact(); // safe: needed < kk <= 1e6 here
                }
            }
            if (!committed) return ""; // k exceeds total distinct palindromes
        }

        StringBuilder result = new StringBuilder();
        result.append(half1);
        if (hasMid) result.append(mid);
        half1.reverse();
        result.append(half1);

        return result.toString();
    }

    // Number of distinct arrangements of the given multiset:
    // total! / (count[0]! * count[1]! * ... * count[25]!)
    // Computed by inserting items one at a time (always an exact integer at each step).
    private BigInteger arrangements(int[] counts) {
        BigInteger result = BigInteger.ONE;
        int seen = 0;
        for (int c = 0; c < 26; c++) {
            int cc = counts[c];
            for (int i = 1; i <= cc; i++) {
                seen++;
                result = result.multiply(BigInteger.valueOf(seen))
                                .divide(BigInteger.valueOf(i));
            }
        }
        return result;
    }
}
