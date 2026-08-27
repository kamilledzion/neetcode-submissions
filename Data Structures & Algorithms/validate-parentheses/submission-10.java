class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        Map<Character, Character> map = Map.of(
            '(', ')', 
            '{', '}',
            '[', ']'
        );

        for (Character ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                deque.addLast(ch);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                Character lastKey = deque.pollLast();
                if (!map.get(lastKey).equals(ch)) {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
