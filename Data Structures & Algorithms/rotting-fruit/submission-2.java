class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        var maxRow = grid.length;
        var maxCol = grid[0].length;
        var fresh = 0;

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == 2) {
                    queue.addLast(new int[] { row, col });
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] direction = new int[][] {
            { -1,  0 },
            {  1,  0 },
            {  0, -1 },
            {  0,  1 },
        };
        var min = -1;
        while (!queue.isEmpty()) {
            var size = queue.size();
            if (size > 0) {
                min++;
            }
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.pollFirst();
                for (int[] d : direction) {
                    int nextRow = rotten[0] + d[0];
                    int nextCol = rotten[1] + d[1];

                    if (nextRow >= 0 && nextRow < maxRow &&
                        nextCol >= 0 && nextCol < maxCol &&
                        grid[nextRow][nextCol] == 1) {

                        grid[nextRow][nextCol] = 2;
                        queue.addLast(new int[] { nextRow, nextCol});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? min : -1;
    }
}
