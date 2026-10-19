class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        Deque<Integer> count = new ArrayDeque<>();

        for (Character l : s.toCharArray()) {            
            int inc = 0;
            if (deque.peekLast() == l) {
                inc = count.pollLast() + 1;
                count.addLast(inc);
            } else {
                count.addLast(1);
            }
            deque.addLast(l);
            
            if (inc == k) {
                count.pollLast();
                while (inc > 0) {
                    deque.pollLast();
                    inc--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (Character l : deque) {
            res.append(l);
        }
        return res.toString();
    }
}