class Solution {
    public int climbStairs(int n) {
        int[] res = new int[n + 1];

        int i = 0;
        while (i <= n) {
            if (i <= 1) {
                res[i] = 1;
            } else {
                res[i] = res[i - 1] + res[i - 2];
            }
            i++;
        }

        return res[n];
    }
}
