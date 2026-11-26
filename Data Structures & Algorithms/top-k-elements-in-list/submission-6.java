class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int min = -1000;
        int max = 1000;
        int range = max - min + 1;

        int[] buckets = new int[range];

        for (int num : nums) {
            buckets[num - min]++;
        }

        var queue = new PriorityQueue<NumsCount>(
            (NumsCount n1, NumsCount n2) -> Integer.compare(n1.count, n2.count));
        for (int i = 0; i < buckets.length; i++) {
            var numCount = new NumsCount(i + min, buckets[i]);

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
