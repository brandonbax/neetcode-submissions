class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (Math.abs(target) > sum) {
            return 0;
        }

        int[] cur = new int[2 * sum + 1];
        int offset = sum;

        cur[offset] = 1;

        for (int num: nums) {
            int[] next = new int[2 * sum + 1]; 

            for (int i = -sum; i <= sum; i++) {
                int idx = i + offset;

                if (cur[idx] != 0) {
                    next[num + i + offset] += cur[idx];
                    next[i - num + offset] += cur[idx];
                }
            }

            cur = next;
        }

        return cur[target + offset];
        
    }
}
