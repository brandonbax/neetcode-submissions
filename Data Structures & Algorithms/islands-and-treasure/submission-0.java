class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.addLast(new int[]{r, c});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cell = queue.removeFirst();
            int r = cell[0];
            int c = cell[1];
            
            for (int[] dir : directions) {
                int nextRow = r + dir[0];
                int nextCol = c + dir[1];
                
                if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols) {
                    continue;
                }
                
                if (grid[nextRow][nextCol] != Integer.MAX_VALUE) { 
                    continue;
                }
                
                grid[nextRow][nextCol] = grid[r][c] + 1;
                
                queue.addLast(new int[]{nextRow, nextCol});
            }
        }
    }
}