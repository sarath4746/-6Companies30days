class Solution {
    public int minDays(int[][] grid) {
      if (!isConnected(grid)) return 0;
        
        int rows = grid.length, cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (!isConnected(grid)) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        
        return 2;
    }
    
    private boolean isConnected(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (count > 0) return false;
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        
        return count == 1;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int rows = grid.length, cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0 || visited[i][j]) return;
        
        visited[i][j] = true;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}