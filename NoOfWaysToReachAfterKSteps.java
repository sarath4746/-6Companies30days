class Solution {


    public int numberOfWays(int start, int end, int k) {

        int MOD = 1_000_000_007;
        int diff = end - start;

        if ((diff + k) % 2 != 0 || Math.abs(diff) > k) {
            return 0;
        }

        int r = (diff + k) / 2;

        if (r < 0 || r > k) {
            return 0;
        }

        long[] fact = new long[k + 1];
        long[] invFact = new long[k + 1];
        fact[0] = invFact[0] = 1;

        for (int i = 1; i <= k; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[k] = modInverse(fact[k], MOD);
        for (int i = k - 1; i >= 1; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        return (int) (fact[k] * invFact[r] % MOD * invFact[k - r] % MOD);
    }

    private long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private long pow(long a, int b, int mod) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return result;
    }
}
