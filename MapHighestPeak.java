class Solution {
    public int[][] highestPeak(int[][] water) {
        int rows = water.length;
        int cols = water[0].length;
        int[][] heights = new int[rows][cols];
        boolean[][] seen = new boolean[rows][cols];
        java.util.Queue<int[]> q = new java.util.LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (water[i][j] == 1) {
                    heights[i][j] = 0;
                    seen[i][j] = true;
                    q.add(new int[]{i, j});
                } else {
                    heights[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !seen[nx][ny]) {
                    heights[nx][ny] = heights[x][y] + 1;
                    seen[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return heights;
    }
}
