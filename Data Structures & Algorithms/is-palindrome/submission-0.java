class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (right > 0 && left < chars.length - 1 && left < right) {
            // System.out.println(left);
            // System.out.println(right + "\n");
            if (!Character.isLetterOrDigit(chars[left])) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[right])) {
                right--;
                continue;
            }

            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
