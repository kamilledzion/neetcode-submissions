class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> open = Map.of('(', ')', '{', '}', '[', ']');
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            var value = s.charAt(i);
            if (open.containsKey(value)) {
                deque.addLast(value);
            } else {
                if (open.get(deque.pollLast()) != value) {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
