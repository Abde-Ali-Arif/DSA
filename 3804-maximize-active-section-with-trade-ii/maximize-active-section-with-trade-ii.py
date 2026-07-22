from bisect import bisect_left, bisect_right
from typing import List

class Solution:
    def maxActiveSectionsAfterTrade(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        total_ones = s.count('1')

        # 1) find maximal runs of '1's
        runs = []
        i = 0
        while i < n:
            if s[i] == '1':
                j = i
                while j < n and s[j] == '1':
                    j += 1
                runs.append((i, j - 1))
                i = j
            else:
                i += 1

        k = len(runs)
        if k == 0:
            return [0] * len(queries)

        a = [r[0] for r in runs]
        b = [r[1] for r in runs]
        Lz = [0] * k
        Rz = [0] * k
        for idx in range(k):
            left_zero_start = b[idx - 1] + 1 if idx > 0 else 0
            Lz[idx] = a[idx] - left_zero_start
            right_zero_end = a[idx + 1] - 1 if idx < k - 1 else n - 1
            Rz[idx] = right_zero_end - b[idx]

        val = [Lz[i] + Rz[i] for i in range(k)]

        # sparse table for range-max on val
        sp = [val[:]]
        jlvl = 1
        while (1 << jlvl) <= k:
            prev = sp[-1]
            half = 1 << (jlvl - 1)
            length = 1 << jlvl
            cur = [max(prev[x], prev[x + half]) for x in range(k - length + 1)]
            sp.append(cur)
            jlvl += 1

        def range_max(l, r):
            if l > r:
                return None
            length = r - l + 1
            jj = length.bit_length() - 1
            return max(sp[jj][l], sp[jj][r - (1 << jj) + 1])

        ans = []
        for ql, qr in queries:
            p = bisect_right(a, ql)              # first run with a_i > ql
            q = bisect_left(b, qr) - 1            # last run with b_i < qr

            gain = 0
            if p < k and q >= 0 and p <= q:
                if p == q:
                    gain = min(Lz[p], a[p] - ql) + min(Rz[p], qr - b[p])
                else:
                    best = min(Lz[p], a[p] - ql) + Rz[p]
                    best2 = Lz[q] + min(Rz[q], qr - b[q])
                    gain = max(best, best2)
                    if p + 1 <= q - 1:
                        rm = range_max(p + 1, q - 1)
                        if rm is not None:
                            gain = max(gain, rm)

            ans.append(total_ones + max(0, gain))

        return ans