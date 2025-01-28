class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] stones = new int[n][2];

        for (int i = 0; i < n; i++) {
            stones[i][0] = aliceValues[i] + bobValues[i];
            stones[i][1] = i;
        }

        Arrays.sort(stones, (a, b) -> b[0] - a[0]);

        int aliceScore = 0, bobScore = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                aliceScore += aliceValues[stones[i][1]];
            } else {
                bobScore += bobValues[stones[i][1]];
            }
        }

        if (aliceScore > bobScore) return 1;
        if (bobScore > aliceScore) return -1;
        return 0;
    }
}