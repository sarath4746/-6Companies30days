class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int share = 0, total = 0;

        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % mod;
            }
            if (day - forget >= 1) {
                share = (share - dp[day - forget] + mod) % mod;
            }

            dp[day] = share;
        }

        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                total = (total + dp[day]) % mod;
            }
        }

        return total;
    }
}
