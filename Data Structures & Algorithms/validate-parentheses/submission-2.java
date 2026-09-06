class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                stack.addFirst(map.get(s.charAt(i)));
            } else {
                if (stack.isEmpty() || s.charAt(i) != stack.removeFirst()) {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
