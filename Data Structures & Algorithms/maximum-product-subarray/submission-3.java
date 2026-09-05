class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            int newMax = Math.max(x, Math.max(min * x, max * x));
            int newMin = Math.min(x, Math.min(min * x, max * x));

            min = newMin;
            max = newMax;

            globalMax = Math.max(globalMax, max);
        }

        return globalMax;
    }
}