class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            complements.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer num = complements.get(nums[i]);
            if (num == null || num == i) {
                continue;
            }

            return (i < num) ? new int[]{i, num} : new int[]{num, i};
        }

        return new int[2];
    }
}
