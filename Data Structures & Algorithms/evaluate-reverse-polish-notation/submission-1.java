class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token: tokens) {
            Integer y;
            Integer x;
            switch (token) {
                case "+":
                    y = stack.removeFirst();
                    x = stack.removeFirst();
                    stack.addFirst(x + y);
                    break;
                case "-":
                    y = stack.removeFirst();
                    x = stack.removeFirst();
                    stack.addFirst(x - y);
                    break;
                case "*":
                    y = stack.removeFirst();
                    x = stack.removeFirst();
                    stack.addFirst(x * y);
                    break;
                case "/":
                    y = stack.removeFirst();
                    x = stack.removeFirst();
                    // System.out.println(y);
                    // System.out.println(x);
                    stack.addFirst(x / y);
                    break;
                default:
                    stack.addFirst(Integer.parseInt(token));
                    break;
            }
        }

        return stack.removeFirst();
    }
}
