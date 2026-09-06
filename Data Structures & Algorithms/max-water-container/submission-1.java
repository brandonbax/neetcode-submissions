class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int hLeft = heights[left];
            int hRight = heights[right];
            
            if (hLeft < hRight) {
                // The bottleneck is the left side
                maxWater = Math.max(maxWater, hLeft * (right - left));
                
                // Skip all inner lines that are shorter or equal to hLeft
                while (left < right && heights[left] <= hLeft) {
                    left++;
                }
            } else {
                // The bottleneck is the right side (or they are equal)
                maxWater = Math.max(maxWater, hRight * (right - left));
                
                // Skip all inner lines that are shorter or equal to hRight
                while (left < right && heights[right] <= hRight) {
                    right--;
                }
            }
        }

        return maxWater;
    }
}