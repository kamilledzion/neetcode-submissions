class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var mapOfCounts = new HashMap<Integer, Integer>();

        for (int i : nums) {
            mapOfCounts.compute(i, (key, v) -> v == null ? 1 : v + 1);
        }

        var queue = new PriorityQueue<NumsCount>(
            (NumsCount n1, NumsCount n2) -> Integer.compare(n1.count, n2.count));
        for (int num : mapOfCounts.keySet()) {
            var numCount = new NumsCount(num, mapOfCounts.get(num));

            if (queue.size() < k) {
                queue.offer(numCount);
            } else if (numCount.count > queue.peek().count) {
                queue.poll();
                queue.offer(numCount);
            }
        }

        return queue.stream().mapToInt(numCount -> numCount.num).toArray();
    }

    private record NumsCount(int num, int count) {}
}
