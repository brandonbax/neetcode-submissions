class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int curArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }
                maxArea = Math.max(maxArea, bfs(row, col, grid));
            }
        }

        return maxArea;
    }

    private int bfs(int startRow, int startCol, int[][] grid) {
        int area = 1;
        grid[startRow][startCol] = 0;

        if (startRow >= 1 && grid[startRow-1][startCol] == 1) {
            area += bfs(startRow-1, startCol, grid);
        } 
        
        if (startCol >= 1 && grid[startRow][startCol-1] == 1) {
            area += bfs(startRow, startCol-1, grid);
        }

        if (startRow < grid.length-1 && grid[startRow+1][startCol] == 1) {
            area += bfs(startRow+1, startCol, grid);
        }

        if (startCol < grid[0].length-1 && grid[startRow][startCol+1] == 1) {
            area += bfs(startRow, startCol+1, grid);
        }

        return area;
    }
}
