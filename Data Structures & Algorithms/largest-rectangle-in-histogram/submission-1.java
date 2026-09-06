class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = heights[0];

        for (int i = 0; i < heights.length; i++) {
            int left = i;

            while (!stack.isEmpty() && heights[i] < stack.peekFirst()[1]) {
                int[] popped = stack.removeFirst();
                maxArea = Math.max(maxArea, popped[1] * (i - popped[0]));
                left = popped[0];
            }

            stack.addFirst(new int[]{left, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] popped = stack.removeFirst();
            maxArea = Math.max(maxArea, popped[1] * (heights.length - popped[0]));
        }

        return maxArea;
    }
}

