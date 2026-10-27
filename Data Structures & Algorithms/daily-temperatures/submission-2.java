class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s = new Stack<>();
        int[] res = new int[temperatures.length];

        s.push(new int[]{temperatures[0], 0});
        for (int i = 1; i < temperatures.length; i++) {
            int curr = temperatures[i];

            while (!s.isEmpty() && s.peek()[0] < curr) {
                int[] val = s.pop();
                int prevIdx = val[1];
                res[prevIdx] = i - prevIdx;
            }
            s.push(new int[]{curr, i});
        }

        return res;
    }
}
