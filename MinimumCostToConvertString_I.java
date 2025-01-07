class Solution {
    private static final int CHAR_COUNT = 26;
    private static final int INF = Integer.MAX_VALUE / 2;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[CHAR_COUNT][CHAR_COUNT];
        
        for (int[] row : graph) {
            Arrays.fill(row, INF);
        }
        
        for (int i = 0; i < CHAR_COUNT; i++) {
            graph[i][i] = 0;
        }
        
        for (int i = 0; i < cost.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            graph[from][to] = Math.min(graph[from][to], cost[i]);
        }

        for (int k = 0; k < CHAR_COUNT; k++) {
            for (int i = 0; i < CHAR_COUNT; i++) {
                if (graph[i][k] < INF) {
                    for (int j = 0; j < CHAR_COUNT; j++) {
                        if (graph[k][j] < INF) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }

        return computeCost(source, target, graph);
    }

    private long computeCost(String source, String target, int[][] graph) {
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int srcChar = source.charAt(i) - 'a';
            int tgtChar = target.charAt(i) - 'a';
            if (srcChar != tgtChar) {
                if (graph[srcChar][tgtChar] == INF) {
                    return -1L;
                }
                totalCost += graph[srcChar][tgtChar];
            }
        }
        return totalCost;
    }
}