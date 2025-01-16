class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        int maxWordLength = 0;

        for (String word : wordDict) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = Math.max(0, i - maxWordLength); j < i; j++) {

                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
                
            }
        }

        return dp[s.length()];
    }
}