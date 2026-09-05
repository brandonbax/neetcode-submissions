class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Direction arrays to easily check up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int currentArea = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    
                    queue.offer(new int[]{r, c});
                    grid[r][c] = 0; // Mark visited immediately to prevent duplicates

                    // BFS traversal for the current island
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        currentArea++;

                        // Check all 4 neighbors
                        for (int[] dir : directions) {
                            int nextRow = cell[0] + dir[0];
                            int nextCol = cell[1] + dir[1];

                            // If neighbor is valid land, add to queue and mark visited
                            if (nextRow >= 0 && nextRow < rows && 
                                nextCol >= 0 && nextCol < cols && 
                                grid[nextRow][nextCol] == 1) {
                                
                                queue.offer(new int[]{nextRow, nextCol});
                                grid[nextRow][nextCol] = 0; 
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }
}