class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c, visited));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || 
            grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        return 1 + dfs(grid, row - 1, col, visited)
                 + dfs(grid, row + 1, col, visited)
                 + dfs(grid, row, col - 1, visited)
                 + dfs(grid, row, col + 1, visited);
    }
}