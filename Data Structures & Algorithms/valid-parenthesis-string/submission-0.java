class Solution {
    public boolean checkValidString(String s) {
        // Stacks to store the INDICES of '(' and '*'
        Deque<Integer> openStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                // It's a ')'. Try to match with an open bracket first.
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } 
                // If no open brackets, try to use a star.
                else if (!starStack.isEmpty()) {
                    starStack.pop();
                } 
                // If neither are available, the string is invalid.
                else {
                    return false;
                }
            }
        }

        // Match any remaining '(' with remaining '*'
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            // If the '(' appears AFTER the '*', the star cannot act as a ')'
            if (openStack.pop() > starStack.pop()) {
                return false;
            }
        }

        // If we successfully matched all '(', it will be empty
        return openStack.isEmpty();
    }
}