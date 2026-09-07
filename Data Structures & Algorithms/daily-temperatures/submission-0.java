class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peekFirst()[1] < temperatures[i]) {
                int[] day = stack.removeFirst();
                res[day[0]] = i - day[0];
            }
            stack.addFirst(new int[]{i, temperatures[i]});
        }

        while (!stack.isEmpty()) {
            int[] day = stack.removeFirst();
            res[day[0]] = 0;
        }

        return res;
    }
}
