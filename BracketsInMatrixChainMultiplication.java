class Solution {
    static String matrixChainOrder(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] split = new int[n][n];
        String[][] result = new String[n][n];


        for (int i = 1; i < n; i++) {
            result[i][i] = Character.toString((char) ('A' + i - 1));
        }


        for (int len = 2; len < n; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                        result[i][j] = "(" + result[i][k] + result[k + 1][j] + ")";
                    }
                }
            }
        }

        return result[1][n - 1];
    }
}