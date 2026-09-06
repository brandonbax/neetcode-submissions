class Solution {
    public int findMin(int[] nums) {
        // Two cases:
        // case 1: rotated mod n times
        // can be detected by checking first and last
        // smallest will be first element
        // case 2: otherwise
        // smallest will in a 'well'

        int n = nums.length;
        if (n == 1 || nums[0] < nums[n-1]) {
            return nums[0];
        }

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half.
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half.
                right = mid;
            }
        }
        return nums[left];
    }
}
