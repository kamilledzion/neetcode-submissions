class Solution {
    public int calPoints(String[] operations) {
  Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < operations.length; i++) {
            var value = operations[i];
            if (value.equals("+")) {
                var first = !deque.isEmpty() ? deque.pollLast() : 0;
                var second = !deque.isEmpty() ? deque.peekLast() : 0;
                deque.add(first);
                deque.add(first + second);
            } else if (value.equals("D")) {
                int last = !deque.isEmpty() ? deque.peekLast() : 0;
                deque.add(last * 2);
            } else if (value.equals("C")) {
                deque.pollLast();
            } else {
                deque.add(Integer.valueOf(value));
            }
        }
        return deque.stream().reduce(0, (a, b) -> a + b).intValue();
    }
}