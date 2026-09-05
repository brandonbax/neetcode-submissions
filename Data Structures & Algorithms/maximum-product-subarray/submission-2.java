class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int newArray = nums[i];
            int newMin = min * nums[i];
            int newMax = max * nums[i];

            max = Math.max(newArray, Math.max(newMin, newMax));
            min = Math.min(newArray, Math.min(newMin, newMax));
            globalMax = Math.max(globalMax, max);
        }

        return globalMax;
    }
}
