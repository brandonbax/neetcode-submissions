class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> numSet = new HashSet<>(n);

        for (int num: nums) {
            numSet.add(num);
        }

        if (numSet.size() != n) {
            return true;
        } else {
            return false;
        }
    }
}