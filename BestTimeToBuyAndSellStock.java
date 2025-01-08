class Solution {
    public int maxProfit(int k, int[] prices) {
    int n = prices.length;

    int[][] dp1 = new int[2][k + 2];
    int[][] dp2 = new int[2][k + 2];

    for (int i = n - 1; i >= 0; i--) {
        for (int j = 1; j >= 0; j--) {
            for (int l = 1; l <= k; l++) {
                int profit = 0;

                if (j == 1) {
                    int sell = prices[i] + dp2[0][l - 1];
                    int skip = 0 + dp2[1][l];
                    profit += Math.max(sell, skip);
                } else {
                    int buy = -prices[i] + dp2[1][l];
                    int skip = 0 + dp2[0][l];
                    profit += Math.max(buy, skip);
                }
                
                dp1[j][l] = profit;
            }
        }
        dp2 = dp1;
    }
    return dp2[0][k];
}

}