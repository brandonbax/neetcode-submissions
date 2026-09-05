class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // Only trigger the search if we find land
                if (grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, row, col));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        // Base case: Out of bounds OR current cell is water (0)
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        // Mark current land as visited by "sinking" it
        grid[row][col] = 0;

        // Area is 1 (current cell) + the area of all adjacent land
        return 1 + dfs(grid, row - 1, col)
                 + dfs(grid, row + 1, col)
                 + dfs(grid, row, col - 1)
                 + dfs(grid, row, col + 1);
    }
}