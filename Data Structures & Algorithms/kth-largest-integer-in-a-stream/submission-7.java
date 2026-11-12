class KthLargest {

    PriorityQueue<Integer> mem;
    int kth;
    public KthLargest(int k, int[] nums) {
        kth = k;
        mem = new PriorityQueue<>();
        for (int n : nums) {
            mem.offer(n);
            if (mem.size() > kth) {
                mem.poll();
            }
        }
    }
    
    public int add(int val) {
        mem.offer(val);
        if (mem.size() > kth) {
            mem.poll();
        }
        return mem.peek();
    }
}
