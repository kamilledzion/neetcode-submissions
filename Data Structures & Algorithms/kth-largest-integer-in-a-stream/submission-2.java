class KthLargest {

    PriorityQueue<Integer> queue;
    int kth;
    public KthLargest(int k, int[] nums) {
        kth = k;
        queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        if (queue.size() > kth) {
            queue.poll();
        }
        return queue.peek();
    }
}
