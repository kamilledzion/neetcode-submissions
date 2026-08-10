class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            queue.add(s);
        }
        while (queue.size() > 1) {
            var x = queue.poll();
            var y = queue.poll();
            var result = Math.abs(x - y);
            if (result != 0) {
                queue.add(result);
            }
        }

        return queue.size() == 0 ? 0 : queue.peek();
    }
}
