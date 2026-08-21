class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        int[] curr = new int[n];
        Arrays.fill(prev, 0);

        var row = 0;
        while (row < m) {
            curr[n - 1] = 1;
            for (int col = n - 2; col >= 0; col--) {
                curr[col] = prev[col] + curr[col + 1];
            }
            prev = curr;
            row++;
        }


        return curr[0];
    }
}
