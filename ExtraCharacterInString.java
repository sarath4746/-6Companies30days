class Solution {
    public int minExtraChar(String s, String[] dictionary) {

        int n = s.length();

        Set<String> dictSet = new HashSet<>(Arrays.asList(dictionary));

        int[] dp = new int[n + 1];

        Arrays.fill(dp, n);
        
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (dictSet.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }
}