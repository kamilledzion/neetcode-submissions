class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        int a = 0;
        int b = 0;
        Set<String> op = Set.of("+", "-", "*", "/");

        for (String t : tokens) {
            if (op.contains(t)) {
                b = s.pop();
                a = s.pop();
                if (t.equals("+")) {
                    s.push(a + b);
                } else if (t.equals("-")) {
                    s.push(a - b);
                } else if (t.equals("*")) {
                    s.push(a * b);
                } else if (t.equals("/")) {
                    s.push(a / b);
                }
            } else {
                s.push(Integer.parseInt(t));
            }
        }

        return s.pop();
    }
}
