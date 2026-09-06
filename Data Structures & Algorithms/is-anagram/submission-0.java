class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>(26);

        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Integer val = map.get(t.charAt(i));
            if (val == null || val == 0) {
                return false;
            }
            map.put(t.charAt(i), val - 1);
        }

        return true;
    }
}
