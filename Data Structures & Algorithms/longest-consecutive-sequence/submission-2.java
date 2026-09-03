class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        int curLen = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i]-1)) {
                continue;
            } 

            System.out.println(i);

            curLen = 1;
            int j = nums[i] + 1;
            while (numSet.contains(j)) {
                curLen++;
                j++;
            }

            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }

        return maxLen;
    }
}
