class Solution {

    static final long MOD = 1000000007;

    public int zigZagArrays(long n, int l, int r) {

        int m = r - l + 1;

        int size = 2 * m;

        // Base for length=2
        long[] base = new long[size];

        for (int x = 0; x < m; x++) {

            base[x] = x;

            base[m + x] =
                    m - x - 1;
        }

        if (n == 2) {
            long ans = 0;

            for (long v : base)
                ans = (ans + v) % MOD;

            return (int) ans;
        }

        long[][] T =
                buildMatrix(m);

        long[][] power =
                matrixPower(
                        T,
                        n - 2
                );

        long[] result =
                multiply(
                        power,
                        base
                );

        long ans = 0;

        for (long x : result)
            ans =
                    (ans + x)
                    % MOD;

        return (int) ans;
    }

    long[][] buildMatrix(int m) {

        int size = 2 * m;

        long[][] mat =
                new long[size][size];

        for (int x = 0; x < m; x++) {

            // up[x]
            for (int y = 0; y < x; y++) {

                mat[x][m + y] = 1;
            }

            // down[x]
            for (int y = x + 1; y < m; y++) {

                mat[m + x][y] = 1;
            }
        }

        return mat;
    }

    long[][] matrixPower(
            long[][] A,
            long exp
    ) {

        int n = A.length;

        long[][] res =
                new long[n][n];

        for (int i = 0; i < n; i++)
            res[i][i] = 1;

        while (exp > 0) {

            if ((exp & 1) == 1)
                res =
                        multiply(
                                res,
                                A
                        );

            A =
                    multiply(
                            A,
                            A
                    );

            exp >>= 1;
        }

        return res;
    }

    long[][] multiply(
            long[][] A,
            long[][] B
    ) {

        int n = A.length;

        long[][] C =
                new long[n][n];

        for (
                int i = 0;
                i < n;
                i++
        ) {

            for (
                    int k = 0;
                    k < n;
                    k++
            ) {

                if (A[i][k] == 0)
                    continue;

                for (
                        int j = 0;
                        j < n;
                        j++
                ) {

                    C[i][j] =
                            (
                                    C[i][j]
                                            +
                                            A[i][k]
                                                    *
                                                    B[k][j]
                            )
                                    % MOD;
                }
            }
        }

        return C;
    }

    long[] multiply(
            long[][] A,
            long[] V
    ) {

        int n = A.length;

        long[] res =
                new long[n];

        for (
                int i = 0;
                i < n;
                i++
        ) {

            for (
                    int j = 0;
                    j < n;
                    j++
            ) {

                res[i] =
                        (
                                res[i]
                                        +
                                        A[i][j]
                                                *
                                                V[j]
                        )
                                % MOD;
            }
        }

        return res;
    }
}