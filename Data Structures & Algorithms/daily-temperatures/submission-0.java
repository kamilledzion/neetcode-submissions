class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> deq = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        deq.addLast(new int[]{temperatures[0], 0});
        for (int i = 1; i < temperatures.length; i++) {
            
            int temp = temperatures[i];
            while (!deq.isEmpty() && temp > deq.peekLast()[0]) {
                int[] prev = deq.pollLast();
                res[prev[1]] = i - prev[1];
            }
            
            deq.addLast(new int[]{temp, i});
        }

        return res;
    }
}
