class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int size = obstacleGrid[0].length;
        int[] prev = new int[size];
        int[] curr = new int[size];

        Arrays.fill(prev, 0);
        prev[size - 1] = 1;

        for (int row = obstacleGrid.length - 1; row >= 0; row--) {
            if (obstacleGrid[row][size - 1] == 1 || prev[size - 1] == 0) {
                curr[size - 1] = 0;
            } else {
                curr[size - 1] = 1;
            }
            for (int col = size - 2; col >= 0; col--) {
                if (obstacleGrid[row][col] == 1) {
                    curr[col] = 0;
                } else {
                    curr[col] = curr[col + 1] + prev[col];
                }
            }
            prev = curr;
        }

        return curr[0];
    }
}